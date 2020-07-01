package com.projet.programmationenc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

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

public class FriendsFragment extends Fragment {
    private static final String TAG = "FriendsFragment";
    private RecyclerView rvfriends;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private FirebaseRecyclerOptions<Friend> options;
    private LinearLayoutManager rvmanager;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private TextView txtvfriendsempty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friends,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Liste d'amis");
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvfriends = view.findViewById(R.id.rvfriends);
        rvmanager = new LinearLayoutManager(getActivity());
        txtvfriendsempty = view.findViewById(R.id.txtvfriendsempty);

        Query query = FirebaseDatabase.getInstance().getReference().child("Friends").child(user.getUid());
        options = new FirebaseRecyclerOptions.Builder<Friend>()
                .setQuery(query,Friend.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Friend,ViewHolderFd>(options) {
            @NonNull
            @Override
            public ViewHolderFd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friends,parent,false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = rvfriends.getChildLayoutPosition(view);
                        CharSequence option[] = new CharSequence[]{"Ouvrir le profil","Envoyer un message"};
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setTitle("Choisir une option");
                        builder.setItems(option, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle bundle = new Bundle();
                                if(i == 0) {
                                    bundle.putString("key",getRef(itemPosition).getKey());
                                    ProfileFragment profileFragment = new ProfileFragment();
                                    profileFragment.setArguments(bundle);
                                    ((HomeActivity) getActivity()).ShowBackButton(true);
                                    ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);
                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,profileFragment).addToBackStack(null).commit();
                                }
                                else if(i == 1) {
                                    bundle.putString("key",getRef(itemPosition).getKey());
                                    ChatFragment chatFragment = new ChatFragment();
                                    chatFragment.setArguments(bundle);
                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,chatFragment).addToBackStack(null).commit();
                                }
                            }
                        }).show();
                    }
                });
                return new ViewHolderFd(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderFd holder, int position, @NonNull Friend model) {
                Glide.with(getActivity())
                        .load(Uri.parse(model.getFriendAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarfriends);
                holder.txtvfullnamefriends.setText(model.getFriendFirstName() + " " + model.getFriendLastName());
                holder.txtvstatusfriends.setText(model.getFriendStatus());
                holder.txtvdateadded.setText("Ajouté le : " + model.getDateAdded());

                databaseReference.child("Students").child(model.getFriendID()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("online")) {
                            Boolean status = snapshot.child("online").getValue(Boolean.class);
                            if(status) {
                                holder.imgvstatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_brightness_green_15));
                            }
                            else {
                                holder.imgvstatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_brightness_gray_15));
                            }
                            notifyItemChanged(position);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvfriendsempty.setVisibility(View.VISIBLE);
                }
                else {
                    txtvfriendsempty.setVisibility(View.GONE);
                }
            }
        };

        ((SimpleItemAnimator) rvfriends.getItemAnimator()).setSupportsChangeAnimations(false);
        rvfriends.setLayoutManager(rvmanager);
        rvfriends.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ViewHolderFd extends RecyclerView.ViewHolder {
        public CircleImageView civavatarfriends;
        public TextView txtvfullnamefriends,txtvstatusfriends,txtvdateadded;
        public ImageView imgvstatus;


        public ViewHolderFd(@NonNull View itemView) {
            super(itemView);
            civavatarfriends = itemView.findViewById(R.id.civavatarfriends);
            txtvfullnamefriends = itemView.findViewById(R.id.txtvfullnamefriends);
            txtvstatusfriends = itemView.findViewById(R.id.txtvstatusfriends);
            txtvdateadded = itemView.findViewById(R.id.txtvdateadded);
            imgvstatus = itemView.findViewById(R.id.imgvstatus);
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
                AllFriendsSearch(s);
                return false;
            }
        });
    }

    public void AllFriendsSearch(String text) {
        Query query = FirebaseDatabase.getInstance().getReference().child("Friends").child(user.getUid()).orderByChild("friendLastName").endAt(text+"\uf8ff");
        options = new FirebaseRecyclerOptions.Builder<Friend>()
                .setQuery(query,Friend.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Friend,ViewHolderFd>(options) {
            @NonNull
            @Override
            public ViewHolderFd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friends,parent,false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = rvfriends.getChildLayoutPosition(view);
                        CharSequence option[] = new CharSequence[]{"Ouvrir le profil","Envoyer un message"};
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setTitle("Choisir une option");
                        builder.setItems(option, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle bundle = new Bundle();
                                if(i == 0) {
                                    bundle.putString("key",getRef(itemPosition).getKey());
                                    ProfileFragment profileFragment = new ProfileFragment();
                                    profileFragment.setArguments(bundle);
                                    ((HomeActivity) getActivity()).ShowBackButton(true);
                                    ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);
                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,profileFragment).addToBackStack(null).commit();
                                }
                                else if(i == 1) {
                                    bundle.putString("key",getRef(itemPosition).getKey());
                                    ChatFragment chatFragment = new ChatFragment();
                                    chatFragment.setArguments(bundle);
                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,chatFragment).addToBackStack(null).commit();
                                }
                            }
                        }).show();
                    }
                });
                return new ViewHolderFd(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderFd holder, int position, @NonNull Friend model) {
                Glide.with(getActivity())
                        .load(Uri.parse(model.getFriendAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarfriends);
                holder.txtvfullnamefriends.setText(model.getFriendFirstName() + " " + model.getFriendLastName());
                holder.txtvstatusfriends.setText(model.getFriendStatus());
                holder.txtvdateadded.setText("Ajouté le : " + model.getDateAdded());

                databaseReference.child("Students").child(model.getFriendID()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("online")) {
                            Boolean status = snapshot.child("online").getValue(Boolean.class);
                            if(status) {
                                holder.imgvstatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_brightness_green_15));
                            }
                            else {
                                holder.imgvstatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_brightness_gray_15));
                            }
                            notifyItemChanged(position);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvfriendsempty.setVisibility(View.VISIBLE);
                    txtvfriendsempty.setText("Aucun résultat trouvé");
                }
                else {
                    txtvfriendsempty.setVisibility(View.GONE);
                }
            }
        };

        firebaseRecyclerAdapter.startListening();
        ((SimpleItemAnimator) rvfriends.getItemAnimator()).setSupportsChangeAnimations(false);
        rvfriends.setLayoutManager(rvmanager);
        rvfriends.setAdapter(firebaseRecyclerAdapter);

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
