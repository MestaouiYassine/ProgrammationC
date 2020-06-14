package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddPostFragment extends Fragment {
    private CircleImageView civavataraddpost;
    private TextView txtvfullnameaddpost;
    private TextInputLayout edtaddquestion,edtadddescription;
    private Button btnaddpost;
    private String question,description,fullName,avatar;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private Post P;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addpost,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        civavataraddpost = view.findViewById(R.id.civavataraddpost);
        txtvfullnameaddpost = view.findViewById(R.id.txtvfullnameaddpost);
        edtaddquestion = view.findViewById(R.id.edtaddquestion);
        edtadddescription = view.findViewById(R.id.edtadddescription);
        btnaddpost = view.findViewById(R.id.btnaddpost);

        avatar = ((HomeActivity) getActivity()).retrievedAvatar;
        Glide.with(view)
                .load(Uri.parse(avatar))
                .apply(RequestOptions.fitCenterTransform())
                .into(civavataraddpost);

        fullName = ((HomeActivity) getActivity()).retrievedFirstName + " " + ((HomeActivity) getActivity()).retrievedLastName;

        txtvfullnameaddpost.setText(fullName);

        btnaddpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = true;
                question = edtaddquestion.getEditText().getText().toString();
                description = edtadddescription.getEditText().getText().toString();

                if(question.isEmpty()) {
                    edtaddquestion.setError("Veuillez saisir votre question");
                    flag = false;
                }

                if(description.isEmpty()) {
                    edtadddescription.setError("Veuillez saisir votre description");
                    flag = false;
                }

                if(!flag) {
                    return;
                }
                else {
//                    databaseReference.child("Posts").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//                            if(dataSnapshot.exists()) {
//                                long count = dataSnapshot.getChildrenCount();
//                                P = new Post(avatar,question,description,fullName,user.getUid(),sdf.format(new Date()));
//                                databaseReference.child("Posts").child(user.getUid()).child("Post " + (count + 1)).setValue(P);
//                                Toast.makeText(getContext(), "Post posted !", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                P = new Post(avatar,question,description,fullName,user.getUid(),sdf.format(new Date()));
//                                databaseReference.child("Posts").child(user.getUid()).child("Post 1").setValue(P);
//                                Toast.makeText(getContext(), "Post posted !", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    P = new Post(avatar,question,description,fullName,user.getUid(),sdf.format(new Date()));
                    databaseReference.child("Posts").push().setValue(P);
                    Toast.makeText(getContext(), "Post posted !", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
