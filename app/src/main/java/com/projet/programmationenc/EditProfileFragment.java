package com.projet.programmationenc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theartofdev.edmodo.cropper.CropImage;

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private FirebaseUser user;
    private String firstnameedit,lastnameedit;
    private ImageView imgvavataredit;
    private EditText edtlastnameedit,edtfirstnameedit;
    private TextView txtvchangeavatar;
    private Button btnconfirmedit;
    private ImageButton btnremoveavatar;
    private Student S;
    private DatabaseReference databaseReference;
    Uri imgavataruri;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editprofile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        imgvavataredit = view.findViewById(R.id.imgvavataredit);
        edtlastnameedit = view.findViewById(R.id.edtlastnameedit);
        edtfirstnameedit = view.findViewById(R.id.edtfirstnameedit);
        btnconfirmedit = view.findViewById(R.id.btnconfirmedit);
        btnremoveavatar = view.findViewById(R.id.btnremoveavatar);
        txtvchangeavatar = view.findViewById(R.id.txtvchangeavatar);

        edtfirstnameedit.setText(((HomeActivity) getActivity()).retrievedFirstName);
        edtlastnameedit.setText(((HomeActivity) getActivity()).retrievedLastName);
//        if(((HomeActivity) getActivity()).retrievedAvatar != null) {
        imgavataruri = Uri.parse(((HomeActivity) getActivity()).retrievedAvatar);
            Glide.with(this)
                    .load(imgavataruri)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(imgvavataredit);

//        }

        imgvavataredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageFile();
            }
        });

        txtvchangeavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageFile();
            }
        });

        btnremoveavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("Etudiants").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Log.e(TAG, "onDataChange: hahwa dkhel bach i7eyed lavatar");
                            S = snapshot.getValue(Student.class);
                            if(S.id.equals(user.getUid())) {
                                imgavataruri = Uri.parse("android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round");
//                                E.setAvatar("android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round");
//                                databaseReference.child("Etudiants").child(user.getUid()).removeValue();
//                                databaseReference.child("Etudiants").child(user.getUid()).setValue(S);
                                Glide.with(getActivity())
                                        .load(imgavataruri)
                                        .apply(RequestOptions.fitCenterTransform())
                                        .into(imgvavataredit);
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

        btnconfirmedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstnameedit = edtfirstnameedit.getText().toString();
                lastnameedit = edtlastnameedit.getText().toString();
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,6}";
                boolean flag = true;

                if(firstnameedit.isEmpty()) {
                    edtfirstnameedit.setError("Veuillez saisir le prénom.");
                    flag = false;
                }

                if(lastnameedit.isEmpty()) {
                    edtlastnameedit.setError("Veuillez saisir le nom.");
                    flag = false;
                }

                if(!flag) {
                    return;
                }
                else {
                    databaseReference.child("Etudiants").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Log.e(TAG, "onDataChange: hahwa dkhel bach i modifier data f realtime database");
                                    S = snapshot.getValue(Student.class);
                                    if (S.id.equals(user.getUid())) {
                                        S.setFirstname(firstnameedit);
                                        S.setLastname(lastnameedit);
//                                        if (imgavataruri != null) {
                                            S.setAvatar(imgavataruri.toString());
                                            Log.e(TAG, "onDataChange: hahwa l9a avatar o zado l Etudiant");
//                                        }
//                                        else {
//                                            E.setAvatar("android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round");
//                                        }
//                                    Toast.makeText(getContext(),E.firstname + " " + E.lastname,Toast.LENGTH_SHORT).show();
                                        databaseReference.child("Etudiants").child(user.getUid()).removeValue();
                                        databaseReference.child("Etudiants").child(user.getUid()).setValue(S);
                                        Toast.makeText(getContext(), "Modification réussie !", Toast.LENGTH_SHORT).show();
                                        Log.e(TAG, "onDataChange: hahwa sala modification");
                                        break;
                                    }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });

    }

    private void openImageFile() {
        CropImage.activity()
                .setAspectRatio(1,1)
                .start(getContext(), this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                imgavataruri = result.getUri();
                Glide.with(this)
                        .load(imgavataruri)
                        .apply(RequestOptions.fitCenterTransform())
                        .into(imgvavataredit);
            }
        }
    }

}

