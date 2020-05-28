package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StructFragment extends Fragment {
    private static final String TAG = "StructFragment";
    private RelativeLayout btnenum,btnsstruct,btnstructtab;
    private TextView txtvenum,txtvsstruct,txtvstructtab;
    public static List<String> completedEnumStruct = new ArrayList<>();
    private String id;
    private FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_structs,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if(((HomeActivity) getActivity()).retrievedCompletedEnumStruct.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedEnumStruct is foking empty");
        }
        else {
            completedEnumStruct = ((HomeActivity) getActivity()).retrievedCompletedEnumStruct;
        }

        btnenum = view.findViewById(R.id.btnenum);
        btnsstruct = view.findViewById(R.id.btnsstruct);
        btnstructtab = view.findViewById(R.id.btnstructtab);

        txtvenum = view.findViewById(R.id.txtvenum);
        txtvsstruct = view.findViewById(R.id.txtvsstruct);
        txtvstructtab = view.findViewById(R.id.txtvstructtab);


        if(completedEnumStruct.contains("enum")) {
            txtvenum.setText("Complet");
            txtvenum.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedEnumStruct.contains("struct")) {
            txtvsstruct.setText("Complet");
            txtvsstruct.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedEnumStruct.contains("structtab")) {
            txtvstructtab.setText("Complet");
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("enum")) {
                    completedEnumStruct.add("enum");
                    updateEnumStructCourse();
                }
                id = "enum";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnsstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("struct")) {
                    completedEnumStruct.add("struct");
                    updateEnumStructCourse();
                }
                id = "struct";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnstructtab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("structtab")) {
                    completedEnumStruct.add("structtab");
                    updateEnumStructCourse();
                }
                id = "structtab";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });


        if(completedEnumStruct.isEmpty()) {

            btnsstruct.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnsstruct.setClickable(false);
            txtvsstruct.setTextColor(getResources().getColor(R.color.black));
            txtvsstruct.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvsstruct.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstructtab.setClickable(false);
            txtvstructtab.setTextColor(getResources().getColor(R.color.black));
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstructtab.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedEnumStruct.size() == 1 && completedEnumStruct.contains("enum")) {

            btnstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstructtab.setClickable(false);
            txtvstructtab.setTextColor(getResources().getColor(R.color.black));
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstructtab.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
    }

    private void updateEnumStructCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedEnumStruct) {
            if(!s.equals(completedEnumStruct.get(completedEnumStruct.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeBase = stringBuilder.toString();

        String base_url = "http://192.168.1.104/progc/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Student> call = apiInterface.updateEnumStruct(user.getUid(),completeBase);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code " + response.code());
                    return;
                }
                Log.e(TAG, "onResponse: " + "enumStructCourse in mysql");


            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
