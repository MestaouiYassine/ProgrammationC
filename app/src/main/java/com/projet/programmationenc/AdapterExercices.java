package com.projet.programmationenc;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterExercices extends RecyclerView.Adapter<AdapterExercices.ViewHolderEx> {
    private List<CardViewExercices> cardViewExercicesList;
    private Context context;
    private String title;
    private int currentPosition = -1;

    public static class ViewHolderEx extends RecyclerView.ViewHolder {
        public CircleImageView civcvrv;
        public TextView txtvcvrv;
        public ToggleButton btnrvarrow;
        public LinearLayout llexpanded;
        public Button btnrvquiz1,btnrvquiz2,btnrvex1,btnrvex2;

        public ViewHolderEx(@NonNull View itemView) {
            super(itemView);
            civcvrv = itemView.findViewById(R.id.civcvrv);
            txtvcvrv = itemView.findViewById(R.id.txtvcvrv);
            btnrvarrow = itemView.findViewById(R.id.btnrvarrow);
            llexpanded = itemView.findViewById(R.id.llexpanded);
            btnrvquiz1 = itemView.findViewById(R.id.btnrvquiz1);
            btnrvquiz2 = itemView.findViewById(R.id.btnrvquiz2);
            btnrvex1 = itemView.findViewById(R.id.btnrvex1);
            btnrvex2 = itemView.findViewById(R.id.btnrvex2);
        }
    }

    public AdapterExercices(List<CardViewExercices> cardViewExercicesList,Context context) {
        this.cardViewExercicesList = cardViewExercicesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderEx onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_exercices,parent,false);
        ViewHolderEx vhx = new ViewHolderEx(v);
        return vhx;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEx holder, int position) {
        CardViewExercices currentItem = cardViewExercicesList.get(position);

//        for(CardViewExercices c : cardViewExercicesList) {
//            if(!c.equals(currentItem) && c.isSelected()) {
//                setImageButton(holder.btnrvarrow,!c.isSelected());
//            }
//        }
        holder.civcvrv.setImageResource(currentItem.getImageResource());
        holder.txtvcvrv.setText(currentItem.getmText());
        holder.btnrvquiz1.setText(currentItem.getmQuiz1());
        holder.btnrvquiz2.setText(currentItem.getmQuiz2());
        holder.btnrvex1.setText(currentItem.getmEx1());
        holder.btnrvex2.setText(currentItem.getmEx2());
//        holder.btnrvarrow.setBackgroundResource(currentItem.getButtonResource());
        setImageButton(holder.btnrvarrow,currentItem.isSelected());

        holder.llexpanded.setVisibility(View.GONE);

        if(currentPosition == position && holder.btnrvarrow.isChecked()) {
            Animation slideDown = AnimationUtils.loadAnimation(context,R.anim.slidedown);
            holder.llexpanded.setVisibility(View.VISIBLE);
            holder.llexpanded.startAnimation(slideDown);
//            notifyItemChanged(position);
        }

//        else if(currentPosition != position && holder.btnrvarrow.isChecked()) {
//            holder.btnrvarrow.setChecked(false);
//        }


        holder.btnrvarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = position;
                currentItem.setSelected(!currentItem.isSelected());
                setImageButton(holder.btnrvarrow,currentItem.isSelected());
//                holder.btnrvarrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_40);
//                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });

        holder.btnrvquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("title",currentItem.getmQuiz1());
                QuizFragment quizFragment = new QuizFragment();
                quizFragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,quizFragment).addToBackStack(null).commit();

            }
        });

        holder.btnrvquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,new QuizBaseCFragment()).addToBackStack(null).commit();
            }
        });

        holder.btnrvex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("extitle",currentItem.getmEx1());
                ExFragment exFragment = new ExFragment();
                exFragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,exFragment).addToBackStack(null).commit();
            }
        });

        holder.btnrvex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("extitle",currentItem.getmEx2());
                ExFragment exFragment = new ExFragment();
                exFragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,exFragment).addToBackStack(null).commit();
            }
        });

    }

    private void setImageButton(ToggleButton button, boolean isSelected) {
        if(isSelected) {
//            button.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_40);
            button.setChecked(true);
        }
        else {
//            button.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_right_40);
            button.setChecked(false);
        }
    }




    @Override
    public int getItemCount() {
        return cardViewExercicesList.size();
    }
}
