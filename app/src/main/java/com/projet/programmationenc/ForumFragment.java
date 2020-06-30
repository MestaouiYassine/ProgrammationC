package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
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
    private TextView txtvforumempty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
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
        txtvforumempty = view.findViewById(R.id.txtvforumempty);

        fabpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new AddPostFragment()).addToBackStack(null).commit();
            }
        });

        Query query = databaseReference.child("Posts");
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
                Glide.with(getActivity())
                        .load(Uri.parse(model.getStudentAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarforum);
                holder.txtvfullnameforum.setText(model.getStudentFullName());
                holder.txtvquestionforum.setText(model.getQuestionPost());
                holder.txtvdateforum.setText(model.getDatePost());
                if(model.getVotes() > 0) {
                    holder.txtvnumvotesforum.setText("+" + model.getVotes());
                }
                else {
                    holder.txtvnumvotesforum.setText(String.valueOf(model.getVotes()));
                }

                if(model.getStudentID().equals(user.getUid())) {
                    holder.txtvoptionsforum.setVisibility(View.VISIBLE);
                }

                holder.txtvoptionsforum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(getActivity(),holder.txtvoptionsforum);
                        popupMenu.inflate(R.menu.forum_menu);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch(menuItem.getItemId()) {
                                    case R.id.deletepost:
                                        databaseReference.child("Posts").child(getRef(position).getKey()).removeValue();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                    }
                });
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvforumempty.setVisibility(View.VISIBLE);
                }
                else {
                    txtvforumempty.setVisibility(View.GONE);
                }
            }
        };

        rvforum.setAdapter(firebaseRecyclerAdapter);
        rvforum.setLayoutManager(rvmanager);


    }

    public static class ViewHolderFm extends RecyclerView.ViewHolder {
        public CircleImageView civavatarforum;
        public TextView txtvfullnameforum,txtvquestionforum,txtvdateforum,txtvnumvotesforum,txtvoptionsforum;


        public ViewHolderFm(@NonNull View itemView) {
            super(itemView);
            civavatarforum = itemView.findViewById(R.id.civavatarforum);
            txtvfullnameforum = itemView.findViewById(R.id.txtvfullnameforum);
            txtvquestionforum = itemView.findViewById(R.id.txtvquestionforum);
            txtvdateforum = itemView.findViewById(R.id.txtvdateforum);
            txtvnumvotesforum = itemView.findViewById(R.id.txtvnumvotesforum);
            txtvoptionsforum = itemView.findViewById(R.id.txtvoptionsforum);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        menu.clear();
        inflater.inflate(R.menu.menusearch,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((HomeActivity)getActivity()).getSupportActionBar().getThemedContext());
        searchView.setQueryHint("Recherche par question");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menuItem.setActionView(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ForumSearch(s);
                return false;
            }
        });
    }

    public void ForumSearch(String text) {
        Query query = databaseReference.child("Posts").orderByChild("questionPost").startAt(text).endAt(text+"\uf8ff");
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
                Glide.with(getActivity())
                        .load(Uri.parse(model.getStudentAvatar()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarforum);
                holder.txtvfullnameforum.setText(model.getStudentFullName());
                holder.txtvquestionforum.setText(model.getQuestionPost());
                holder.txtvdateforum.setText(model.getDatePost());
                if(model.getVotes() > 0) {
                    holder.txtvnumvotesforum.setText("+" + model.getVotes());
                }
                else {
                    holder.txtvnumvotesforum.setText(String.valueOf(model.getVotes()));
                }

                if(model.getStudentID().equals(user.getUid())) {
                    holder.txtvoptionsforum.setVisibility(View.VISIBLE);
                }

                holder.txtvoptionsforum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(getActivity(),holder.txtvoptionsforum);
                        popupMenu.inflate(R.menu.forum_menu);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch(menuItem.getItemId()) {
                                    case R.id.deletepost:
                                        databaseReference.child("Posts").child(getRef(position).getKey()).removeValue();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                    }
                });

            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvforumempty.setVisibility(View.VISIBLE);
                    txtvforumempty.setText("Aucun résultat trouvé");
                }
                else {
                    txtvforumempty.setVisibility(View.GONE);
                }
            }
        };

        firebaseRecyclerAdapter.startListening();
        rvforum.setAdapter(firebaseRecyclerAdapter);
        rvforum.setLayoutManager(rvmanager);

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
