package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesFragment extends Fragment {
//    public static ApiInterface apiInterface;
//    private EditText edtidcourse;
    private TextView txtvtitle,txtvcourse;
    private Button btncontinue;
//    192.168.1.104
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Cours");
        return inflater.inflate(R.layout.fragment_courses,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        String base_url = "http://192.168.1.104/progc/";

        txtvtitle = view.findViewById(R.id.txtvtitle);
        txtvcourse = view.findViewById(R.id.txtvcourse);
        btncontinue = view.findViewById(R.id.btncontinue);

        String id = getArguments().getString("id");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Course> call = apiInterface.getCourse(id);
        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if(!response.isSuccessful()) {
                    txtvcourse.setText("Code : " + response.code());
                    return;
                }
                Course course = response.body();
                txtvtitle.setText(course.getTitle());
                txtvcourse.setText(course.getContent());
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                txtvcourse.setText(t.getMessage());
            }
        });

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).commit();
                getActivity().onBackPressed();
            }
        });

    }

}
