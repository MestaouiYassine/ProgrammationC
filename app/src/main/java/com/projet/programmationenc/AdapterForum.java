package com.projet.programmationenc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterForum extends RecyclerView.Adapter<AdapterForum.ViewHolderFm> {
    private List<CardViewForum> cardViewForumList;
    private Context context;

    public static class ViewHolderFm extends RecyclerView.ViewHolder {
        public CircleImageView civavatarforum;
        public TextView txtvfullnameforum,txtvquestionforum,txtvdatePost;


        public ViewHolderFm(@NonNull View itemView) {
            super(itemView);
            civavatarforum = itemView.findViewById(R.id.civavatarforum);
            txtvfullnameforum = itemView.findViewById(R.id.txtvfullnameforum);
            txtvquestionforum = itemView.findViewById(R.id.txtvquestionforum);
            txtvdatePost = itemView.findViewById(R.id.txtvdatePost);
        }
    }

    public AdapterForum(List<CardViewForum> cardViewForumList,Context context) {
        this.cardViewForumList = cardViewForumList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderFm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_forum,parent,false);
        ViewHolderFm vhf = new ViewHolderFm(v);
        return vhf;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFm holder, int position) {
        CardViewForum currentItem = cardViewForumList.get(position);

        holder.civavatarforum.setImageURI(currentItem.getForumAvatar());
        holder.txtvfullnameforum.setText(currentItem.getForumFullName());
        holder.txtvquestionforum.setText(currentItem.getForumQuestion());
        holder.txtvdatePost.setText(currentItem.getForumDatePost().toString());
    }

    @Override
    public int getItemCount() {
        return cardViewForumList.size();
    }
}
