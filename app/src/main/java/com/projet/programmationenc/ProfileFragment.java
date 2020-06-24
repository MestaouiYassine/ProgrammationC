package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CircleImageView imgvavatarprofile;
    private TextView txtvfullnameprofile,txtvstatusprofile;
    private Button btnchangestatus;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String fullname,status;
    private Uri uri;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgvavatarprofile = view.findViewById(R.id.imgvavatarprofile);
        txtvfullnameprofile = view.findViewById(R.id.txtvfullnameprofile);
        txtvstatusprofile = view.findViewById(R.id.txtvstatusprofile);
        btnchangestatus = view.findViewById(R.id.btnchangestatus);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        RetrieveStudentProfile();

        btnchangestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("status",status);
                ChangeStatusFragment changeStatusFragment = new ChangeStatusFragment();
                changeStatusFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,changeStatusFragment).addToBackStack(null).commit();
            }
        });
    }

    public void RetrieveStudentProfile() {
        databaseReference.child("Students").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
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
}
