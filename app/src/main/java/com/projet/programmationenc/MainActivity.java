package com.projet.programmationenc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnsignin;
    private TextView txtvsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin = findViewById(R.id.btnsignin);
        txtvsignup = findViewById(R.id.txtvsignup);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        txtvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        if (user != null) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            databaseReference.child("Students").child(user.getUid()).child("online").setValue(true);
        }
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
//        dr.child("Etudiants").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                final long millisec = 24*60*60*1000L;
//                for(final DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    final Etudiant E = snapshot.getValue(Etudiant.class);
//                    if(new Date().getTime() - E.dateCreation.getTime() > millisec && E.emailVerif == false) {
//                        try{
//                            FirebaseAuth.getInstance().deleteUser(E.id);
//                            Log.d(TAG, "Etudiant " + E.email + " a été supprimé de la base de données Firebase");
//                            snapshot.getRef().child(E.id).removeValue(new DatabaseReference.CompletionListener() {
//                                @Override
//                                public void onComplete(DatabaseError error, DatabaseReference ref) {
//                                    Log.d(TAG, "Etudiant " + E.email + " a été supprimé de la base de données");
//                                }
//                            });
//                        }catch(Exception e) {
//                            e.printStackTrace();
//                        }
//
//                        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                        AuthCredential ac = EmailAuthProvider.getCredential(E.email,E.mdp);
//                        user.reauthenticate(ac).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                E.dateSuppression = new Date();
//                                user.delete();
//                                Log.d(TAG, "L'etudiant " + E.nom + " " + E.prenom + " a été supprimé car son compte n'a pas été vérifié Date creation : " + E.dateCreation + " Date suppresion : " + E.dateSuppression);
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//        if(user != null) {
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//        }
//    }
}
