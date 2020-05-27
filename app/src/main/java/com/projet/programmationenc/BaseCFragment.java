package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseCFragment extends Fragment {
    private RelativeLayout btnpremierprogc,btnbackslashn,btntypevar,btntypecar,btnputchar,btnlireclav,btntypebase,btnspeciform,btnop,btnconstant;
    private String id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).ShowBackButton(true);
        btnpremierprogc = view.findViewById(R.id.btnpremierprogc);
        btnbackslashn = view.findViewById(R.id.btnbackslashn);
        btntypevar = view.findViewById(R.id.btntypevar);
        btntypecar = view.findViewById(R.id.btntypecar);
        btnputchar = view.findViewById(R.id.btnputchar);
        btnlireclav = view.findViewById(R.id.btnlireclav);
        btntypebase = view.findViewById(R.id.btntypebase);
        btnspeciform = view.findViewById(R.id.btnspeciform);
        btnop = view.findViewById(R.id.btnop);
        btnconstant = view.findViewById(R.id.btnconstant);

        btnpremierprogc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "premierprogc";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnbackslashn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "backslashn";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypevar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "typevar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "typecar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnputchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "putchar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnlireclav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "lireclav";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "typebase";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnspeciform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "speciform";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "op";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnconstant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = "constant";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });
    }
}
