package com.projet.programmationenc;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private Button btnreturn,btnsignin;
    private TextView txtvsignup,txtvforgotten;
    private EditText edtemail,edtpassword;
    private ProgressBar progressBar;

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
                builder.setTitle("Réinitialiser le mot de passe");
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
                                            Toast.makeText(LoginActivity.this,"Password Reset Email sent",Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            Toast.makeText(LoginActivity.this,"Some error happened",Toast.LENGTH_LONG).show();
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
                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();

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

                if(password.isEmpty()) {
                    edtpassword.setError("Veuillez saisir le mot de passe");
                    flag = false;
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
                                FirebaseUser user = mAuth.getCurrentUser();
                                boolean emailVerified = user.isEmailVerified();
                                if(emailVerified) {
                                    Log.d(TAG, "signInWithEmail:success");
//                                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
//                                    dr.child("Etudiants").child(user.getUid()).child("emailVerif").setValue(true);
                                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                }
                                else {
                                    Toast.makeText(LoginActivity.this,"Veuillez vérifier votre email avant de vous connecter.",Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Erreur lors de la connexion.", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }

            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if(user != null) {
//            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
//        }
//    }
}
