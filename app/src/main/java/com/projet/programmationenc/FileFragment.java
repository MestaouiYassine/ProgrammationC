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

public class FileFragment extends Fragment {
    private static final String TAG = "FileFragment";
    private RelativeLayout btnfile1,btnfile2;
    private TextView txtvfile1,txtvfile2;
    public static List<String> completedFiles = new ArrayList<>();
    private String id;
    private FirebaseUser user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_file,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if(((HomeActivity) getActivity()).retrievedCompletedFiles.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedFiles is foking empty");
        }
        else {
            completedFiles = ((HomeActivity) getActivity()).retrievedCompletedFiles;
        }

        btnfile1 = view.findViewById(R.id.btnfile1);
        btnfile2 = view.findViewById(R.id.btnfile2);

        txtvfile1 = view.findViewById(R.id.txtvfile1);
        txtvfile2 = view.findViewById(R.id.txtvfile2);


        if(completedFiles.contains("file1")) {
            txtvfile1.setText("Complet");
            txtvfile1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFiles.contains("file2")) {
            txtvfile2.setText("Complet");
            txtvfile2.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFiles.contains("file1")) {
                    completedFiles.add("file1");
                    updateFileCourse();
                }
                id = "file1";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFiles.contains("file2")) {
                    completedFiles.add("file2");
                    updateFileCourse();
                }
                id = "file2";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });



        if(completedFiles.isEmpty()) {

            btnfile2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfile2.setClickable(false);
            txtvfile2.setTextColor(getResources().getColor(R.color.black));
            txtvfile2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfile2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
    }

    private void updateFileCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedFiles) {
            if(!s.equals(completedFiles.get(completedFiles.size() - 1))) {
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
        Call<Student> call = apiInterface.updateFiles(user.getUid(),completeBase);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code " + response.code());
                    return;
                }
                Log.e(TAG, "onResponse: " + "fileCourse in mysql");


            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
