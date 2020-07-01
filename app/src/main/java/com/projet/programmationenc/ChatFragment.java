package com.projet.programmationenc;

import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
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
import java.util.Date;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatFragment extends Fragment {
    private static final String TAG = "ChatFragment";
    private String key;
    private Student S,S2,S3;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private ImageButton btnsendmessage;
    private CircleImageView civsenderavatar;
    private TextInputLayout edtsendmessage;
    private RecyclerView rvchat;
    private LinearLayoutManager rvmanager;
    private FirebaseRecyclerOptions<Chat> options;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private static final int right = 1;
    private static final int left = -1;
    private Chat C;
    private String avatarReceiver;
    private LastChat LC;
    private String message;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);
        ((HomeActivity) getActivity()).clchatbar.setVisibility(View.VISIBLE);

        civsenderavatar = view.findViewById(R.id.civsenderavatar);
        btnsendmessage = view.findViewById(R.id.btnsendmessage);
        edtsendmessage = view.findViewById(R.id.edtsendmessage);

        rvchat = view.findViewById(R.id.rvchat);
        rvmanager = new LinearLayoutManager(getActivity());

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        RetrieveSenderAvatar();

        key = getArguments().getString("key");
        RetrieveChatterInfo(key);

        Query query = FirebaseDatabase.getInstance().getReference().child("Chats").child(user.getUid()).child(key);
        options = new FirebaseRecyclerOptions.Builder<Chat>()
                .setQuery(query, Chat.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Chat,ViewHolderCt>(options) {

            @NonNull
            @Override
            public ViewHolderCt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                if(viewType == left) {
                    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_receiver, parent, false);
                    return new ViewHolderCt(v);
                }
                else {
                    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sender, parent, false);
                    return new ViewHolderCt(v);
                }
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderCt holder, int position, @NonNull Chat model) {
                holder.txtvmessage.setText(model.getMessage());
                holder.txtvmessagedate.setText(model.getDate());
                if(holder.civavatarchat != null) {
                    Glide.with(getActivity())
                            .load(avatarReceiver)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(holder.civavatarchat);
                }
            }

            @Override
            public int getItemViewType(int position) {
                if(getItem(position).getSender().equals(user.getUid())) {
                    return right;
                }
                else {
                    return left;
                }
            }
        };

        rvmanager.setStackFromEnd(true);
        rvchat.setLayoutManager(rvmanager);
        rvchat.setAdapter(firebaseRecyclerAdapter);


        btnsendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = edtsendmessage.getEditText().getText().toString().trim();
                if(!message.isEmpty()) {
                    sendMessage();
                    edtsendmessage.getEditText().setText(null);
                }
            }
        });

    }

    private void RetrieveSenderAvatar() {
        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    S = snapshot.getValue(Student.class);
                    Glide.with(getActivity())
                            .load(Uri.parse(S.getAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(civsenderavatar);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void RetrieveChatterInfo(String key) {
        databaseReference.child("Students").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    S = snapshot.getValue(Student.class);
                    boolean status = snapshot.child("online").getValue(Boolean.class);
                    long lastSeen = snapshot.child("lastseen").getValue(Long.class);
                    ((HomeActivity) getActivity()).txtvfullnamebar.setText(S.getFirstName() + " " + S.getLastName());
                    avatarReceiver = S.getAvatar();
                    Glide.with(getActivity())
                            .load(Uri.parse(S.getAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(((HomeActivity) getActivity()).civavatarbar);

                    if(status) {
                        ((HomeActivity) getActivity()).txtvseenbar.setText("En ligne");
                    }
                    else{
                        String lastTimeSeen = GetTimeAgo.getTimeAgo(lastSeen,getActivity());
                        ((HomeActivity) getActivity()).txtvseenbar.setText("Vu : " + lastTimeSeen);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void sendMessage() {
        databaseReference.child("Students").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    S2 = snapshot.child(user.getUid()).getValue(Student.class);
                    S3 = snapshot.child(key).getValue(Student.class);

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'à' HH:mm");
                    LC = new LastChat(message,user.getUid(),key,S2.getFirstName(),S3.getFirstName(),S2.getLastName(),S3.getLastName(),S2.getAvatar(),S3.getAvatar(),System.currentTimeMillis());
                    C = new Chat(message,user.getUid(),key,sdf.format(new Date()),avatarReceiver);
                    databaseReference.child("Last Chats").child(user.getUid()).child(key).setValue(LC);
                    databaseReference.child("Chats").child(user.getUid()).child(key).push().setValue(C);
                    databaseReference.child("Last Chats").child(key).child(user.getUid()).setValue(LC);
                    databaseReference.child("Chats").child(key).child(user.getUid()).push().setValue(C);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



//        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()) {
//                    S = snapshot.getValue(Student.class);
//                    LC = new LastChat(message,user.getUid(),key,S.getFirstName(),S.getLastName(),S.getAvatar(),sdf.format(new Date()));
//                    C = new Chat(message,user.getUid(),key,sdf.format(new Date()),avatarReceiver);
//                    databaseReference.child("Last Chats").child(key).child(user.getUid()).setValue(LC);
//                    databaseReference.child("Chats").child(key).child(user.getUid()).push().setValue(C);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    public static class ViewHolderCt extends RecyclerView.ViewHolder {
        public CircleImageView civavatarchat;
        public TextView txtvmessage,txtvmessagedate;


        public ViewHolderCt(@NonNull View itemView) {
            super(itemView);
            civavatarchat = itemView.findViewById(R.id.civavatarchat);
            txtvmessage = itemView.findViewById(R.id.txtvmessage);
            txtvmessagedate = itemView.findViewById(R.id.txtvmessagedate);
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
