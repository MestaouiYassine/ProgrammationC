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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatsFragment extends Fragment {
    private static final String TAG = "ChatsFragment";
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private RecyclerView rvchats;
    private LinearLayoutManager rvmanager;
    private FirebaseRecyclerOptions<LastChat> options;
    private FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private TextView txtvchatsempty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chats,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Liste de conversations");
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        rvchats = view.findViewById(R.id.rvchats);
        rvmanager = new LinearLayoutManager(getActivity());
        txtvchatsempty = view.findViewById(R.id.txtvchatsempty);

        Query query = FirebaseDatabase.getInstance().getReference().child("Last Chats").child(user.getUid());
        options = new FirebaseRecyclerOptions.Builder<LastChat>()
                .setQuery(query, LastChat.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<LastChat,ViewHolderCts>(options) {
            @NonNull
            @Override
            public ViewHolderCts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_chats, parent, false);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = rvchats.getChildLayoutPosition(view);
                        String key = databaseReference.child("Last Chats").child(user.getUid()).child(getRef(itemPosition).getKey()).getKey();
                        Log.e(TAG, "onClick: key : " + key);
                        Bundle bundle = new Bundle();
                        bundle.putString("key",key);
                        ChatFragment chatFragment = new ChatFragment();
                        chatFragment.setArguments(bundle);
                        ((HomeActivity) getActivity()).ShowBackButton(true);
                        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,chatFragment).addToBackStack(null).commit();
                    }
                });
                return new ViewHolderCts(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolderCts holder, int position, @NonNull LastChat model) {
                if(user.getUid().equals(model.getSenderId())) {
                    Glide.with(getActivity())
                            .load(Uri.parse(model.getReceiverAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(holder.civavatarachats);
                    holder.txtvfullnamechats.setText(model.getReceiverFirstName() + " " + model.getReceiverLastName());
                }
                else {
                    Glide.with(getActivity())
                            .load(Uri.parse(model.getSenderAvatar()))
                            .apply(RequestOptions.fitCenterTransform())
                            .into(holder.civavatarachats);
                    holder.txtvfullnamechats.setText(model.getSenderFirstName() + " " + model.getSenderLastName());
                }
                holder.txtvmessagechats.setText(model.getLastMessage());
                holder.txtvdatechats.setText(GetTimeAgo.getTimeAgo(model.getLastChatMillis(),getActivity()));
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if(firebaseRecyclerAdapter.getItemCount() == 0) {
                    txtvchatsempty.setVisibility(View.VISIBLE);
                }
                else {
                    txtvchatsempty.setVisibility(View.GONE);
                }
            }
        };

        rvchats.setLayoutManager(rvmanager);
        rvchats.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ViewHolderCts extends RecyclerView.ViewHolder {
        public CircleImageView civavatarachats;
        public TextView txtvfullnamechats,txtvmessagechats,txtvdatechats;


        public ViewHolderCts(@NonNull View itemView) {
            super(itemView);
            civavatarachats = itemView.findViewById(R.id.civavatarachats);
            txtvfullnamechats = itemView.findViewById(R.id.txtvfullnamechats);
            txtvmessagechats = itemView.findViewById(R.id.txtvmessagechats);
            txtvdatechats = itemView.findViewById(R.id.txtvdatechats);
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
