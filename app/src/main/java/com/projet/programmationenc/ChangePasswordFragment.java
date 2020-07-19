package com.projet.programmationenc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChangePasswordFragment extends Fragment {
    private static final String TAG = "ChangePasswordFragment";
    private TextInputLayout edtpassword1change, edtpassword2change,edtoldpass;
    private Button btnconfirmchange;
    private String oldpassword,password1change, password2change;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private Student S;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_changepassword, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Changement du mot de passe");
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();


//        databaseReference = FirebaseDatabase.getInstance().getReference();
        edtpassword1change = view.findViewById(R.id.edtpassword1change);
        edtpassword2change = view.findViewById(R.id.edtpassword2change);
        btnconfirmchange = view.findViewById(R.id.btnconfirmchange);
        edtoldpass = view.findViewById(R.id.edtoldpass);

        btnconfirmchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldpassword = edtoldpass.getEditText().getText().toString();
                password1change = edtpassword1change.getEditText().getText().toString();
                password2change = edtpassword2change.getEditText().getText().toString();
                boolean flag = true;

                if(oldpassword.isEmpty()) {
                    edtoldpass.setError("Veuillez saisir le mot de passe actuel");
                    flag = false;
                }
                else {
                    edtoldpass.setErrorEnabled(false);
                }

                if (password2change.isEmpty()) {
                    edtpassword2change.setError("Veuillez retaper le mot de passe.");
                    flag = false;
                }
                else {
                    edtpassword2change.setErrorEnabled(false);
                }

                if (password1change.isEmpty()) {
                    edtpassword1change.setError("Veuillez saisir le mot de passe.");
                    flag = false;
                } else if (password1change.length() < 6) {
                    edtpassword1change.setError("Le mot de passe doit contenir au moins 6 caractères.");
                    flag = false;
                } else {
                    edtpassword1change.setErrorEnabled(false);
                    if (!password1change.equals(password2change)) {
                        Toast.makeText(getActivity(), "Les deux mots de passes ne sont pas identiques.", Toast.LENGTH_SHORT).show();
                        flag = false;
                    }
                    if(!oldpassword.equals(((HomeActivity)getActivity()).retrievedPassword)) {
                        Toast.makeText(getActivity(), "Le mot de passe actuel est incorrect", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if (!flag) {
                    return;
                } else {
                    edtpassword1change.setErrorEnabled(false);
                    AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), ((HomeActivity) getActivity()).retrievedPassword);
                    user.reauthenticate(authCredential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Log.e(TAG, "onComplete: hahwa reauthenticata");
                            user.updatePassword(password1change).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.e(TAG, "onComplete: Password updated successfully");

                                    ChangeStudentPassword();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public void ChangeStudentPassword() {
        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    S.setPass(password1change);
                    databaseReference.child("Students").child(user.getUid()).child("pass").setValue(S.getPass());
                    Toast.makeText(getActivity(), "Changement réussi du mot de passe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }
}
