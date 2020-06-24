package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CircleImageView imgvavatarprofile;
    private TextView txtvfullnameprofile, txtvstatusprofile;
    private ImageButton btnchangestatus;
    private Button btnsendrequest;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String fullname, status;
    private Uri uri;
    private Student S;
    private String friendstatus = "notfriends";
    private String key;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgvavatarprofile = view.findViewById(R.id.imgvavatarprofile);
        txtvfullnameprofile = view.findViewById(R.id.txtvfullnameprofile);
        txtvstatusprofile = view.findViewById(R.id.txtvstatusprofile);
        btnchangestatus = view.findViewById(R.id.btnchangestatus);
        btnsendrequest = view.findViewById(R.id.btnsendrequest);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        if (getArguments() != null) {
            key = getArguments().getString("key");
            RetrieveOtherProfile(key);
            databaseReference.child(user.getUid()).child(key).child("type").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        friendstatus = dataSnapshot.getValue(String.class);
                        btnsendrequest.setText("Annuler l'invitation");
                        btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_disabled_20, 0, 0, 0);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            RetrieveStudentProfile();
        }

        btnchangestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("status", status);
                ChangeStatusFragment changeStatusFragment = new ChangeStatusFragment();
                changeStatusFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, changeStatusFragment).addToBackStack(null).commit();
            }
        });

        txtvstatusprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("status", status);
                ChangeStatusFragment changeStatusFragment = new ChangeStatusFragment();
                changeStatusFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, changeStatusFragment).addToBackStack(null).commit();
            }
        });

        btnsendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnsendrequest.setEnabled(false);
                if (friendstatus.equals("notfriends")) {
                    databaseReference.child(user.getUid()).child(key).child("type").setValue("sent").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                databaseReference.child(key).child(user.getUid()).child("type").setValue("received").addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            btnsendrequest.setEnabled(true);
                                            friendstatus = "sent";
                                            btnsendrequest.setText("Annuler l'invitation");
                                            btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_disabled_20, 0, 0, 0);
                                            Toast.makeText(getActivity(), "Invitation envoyée !", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                } else if (friendstatus.equals("sent")) {
                    databaseReference.child(user.getUid()).child(key).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                databaseReference.child(key).child(user.getUid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            btnsendrequest.setEnabled(true);
                                            friendstatus = "notfriends";
                                            btnsendrequest.setText("Envoyer une invitation");
                                            btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_20, 0, 0, 0);
                                            Toast.makeText(getActivity(), "Invitation annulée !", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    public void RetrieveStudentProfile() {
        databaseReference.child("Students").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    fullname = S.getFirstName() + " " + S.getLastName();
                    uri = Uri.parse(S.getAvatar());
                    status = S.getStatus();

                    Glide.with(ProfileFragment.this)
                            .load(uri)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(imgvavatarprofile);

                    txtvfullnameprofile.setText(fullname);
                    txtvstatusprofile.setText(status);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void RetrieveOtherProfile(String key) {
        databaseReference.child("Students").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    fullname = S.getFirstName() + " " + S.getLastName();
                    uri = Uri.parse(S.getAvatar());
                    status = S.getStatus();

                    Glide.with(ProfileFragment.this)
                            .load(uri)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(imgvavatarprofile);

                    txtvfullnameprofile.setText(fullname);
                    txtvstatusprofile.setText(status);
                    btnchangestatus.setVisibility(View.GONE);
                    btnsendrequest.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
