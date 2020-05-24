package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuCoursesFragment extends Fragment {
    private ImageButton btnbasec,btncondit;
    private TextView txtvbasec,txtvcondit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menucourses,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnbasec = view.findViewById(R.id.btnbasec);
        btncondit = view.findViewById(R.id.btncondit);

        txtvbasec = view.findViewById(R.id.txtvbasec);
        txtvcondit = view.findViewById(R.id.txtvcondit);

        btnbasec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).addToBackStack(null).commit();
            }
        });

        txtvbasec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).addToBackStack(null).commit();
            }
        });

        btncondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
            }
        });

        txtvcondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
            }
        });
    }
}
