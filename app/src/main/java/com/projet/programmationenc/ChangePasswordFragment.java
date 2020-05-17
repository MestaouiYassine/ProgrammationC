package com.projet.programmationenc;

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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChangePasswordFragment extends Fragment {
    private static final String TAG = "ChangePasswordFragment";
    private EditText edtpassword1change,edtpassword2change;
    private Button btnconfirmchange;
    private String password1change,password2change;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private Student S;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_changepassword,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        edtpassword1change = view.findViewById(R.id.edtpassword1change);
        edtpassword2change = view.findViewById(R.id.edtpassword2change);
        btnconfirmchange = view.findViewById(R.id.btnconfirmchange);

        btnconfirmchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password1change = edtpassword1change.getText().toString();
                password2change = edtpassword2change.getText().toString();
                boolean flag = true;

                if(password2change.isEmpty()) {
                    edtpassword2change.setError("Veuillez retaper le mot de passe.");
                    flag = false;
                }

                if(password1change.isEmpty()) {
                    edtpassword1change.setError("Veuillez saisir le mot de passe.");
                    flag = false;
                }
                else if(password1change.length() < 6) {
                    edtpassword1change.setError("Le mot de passe doit contenir au moins 6 caractères.");
                    flag = false;
                }
                else {
                    if(!password1change.equals(password2change)) {
                        Toast.makeText(getContext(),"Les deux mots de passes ne sont pas identiques.",Toast.LENGTH_SHORT).show();
                        flag = false;
                    }
                }

                if(!flag) {
                    return;
                }
                else {
                    AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(),((HomeActivity) getActivity()).retrievedPassword);
                    user.reauthenticate(authCredential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Log.e(TAG, "onComplete: hahwa reauthenticata");
                            user.updatePassword(password1change).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.e(TAG, "onComplete: Password updates successfully");
                                    databaseReference.child("Etudiants").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                S = snapshot.getValue(Student.class);
                                                if(S.id.equals(user.getUid())) {
                                                    S.setPassword(password1change);
                                                    databaseReference.child("Etudiants").child(user.getUid()).removeValue();
                                                    databaseReference.child("Etudiants").child(user.getUid()).setValue(S);
                                                    Toast.makeText(getContext(),"Changement reussi du mot de passe",Toast.LENGTH_SHORT).show();
                                                    break;
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}
