package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostCommentFragment extends Fragment {
    private static final String TAG = "PostCommentFragment";
    private RecyclerView rvcomment;
    private RecyclerView.LayoutManager rvmanager;
    private FirebaseRecyclerOptions<Post> options;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private Post P;
    private String key;
    private CircleImageView civavatarpost;
    private TextView txtvfullnamepost,txtvquestionpost,txtvdescriptionpost,txtvdatepost;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        rvcomment = view.findViewById(R.id.rvcomment);
        rvmanager = new LinearLayoutManager(getContext());

        civavatarpost = view.findViewById(R.id.civavatarpost);
        txtvfullnamepost = view.findViewById(R.id.txtvfullnamepost);
        txtvquestionpost = view.findViewById(R.id.txtvquestionpost);
        txtvdescriptionpost = view.findViewById(R.id.txtvdescriptionpost);
        txtvdatepost = view.findViewById(R.id.txtvdatepost);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        key = getArguments().getString("key");
        Log.e(TAG, "onViewCreated: KEY" + key);

        LoadStudentPost();




    }

    public void LoadStudentPost() {
        databaseReference.child("Posts").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    P = dataSnapshot.getValue(Post.class);
                    Glide.with(getContext())
                            .load(P.getStudentAvatar())
                            .apply(RequestOptions.fitCenterTransform())
                            .into(civavatarpost);
                    txtvfullnamepost.setText(P.getStudentFullName());
                    txtvquestionpost.setText(P.getQuestionPost());
                    txtvdescriptionpost.setText(P.getDescriptionPost());
                    txtvdatepost.setText(P.getDatePost());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        firebaseRecyclerAdapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        firebaseRecyclerAdapter.stopListening();
//    }
}
