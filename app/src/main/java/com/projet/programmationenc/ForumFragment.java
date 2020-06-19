package com.projet.programmationenc;

import android.net.Uri;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForumFragment extends Fragment {
    private static final String TAG = "ForumFragment";
    private RecyclerView rvforum;
    private RecyclerView.LayoutManager rvmanager;
    private FirebaseRecyclerOptions<Post> options;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private FloatingActionButton fabpost;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Forum");
        return inflater.inflate(R.layout.fragment_forum,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvforum = view.findViewById(R.id.rvforum);
        rvmanager = new LinearLayoutManager(getActivity());
        fabpost = view.findViewById(R.id.fabpost);

        fabpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new AddPostFragment()).addToBackStack(null).commit();
            }
        });

        Query query = FirebaseDatabase.getInstance().getReference().child("Posts");
        options = new FirebaseRecyclerOptions.Builder<Post>()
                        .setQuery(query,Post.class)
                        .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post,ViewHolderFm>(options) {

            @NonNull
            @Override
            public ViewHolderFm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_forum,parent,false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = rvforum.getChildLayoutPosition(view);
                        String key = databaseReference.child("Posts").child(getRef(itemPosition).getKey()).getKey();
                        Log.e(TAG, "onClick: KEY : " + key);
                        Bundle bundle = new Bundle();
                        bundle.putString("key",key);
                        PostCommentFragment postCommentFragment = new PostCommentFragment();
                        postCommentFragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,postCommentFragment).addToBackStack(null).commit();

                    }
                });
                ViewHolderFm vhf = new ViewHolderFm(v);
                return vhf;
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderFm holder, int position, @NonNull Post model) {
                Glide.with(ForumFragment.this)
                        .load(Uri.parse(model.getStudentAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarforum);
                holder.txtvfullnameforum.setText(model.getStudentFullName());
                holder.txtvquestionforum.setText(model.getQuestionPost());
                holder.txtvdateforum.setText(model.getDatePost());
            }
        };

        rvforum.setAdapter(firebaseRecyclerAdapter);
        rvforum.setLayoutManager(rvmanager);

    }

    public static class ViewHolderFm extends RecyclerView.ViewHolder {
        public CircleImageView civavatarforum;
        public TextView txtvfullnameforum,txtvquestionforum,txtvdateforum;


        public ViewHolderFm(@NonNull View itemView) {
            super(itemView);
            civavatarforum = itemView.findViewById(R.id.civavatarforum);
            txtvfullnameforum = itemView.findViewById(R.id.txtvfullnameforum);
            txtvquestionforum = itemView.findViewById(R.id.txtvquestionforum);
            txtvdateforum = itemView.findViewById(R.id.txtvdateforum);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        firebaseRecyclerAdapter.stopListening();
    }
}
