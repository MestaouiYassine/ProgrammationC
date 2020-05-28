package com.projet.programmationenc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("courses.php")
    Call<Course> getCourse(@Query("courseID") String courseID);

    @GET("student.php")
    Call<Student> getStudent(@Query("studentID") String studentID);

    @FormUrlEncoded
    @POST("insert.php")
    Call<Student> insertStudent(
            @Field("studentID") String studentID,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("pass") String password,
            @Field("avatar") String avatar
    );

    @FormUrlEncoded
    @POST("updateprofile.php")
    Call<Student> updateStudent(
            @Field("studentID") String studentID,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("avatar") String avatar
    );

    @FormUrlEncoded
    @POST("changepassword.php")
    Call<Student> changePassword(
            @Field("studentID") String studentID,
            @Field("pass") String password
    );

    @FormUrlEncoded
    @POST("basic.php")
    Call<Student> updateBasic(
            @Field("studentID") String studentID,
            @Field("completedBasic") String completedBasic
    );

    @FormUrlEncoded
    @POST("condloop.php")
    Call<Student> updateCondLoop(
            @Field("studentID") String studentID,
            @Field("completedCondLoop") String completedCondLoop
    );

    @FormUrlEncoded
    @POST("funcarray.php")
    Call<Student> updateFuncArrPoint(
            @Field("studentID") String studentID,
            @Field("completedFuncArrPoint") String completedFuncArrPoint
    );

    @FormUrlEncoded
    @POST("strings.php")
    Call<Student> updateStrings(
            @Field("studentID") String studentID,
            @Field("completedStrings") String completedStrings
    );

    @FormUrlEncoded
    @POST("structs.php")
    Call<Student> updateEnumStruct(
            @Field("studentID") String studentID,
            @Field("completedEnumStruct") String completedEnumStruct
    );

    @FormUrlEncoded
    @POST("files.php")
    Call<Student> updateFiles(
            @Field("studentID") String studentID,
            @Field("completedFiles") String completedFiles
    );
//    @GET("getbasic.php")
//    Call<Student> getBasic(@Query("courseID") String courseID);
//    Call<List<Course>> getCourse(@Query("courseID") String id);
}
