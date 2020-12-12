package com.projet.programmationenc.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.projet.programmationenc.Moduls.Student;
import com.projet.programmationenc.R;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private Button btnreturn,btnsignin;
    private TextView txtvsignup,txtvforgotten;
    private TextInputLayout edtemail,edtpassword;
    private ProgressBar progressBar;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private Student S;
    private String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnreturn = findViewById(R.id.btnreturnlogin);
        btnsignin = findViewById(R.id.btnsigninlogin);
        edtemail = findViewById(R.id.edtemaillogin);
        edtpassword = findViewById(R.id.edtpasswordlogin);
        txtvforgotten = findViewById(R.id.txtvforgotten);
        txtvsignup = findViewById(R.id.txtvsignuplogin);
        progressBar = findViewById(R.id.progressBarlogin);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


        txtvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        txtvforgotten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Saisir votre email");
                final EditText input = new EditText(LoginActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                builder.setView(input);

                builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String emailoublie = input.getText().toString();
                        mAuth.sendPasswordResetEmail(emailoublie).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "Email sent.");
                                            Toast.makeText(LoginActivity.this,"Un email vous a été envoyé pour réinitialiser votre mot de passe",Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            Toast.makeText(LoginActivity.this,"Erreur lors de l'envoi de l'email de vérification",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                });
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtemail.getEditText().getText().toString();
                password = edtpassword.getEditText().getText().toString();

                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,6}";
                boolean flag = true;
                if(email.isEmpty()) {
                    edtemail.setError("Veuillez saisir l'e-mail");
                    flag = false;
                }
                else if(!email.matches(emailPattern)) {
                    edtemail.setError("Email invalide");
                    flag = false;
                }
                if(!email.isEmpty() && email.matches(emailPattern)) {
                    edtemail.setErrorEnabled(false);
                }

                if(password.isEmpty()) {
                    edtpassword.setError("Veuillez saisir le mot de passe");
                    flag = false;
                }
                else {
                    edtpassword.setErrorEnabled(false);
                }

                if(flag == false) {
                    return;
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                user = mAuth.getCurrentUser();
                                boolean emailVerified = user.isEmailVerified();
                                if(emailVerified) {
                                    Log.d(TAG, "signInWithEmail:success");
                                    SetStudentPassword(password);

                                    FirebaseInstanceId.getInstance().getInstanceId()
                                            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                                    if (!task.isSuccessful()) {
                                                        Log.w(TAG, "getInstanceId failed", task.getException());
                                                        return;
                                                    }

                                                    // Get new Instance ID token
                                                    String token = task.getResult().getToken();
                                                    Log.e(TAG, "onComplete: token : " + token );
                                                    databaseReference.child("Students").child(user.getUid()).child("token").setValue(token);
                                                }
                                            });
                                    edtemail.getEditText().setText(null);
                                    edtpassword.getEditText().setText(null);
                                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                }
                                else {
                                    Toast.makeText(LoginActivity.this,"Veuillez vérifier votre email avant de vous connecter.",Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Adresse email ou mot de passe invalide.", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }
        });

    }

    public void SetStudentPassword(String password) {
        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    if(!password.equals(S.getPass())) {
                        S.setPass(password);
                        databaseReference.child("Students").child(user.getUid()).child("pass").setValue(S.getPass());
                        Log.e(TAG, "onDataChange: Reset password modification done : " + S.getPass());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }

}
