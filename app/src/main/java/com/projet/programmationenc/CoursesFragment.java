package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesFragment extends Fragment {
    public static ApiInterface apiInterface;
//    private EditText edtidcourse;
    private TextView txtvaffichcourse;
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
//        edtidcourse = view.findViewById(R.id.edtidcourse);
        String base_url = "http://192.168.1.104/progc/";
        txtvaffichcourse = view.findViewById(R.id.txtvaffichcourse);
        String id;
//        id = edtidcourse.getText().toString();
        id = "C1";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        Call<Course> call = apiInterface.getCourse(id);
        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if(!response.isSuccessful()) {
                    txtvaffichcourse.setText("Code : " + response.code());
                    return;
                }
                Course course = response.body();
                txtvaffichcourse.setText(course.getContent());
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                txtvaffichcourse.setText(t.getMessage());
            }
        });
//        Call<List<Course>> call = apiInterface.getCourse(id);
//        call.enqueue(new Callback<List<Course>>() {
//            @Override
//            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
//                if(!response.isSuccessful()) {
//                    txtvaffichcourse.setText("Code : " + response.code());
//                    return;
//                }
//                List<Course> courses = response.body();
//
//                for(Course course : courses) {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Course>> call, Throwable t) {
//                txtvaffichcourse.setText(t.getMessage());
//            }
//        });
    }

}
