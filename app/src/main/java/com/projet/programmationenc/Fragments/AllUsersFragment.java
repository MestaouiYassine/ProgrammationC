package com.projet.programmationenc.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
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
import com.projet.programmationenc.ui.HomeActivity;
import com.projet.programmationenc.Moduls.Student;
import com.projet.programmationenc.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AllUsersFragment extends Fragment {
    private static final String TAG = "AllUsersFragment";
    private RecyclerView rvallusers;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private FirebaseRecyclerOptions<Student> options;
    private LinearLayoutManager rvmanager;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private TextView txtvallusersempty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_allusers,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Tous les étudiants");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvallusers = view.findViewById(R.id.rvallusers);
        rvmanager = new LinearLayoutManager(getActivity());
        txtvallusersempty = view.findViewById(R.id.txtvallusersempty);

        Query query = databaseReference.child("Students");
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
                        if(key != null && key.equals(user.getUid())) {
                            return;
                        }
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
                Glide.with(getActivity())
                        .load(Uri.parse(model.getAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarallusers);
                holder.txtvfullnameallusers.setText(model.getFirstName() + " " + model.getLastName());
                holder.txtvstatusallusers.setText(model.getStatus());
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvallusersempty.setVisibility(View.VISIBLE);
                }
                else {
                    txtvallusersempty.setVisibility(View.GONE);
                }
            }
        };


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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        menu.clear();
        inflater.inflate(R.menu.menusearch,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((HomeActivity)getActivity()).getSupportActionBar().getThemedContext());
        searchView.setQueryHint("Recherche par nom");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menuItem.setActionView(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                AllUsersSearch(s);
                return false;
            }
        });
    }

    public void AllUsersSearch(String text) {
        Query query = databaseReference.child("Students").orderByChild("lastName").startAt(text).endAt(text+"\uf8ff");
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
                        if(key != null && key.equals(user.getUid())) {
                            return;
                        }
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
                Glide.with(getActivity())
                        .load(Uri.parse(model.getAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarallusers);
                holder.txtvfullnameallusers.setText(model.getFirstName() + " " + model.getLastName());
                holder.txtvstatusallusers.setText(model.getStatus());
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvallusersempty.setVisibility(View.VISIBLE);
                    txtvallusersempty.setText("Aucun résultat trouvé");
                }
                else {
                    txtvallusersempty.setVisibility(View.GONE);
                }
            }
        };

        firebaseRecyclerAdapter.startListening();
        rvallusers.setAdapter(firebaseRecyclerAdapter);
        rvallusers.setLayoutManager(rvmanager);
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
