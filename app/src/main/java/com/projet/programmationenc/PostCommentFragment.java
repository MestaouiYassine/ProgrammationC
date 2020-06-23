package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostCommentFragment extends Fragment {
    private static final String TAG = "PostCommentFragment";
    private RecyclerView rvcomment;
    private RecyclerView.LayoutManager rvmanager;
    private FirebaseRecyclerOptions<Comment> options;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private Post P;
    private String key,comment,fullName,avatar;
    private CircleImageView civavatarpost,civavataraddcomment;
    private TextView txtvfullnamepost,txtvquestionpost,txtvdescriptionpost,txtvdatepost;
    public static FloatingActionButton fabcomment;
    public static ConstraintLayout claddcoment;
    private ImageButton btnsendcomment,btnupvotepost,btndownvotepost;
    private TextInputLayout edtaddcomment;
    private Comment C;
    private TextView txtvnumvotespost;
    private int vote;
    private String poststatus;
    private String commentstatus;
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

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvcomment = view.findViewById(R.id.rvcomment);
        rvmanager = new LinearLayoutManager(getActivity());

        civavatarpost = view.findViewById(R.id.civavatarpost);
        txtvfullnamepost = view.findViewById(R.id.txtvfullnamepost);
        txtvquestionpost = view.findViewById(R.id.txtvquestionpost);
        txtvdescriptionpost = view.findViewById(R.id.txtvdescriptionpost);
        txtvdatepost = view.findViewById(R.id.txtvdatepost);
        fabcomment = view.findViewById(R.id.fabcomment);
        claddcoment = view.findViewById(R.id.claddcomment);
        civavataraddcomment = view.findViewById(R.id.civavataraddcomment);
        btnsendcomment = view.findViewById(R.id.btnsendcomment);
        edtaddcomment = view.findViewById(R.id.edtaddcomment);
        btnupvotepost = view.findViewById(R.id.btnupvotepost);
        btndownvotepost = view.findViewById(R.id.btndownvotepost);
        txtvnumvotespost = view.findViewById(R.id.txtvnumvotespost);

        key = getArguments().getString("key");
        Log.e(TAG, "onViewCreated: KEY" + key);

        fullName = ((HomeActivity) getActivity()).retrievedFirstName + " " + ((HomeActivity) getActivity()).retrievedLastName;
        avatar = ((HomeActivity) getActivity()).retrievedAvatar;

        poststatus = "none";
        LoadStudentPost();
        LoadStudentPostVotes();

        Uri uri = Uri.parse(((HomeActivity) getActivity()).retrievedAvatar);
        fabcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabcomment.setVisibility(View.GONE);
                claddcoment.setVisibility(View.VISIBLE);
//                claddcoment.animate().translationY(0);
                TranslateAnimation animate = new TranslateAnimation(
                        0,                 // fromXDelta
                        0,                 // toXDelta
                        claddcoment.getHeight(),  // fromYDelta
                        0);                // toYDelta
                animate.setDuration(350);
                animate.setFillAfter(true);
                claddcoment.startAnimation(animate);
                Glide.with(PostCommentFragment.this)
                        .load(uri)
                        .apply(RequestOptions.fitCenterTransform())
                        .into(civavataraddcomment);
//                edtaddcomment.requestFocus();
            }
        });

        Query query = FirebaseDatabase.getInstance().getReference().child("Comments").child(key);
        options = new FirebaseRecyclerOptions.Builder<Comment>()
                .setQuery(query,Comment.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Comment,ViewHolderCm>(options) {
            @NonNull
            @Override
            public ViewHolderCm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comment,parent,false);
                ViewHolderCm vhc = new ViewHolderCm(v);
                return vhc;
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderCm holder, int position, @NonNull Comment model) {
                Glide.with(PostCommentFragment.this)
                        .load(Uri.parse(model.getAvatarComment()))
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.civavatarcomment);
                holder.txtvdescriptioncomment.setText(model.getDescriptionComment());
                holder.txtvfullnamecomment.setText(model.getFullNameComment());
                holder.txtvdatecomment.setText(model.getDateComment());
