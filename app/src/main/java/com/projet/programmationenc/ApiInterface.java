package com.projet.programmationenc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("courses.php")
    Call<Course> getCourse(@Query("courseID") String id);
//    Call<List<Course>> getCourse(@Query("courseID") String id);
}
