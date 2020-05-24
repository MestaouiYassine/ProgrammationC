package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConditFragment extends Fragment {
    private Button btnifelse,btnoplog,btnswitch,btnwhile,btndowhile,btnfor;
    private String id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_condit,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).ShowBackButton(true);
        btnifelse = view.findViewById(R.id.btnifelse);
        btnoplog = view.findViewById(R.id.btnoplog);
        btnswitch = view.findViewById(R.id.btnswitch);
        btnwhile = view.findViewById(R.id.btnwhile);
        btndowhile = view.findViewById(R.id.btndowhile);
        btnfor = view.findViewById(R.id.btnfor);

        btnifelse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "ifelse";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnoplog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "oplog";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "switch";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnwhile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "while";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btndowhile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "dowhile";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "for";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });
    }
}
