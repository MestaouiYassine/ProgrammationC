package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class MenuCoursesFragment extends Fragment {
    private static final String TAG = "MenuCoursesFragment";
    private ImageButton btnbasec,btncondit;
    private TextView txtvbasec,txtvcondit;
//    private FirebaseUser user;
//    public static List<String> completedBasic = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menucourses,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        user = FirebaseAuth.getInstance().getCurrentUser();

        btnbasec = view.findViewById(R.id.btnbasec);
        btncondit = view.findViewById(R.id.btncondit);

        txtvbasec = view.findViewById(R.id.txtvbasec);
        txtvcondit = view.findViewById(R.id.txtvcondit);

//        String[] basicCourses = new String[completedBasic.size()];
//        completedBasic.toArray(basicCourses);
//
//        String base_url = "http://192.168.1.104/progc/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(base_url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<Student> call = apiInterface.updateBasic(user.getUid(),basicCourses);
//
//        call.enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//                if(!response.isSuccessful()) {
//                    Log.e(TAG, "onResponse: Code " + response.code());
//                    return;
//                }
//                Log.e(TAG, "onResponse: " + "basicCourses in mysql");
//
//                getActivity().finish();
//                getActivity().overridePendingTransition(0, 0);
//                startActivity(getActivity().getIntent());
//                getActivity().overridePendingTransition(0, 0);
////                                            Intent intent = getActivity().getIntent();
////                                            intent.putExtra("fragedit","changepassword");
////                                            startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t) {
//                Log.e(TAG, "onFailure: " + t.getMessage());
//            }
//        });

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