//                voteC = model.getVotesComment();

                if(holder.getAdapterPosition() == position) {
                    databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                commentstatus = dataSnapshot.getValue(String.class);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment()));
                                if (commentstatus != null && commentstatus.equals("up")) {
                                    holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                                    holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                } else if (commentstatus != null && commentstatus.equals("down")) {
                                    holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                                    holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                } else if (commentstatus != null && commentstatus.equals("none")) {
                                    holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                    holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                }
                                Log.e(TAG, "onDataChange: commentstatus : " + commentstatus);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e(TAG, "onCancelled: " + databaseError.getMessage());
                        }
                    });

                    holder.btnupvotecomment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.e(TAG, "onClick: btnupvote" + getRef(position).getKey());

                            if (commentstatus != null && commentstatus.equals("down")) {
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() + 2));
                                commentstatus = "up";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() + 2);
                            } else if (commentstatus != null && commentstatus.equals("up")) {
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() - 1));
                                commentstatus = "none";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() - 1);
                            } else if (commentstatus != null && commentstatus.equals("none")) {
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() + 1));
                                commentstatus = "up";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() + 1);
                            }
                        }
                    });

                    holder.btndownvotecomment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.e(TAG, "onClick: btnupvote" + getRef(position).getKey());

                            if (commentstatus != null && commentstatus.equals("up")) {
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() - 2));
                                commentstatus = "down";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() - 2);
                            } else if (commentstatus != null && commentstatus.equals("down")) {
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() + 1));
                                commentstatus = "none";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() + 1);
                            } else if (commentstatus != null && commentstatus.equals("none")) {
                                holder.btndownvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                                holder.btnupvotecomment.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                                holder.txtvnumvotescomment.setText(String.valueOf(model.getVotesComment() - 1));
                                commentstatus = "down";
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("ReactionComment").child(user.getUid()).setValue(commentstatus);
                                databaseReference.child("Comments").child(key).child(getRef(position).getKey()).child("votesComment").setValue(model.getVotesComment() - 1);
                            }
                        }
                    });
                }
            }
        };

        rvcomment.setAdapter(firebaseRecyclerAdapter);
        rvcomment.setLayoutManager(rvmanager);

        btnsendcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comment = edtaddcomment.getEditText().getText().toString();

                if(comment.isEmpty()) {
                    edtaddcomment.setError("Veuillez saisir votre commentaire");
                }
                else {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy 'à' HH:mm");
                    C = new Comment(comment,fullName,avatar,user.getUid(),sdf.format(new Date()),0);
//                    databaseReference.child("Posts").child(key).child("Comments").push().setValue(C);
                    String cKey = databaseReference.child("Comments").child(key).push().getKey();
                    databaseReference.child("Comments").child(key).child(cKey).setValue(C);
                    databaseReference.child("Comments").child(key).child(cKey).child("ReactionComment").child(user.getUid()).setValue("none");

                    claddcoment.setVisibility(View.INVISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,                 // fromXDelta
                            0,                 // toXDelta
                            0,                 // fromYDelta
                            claddcoment.getHeight()); // toYDelta
                    animate.setDuration(350);
                    animate.setFillAfter(true);
                    claddcoment.startAnimation(animate);
                    fabcomment.setVisibility(View.VISIBLE);
                    edtaddcomment.getEditText().setText(null);
                    Toast.makeText(getActivity(), "Comment posted !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnupvotepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(poststatus.equals("down")) {
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                    vote+=2;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "up";
                    databaseReference.child("Posts").child(key).child("ReactionPost").child(user.getUid()).setValue(poststatus);
                    databaseReference.child("Posts").child(key).child("votes").setValue(vote);
                    return;
                }

                if(poststatus.equals("up")) {
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                    vote--;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "none";
                }
                else {
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                    vote++;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "up";
                }
                databaseReference.child("Posts").child(key).child("ReactionPost").child(user.getUid()).setValue(poststatus);
                databaseReference.child("Posts").child(key).child("votes").setValue(vote);
            }
        });

        btndownvotepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(poststatus.equals("up")) {
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                    vote-=2;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "down";
                    databaseReference.child("Posts").child(key).child("ReactionPost").child(user.getUid()).setValue(poststatus);
                    databaseReference.child("Posts").child(key).child("votes").setValue(vote);
                    return;
                }

                if(poststatus.equals("down")) {
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                    vote++;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "none";
                }
                else {
                    btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                    btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                    vote--;
                    txtvnumvotespost.setText(String.valueOf(vote));
                    poststatus = "down";
                }
                databaseReference.child("Posts").child(key).child("ReactionPost").child(user.getUid()).setValue(poststatus);
                databaseReference.child("Posts").child(key).child("votes").setValue(vote);
            }
        });
    }

    public void LoadStudentPost() {
        databaseReference.child("Posts").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && isAdded()) {
                    P = dataSnapshot.getValue(Post.class);
                    Glide.with(PostCommentFragment.this)
                            .load(Uri.parse(P.getStudentAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(civavatarpost);
                    txtvfullnamepost.setText(P.getStudentFullName());
                    txtvquestionpost.setText(P.getQuestionPost());
                    txtvdescriptionpost.setText(P.getDescriptionPost());
                    txtvdatepost.setText(P.getDatePost());
                    vote = P.getVotes();
                    txtvnumvotespost.setText(String.valueOf(vote));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public static class ViewHolderCm extends RecyclerView.ViewHolder {
        public CircleImageView civavatarcomment;
        public TextView txtvfullnamecomment,txtvdescriptioncomment,txtvdatecomment,txtvnumvotescomment;
        public ImageButton btnupvotecomment,btndownvotecomment;


        public ViewHolderCm(@NonNull View itemView) {
            super(itemView);
            civavatarcomment = itemView.findViewById(R.id.civavatarcomment);
            txtvfullnamecomment = itemView.findViewById(R.id.txtvfullnamecomment);
            txtvdescriptioncomment = itemView.findViewById(R.id.txtvdescriptioncomment);
            txtvdatecomment = itemView.findViewById(R.id.txtvdatecomment);
            txtvnumvotescomment = itemView.findViewById(R.id.txtvnumvotescomment);
            btnupvotecomment = itemView.findViewById(R.id.btnupvotecomment);
            btndownvotecomment = itemView.findViewById(R.id.btndownvotecomment);
        }
    }

    public void LoadStudentPostVotes() {
        databaseReference.child("Posts").child(key).child("ReactionPost").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    String vote = dataSnapshot.child(user.getUid()).getValue(String.class);
                    if(vote != null && vote.equals("up")) {
                        btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_voted_30);
                        btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                        poststatus = "up";
                    }
                    else if(vote != null && vote.equals("down")){
                        btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_voted_30);
                        btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                        poststatus = "down";
                    }
                    else {
                        btnupvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_30);
                        btndownvotepost.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_30);
                        poststatus = "none";
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });

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
