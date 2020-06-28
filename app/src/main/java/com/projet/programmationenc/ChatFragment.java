package com.projet.programmationenc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatFragment extends Fragment {
    private static final String TAG = "ChatFragment";
    private String key;
    private Student S;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private ImageButton btnsendimage,btnsendmessage;
    private TextInputLayout edtsendmessage;
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

        btnsendimage = view.findViewById(R.id.btnsendimage);
        btnsendmessage = view.findViewById(R.id.btnsendmessage);
        edtsendmessage = view.findViewById(R.id.edtsendmessage);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        key = getArguments().getString("key");
        RetrieveChatterInfo(key);

        databaseReference.child("Chats").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(key)) {
                    Map chatAddMap = new HashMap();
                    chatAddMap.put("seen",false);
                    chatAddMap.put("timestamp",ServerValue.TIMESTAMP);

                    Map chatUserMap = new HashMap();
                    chatUserMap.put("Chats/" + user.getUid() + "/" + key, chatAddMap);
                    chatUserMap.put("Chats/" + key + "/" + user.getUid(), chatAddMap);

                    databaseReference.updateChildren(chatUserMap, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            if(error != null) {
                                Log.e(TAG, "onComplete: Error : " + error.getMessage());
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnsendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

    }

    public void RetrieveChatterInfo(String key) {
        databaseReference.child("Students").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    S = snapshot.getValue(Student.class);
                    boolean status = snapshot.child("online").getValue(Boolean.class);
                    long lastSeen = snapshot.child("lastseen").getValue(Long.class);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'à' HH:mm");
                    ((HomeActivity) getActivity()).txtvfullnamebar.setText(S.getFirstName() + " " + S.getLastName());

                    Glide.with(getActivity())
                            .load(Uri.parse(S.getAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(((HomeActivity) getActivity()).civavatarbar);

                    if(status) {
                        ((HomeActivity) getActivity()).txtvseenbar.setText("Online");
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

    public void sendMessage() {
        String message = edtsendmessage.getEditText().getText().toString().trim();
        if(!message.isEmpty()) {
            String user_ref = "Messages/" + user.getUid() + "/" + key;
            String otheruser_ref = "Messages/" + key + "/" + user.getUid();
            String pushkey = databaseReference.child("Messages").child(user.getUid()).child(key).push().getKey();

            Map messageMap = new HashMap();
            messageMap.put("message", message);
            messageMap.put("seen", false);
            messageMap.put("type", "text");
            messageMap.put("time", ServerValue.TIMESTAMP);

            Map messageUserMap = new HashMap();
            messageUserMap.put(user_ref + "/" + pushkey, messageMap);
            messageUserMap.put(otheruser_ref + "/" + pushkey, messageMap);

            databaseReference.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    if(error != null) {
                        Log.e(TAG, "onComplete: Error : " + error.getMessage());
                    }
                }
            });
            edtsendmessage.getEditText().setText(null);
        }
    }
}
