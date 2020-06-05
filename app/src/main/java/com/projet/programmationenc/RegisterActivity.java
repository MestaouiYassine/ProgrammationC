package com.projet.programmationenc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private TextInputLayout edtemail,edtfirstname,edtlastname,edtpassword1,edtpassword2;
    private Button btnregister,btnreturn;
    private ProgressBar progressBar;
    private String email,firstname,lastname,password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtemail = findViewById(R.id.edtemailregist);
        edtfirstname = findViewById(R.id.edtfirstnameregist);
        edtlastname = findViewById(R.id.edtlastnameregist);
        edtpassword1 = findViewById(R.id.edtpassword1regist);
        edtpassword2 = findViewById(R.id.edtpassword2regist);
        btnregister = findViewById(R.id.btnregister);
        btnreturn = findViewById(R.id.btnreturnregist);
        progressBar = findViewById(R.id.progressBarregister);

        mAuth = FirebaseAuth.getInstance();

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtemail.getEditText().getText().toString().trim();
                firstname = edtfirstname.getEditText().getText().toString();
                lastname = edtlastname.getEditText().getText().toString();
                password1 = edtpassword1.getEditText().getText().toString();
                password2 = edtpassword2.getEditText().getText().toString();

                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,6}";
                boolean flag = true;
                if(email.isEmpty()) {
                    edtemail.setError("Veuillez saisir l'e-mail.");
                    flag = false;
                }
                else if(!email.matches(emailPattern)) {
                    edtemail.setError("Email invalide");
                    flag = false;
                }

                if(firstname.isEmpty()) {
                    edtfirstname.setError("Veuillez saisir le prénom.");
                    flag = false;
                }

                if(lastname.isEmpty()) {
                    edtlastname.setError("Veuillez saisir le nom.");
                    flag = false;
                }

                if(password2.isEmpty())
                {
                    edtpassword2.setError("Veuillez retaper le mot de passe.");
                    flag = false;
                }

                if(password1.isEmpty()) {
                    edtpassword1.setError("Veuillez saisir le mot de passe.");
                    flag = false;
                }
                else if(password1.length() < 6) {
                    edtpassword1.setError("Le mot de passe doit contenir au moins 6 caractères.");
                    flag = false;
                }
                else {
                    if(!password1.equals(password2)) {
                        Toast.makeText(RegisterActivity.this,"Les deux mots de passes ne sont pas identiques.",Toast.LENGTH_SHORT).show();
                        flag = false;
                    }
                }


                if(!flag) {
                    return;
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                String base_url = "http://192.168.1.105/progc/";

//                                Gson gson = new GsonBuilder()
//                                        .setLenient()
//                                        .create();

                                Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(base_url)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

                                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                                Call<Student> call = apiInterface.insertStudent(user.getUid(),firstname,lastname,password1,"android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round");

                                call.enqueue(new Callback<Student>() {
                                    @Override
                                    public void onResponse(Call<Student> call, Response<Student> response) {
                                        if(!response.isSuccessful()) {
                                            Log.e(TAG, "onResponse: Code " + response.code());
//                                            Toast.makeText(RegisterActivity.this,"Code : " + response.code(),Toast.LENGTH_LONG).show();
                                            return;
                                        }
                                        Log.e(TAG, "onResponse: " + "Data in mysql");
//                                        Student student = response.body();
//                                        Toast.makeText(RegisterActivity.this,"Data is in mysql now" + student.getFirstname(),Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onFailure(Call<Student> call, Throwable t) {
                                        Log.e(TAG, "onFailure: " + t.getMessage());
//                                        Toast.makeText(RegisterActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });

                                user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressBar.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "Email sent.");
                                            Toast.makeText(RegisterActivity.this,"Inscription réussie, une demande de validation vous a été envoyée à l'adresse " + email,Toast.LENGTH_LONG).show();
                                            FirebaseAuth.getInstance().signOut();
                                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                        }
                                    }
                                });



                            }else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Erreur lors de l'inscription.", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }


            }
        });
    }




}
