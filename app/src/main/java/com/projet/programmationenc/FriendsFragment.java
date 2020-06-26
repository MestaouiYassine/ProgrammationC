package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsFragment extends Fragment {
    private static final String TAG = "FriendsFragment";
    private RecyclerView rvfriends;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private FirebaseRecyclerOptions<Friend> options;
    private LinearLayoutManager rvmanager;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friends,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvfriends = view.findViewById(R.id.rvfriends);
        rvmanager = new LinearLayoutManager(getActivity());

        Query query = FirebaseDatabase.getInstance().getReference().child("Friends").child(user.getUid());
        options = new FirebaseRecyclerOptions.Builder<Friend>()
                .setQuery(query,Friend.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Friend,ViewHolderFd>(options) {
            @NonNull
            @Override
            public ViewHolderFd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friends,parent,false);
                return new ViewHolderFd(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderFd holder, int position, @NonNull Friend model) {
                Glide.with(FriendsFragment.this)
                        .load(Uri.parse(model.getFriendAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarfriends);
                holder.txtvfullnamefriends.setText(model.getFriendFirstName() + " " + model.getFriendLastName());
                holder.txtvstatusfriends.setText(model.getFriendStatus());
                holder.txtvdateadded.setText("Ajouté le : " + model.getDateAdded());
            }
        };

        rvfriends.setHasFixedSize(true);
        rvfriends.setLayoutManager(rvmanager);
        rvfriends.setAdapter(firebaseRecyclerAdapter);
    }

    public static class ViewHolderFd extends RecyclerView.ViewHolder {
        public CircleImageView civavatarfriends;
        public TextView txtvfullnamefriends,txtvstatusfriends,txtvdateadded;


        public ViewHolderFd(@NonNull View itemView) {
            super(itemView);
            civavatarfriends = itemView.findViewById(R.id.civavatarfriends);
            txtvfullnamefriends = itemView.findViewById(R.id.txtvfullnamefriends);
            txtvstatusfriends = itemView.findViewById(R.id.txtvstatusfriends);
            txtvdateadded = itemView.findViewById(R.id.txtvdateadded);
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
