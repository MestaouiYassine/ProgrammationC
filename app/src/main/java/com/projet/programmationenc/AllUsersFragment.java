package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import de.hdodenhof.circleimageview.CircleImageView;

public class AllUsersFragment extends Fragment {
    private static final String TAG = "AllUsersFragment";
    private RecyclerView rvallusers;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private FirebaseRecyclerOptions<Student> options;
    private LinearLayoutManager rvmanager;
    private DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allusers,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvallusers = view.findViewById(R.id.rvallusers);
        rvmanager = new LinearLayoutManager(getActivity());

        Query query = FirebaseDatabase.getInstance().getReference().child("Students");
        options = new FirebaseRecyclerOptions.Builder<Student>()
                .setQuery(query,Student.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Student,ViewHolderSt>(options) {

            @NonNull
            @Override
            public ViewHolderSt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_allusers,parent,false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = rvallusers.getChildLayoutPosition(view);
                        String key = databaseReference.child("Students").child(getRef(itemPosition).getKey()).getKey();
                        Log.e(TAG, "onClick: KEY : " + key);
                        Bundle bundle = new Bundle();
                        bundle.putString("key",key);
                        ProfileFragment profileFragment = new ProfileFragment();
                        profileFragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,profileFragment).addToBackStack(null).commit();
                    }
                });
                return new ViewHolderSt(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderSt holder, int position, @NonNull Student model) {
                Glide.with(AllUsersFragment.this)
                        .load(Uri.parse(model.getAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarallusers);
                holder.txtvfullnameallusers.setText(model.getFirstName() + " " + model.getLastName());
                holder.txtvstatusallusers.setText(model.getStatus());
            }
        };

        rvallusers.setHasFixedSize(true);
        rvallusers.setLayoutManager(rvmanager);
        rvallusers.setAdapter(firebaseRecyclerAdapter);
    }

    public static class ViewHolderSt extends RecyclerView.ViewHolder {
        public CircleImageView civavatarallusers;
        public TextView txtvfullnameallusers,txtvstatusallusers;


        public ViewHolderSt(@NonNull View itemView) {
            super(itemView);
            civavatarallusers = itemView.findViewById(R.id.civavatarallusers);
            txtvfullnameallusers = itemView.findViewById(R.id.txtvfullnameallusers);
            txtvstatusallusers = itemView.findViewById(R.id.txtvstatusallusers);
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
