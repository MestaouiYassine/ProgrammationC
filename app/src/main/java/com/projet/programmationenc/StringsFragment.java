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

public class StringsFragment extends Fragment {
    private static final String TAG = "StringsFragment";
    private RelativeLayout btnstring1,btnstring2,btnstring3;
    private TextView txtvstring1,txtvstring2,txtvstring3;
    private String id;
    private FirebaseUser user;
    public static List<String> completedStrings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_strings,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if(((HomeActivity) getActivity()).retrievedCompletedStrings.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedStrings is foking empty");
        }
        else {
            completedStrings = ((HomeActivity) getActivity()).retrievedCompletedStrings;
        }

        btnstring1 = view.findViewById(R.id.btnstring1);
        btnstring2 = view.findViewById(R.id.btnstring2);
        btnstring3 = view.findViewById(R.id.btnstring3);

        txtvstring1 = view.findViewById(R.id.txtvstring1);
        txtvstring2 = view.findViewById(R.id.txtvstring2);
        txtvstring3 = view.findViewById(R.id.txtvstring3);


        if(completedStrings.contains("string1")) {
            txtvstring1.setText("Complet");
            txtvstring1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedStrings.contains("string2")) {
            txtvstring2.setText("Complet");
            txtvstring2.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedStrings.contains("string3")) {
            txtvstring3.setText("Complet");
            txtvstring3.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnstring1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedStrings.contains("string1")) {
                    completedStrings.add("string1");
                    updateStringsCourse();
                }
                id = "string1";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnstring2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedStrings.contains("string2")) {
                    completedStrings.add("string2");
                    updateStringsCourse();
                }
                id = "string2";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnstring3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedStrings.contains("string3")) {
                    completedStrings.add("string3");
                    updateStringsCourse();
                }
                id = "string3";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });


        if(completedStrings.isEmpty()) {

            btnstring2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstring2.setClickable(false);
            txtvstring2.setTextColor(getResources().getColor(R.color.black));
            txtvstring2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstring2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnstring3.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstring3.setClickable(false);
            txtvstring3.setTextColor(getResources().getColor(R.color.black));
            txtvstring3.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstring3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedStrings.size() == 1 && completedStrings.contains("string1")) {

            btnstring3.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstring3.setClickable(false);
            txtvstring3.setTextColor(getResources().getColor(R.color.black));
            txtvstring3.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstring3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }

    }

    private void updateStringsCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedStrings) {
            if(!s.equals(completedStrings.get(completedStrings.size() - 1))) {
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
        Call<Student> call = apiInterface.updateStrings(user.getUid(),completeBase);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code " + response.code());
                    return;
                }
                Log.e(TAG, "onResponse: " + "stringCourse in mysql");


            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
