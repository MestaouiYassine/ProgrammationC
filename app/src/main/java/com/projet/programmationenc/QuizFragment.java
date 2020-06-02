package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizFragment extends Fragment {
    private static final String TAG = "QuizFragment";
    private TextView txtvquestion1,txtvquestion2,txtvquestion3,txtvquestion4,txtvquestion5;
    private RadioGroup rgq1,rgq2,rgq3,rgq4;
    private RadioButton rbq1rp1,rbq1rp2,rbq1rp3,rbq1rp4,rbq2rp1,rbq2rp2,rbq2rp3,rbq2rp4,rbq3rp1,rbq3rp2,rbq3rp3,rbq3rp4,rbq4rp1,rbq4rp2,rbq4rp3,rbq4rp4,rbq5rp1,rbq5rp2,rbq5rp3,rbq5rp4;
    private String rep1,rep2,rep3,rep4,rep5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String base_url = "http://192.168.1.104/progc/";

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        txtvquestion1 = view.findViewById(R.id.txtvquestion1);
        txtvquestion2 = view.findViewById(R.id.txtvquestion2);
        txtvquestion3 = view.findViewById(R.id.txtvquestion3);
        txtvquestion4 = view.findViewById(R.id.txtvquestion4);
        txtvquestion5 = view.findViewById(R.id.txtvquestion5);

        rgq1 = view.findViewById(R.id.rgq1);
        rgq2 = view.findViewById(R.id.rgq2);
        rgq3 = view.findViewById(R.id.rgq3);
        rgq4 = view.findViewById(R.id.rgq4);

        rbq1rp1 = view.findViewById(R.id.rbq1rp1);
        rbq1rp2 = view.findViewById(R.id.rbq1rp2);
        rbq1rp3 = view.findViewById(R.id.rbq1rp3);
        rbq1rp4 = view.findViewById(R.id.rbq1rp4);

        rbq2rp1 = view.findViewById(R.id.rbq2rp1);
        rbq2rp2 = view.findViewById(R.id.rbq2rp2);
        rbq2rp3 = view.findViewById(R.id.rbq2rp3);
        rbq2rp4 = view.findViewById(R.id.rbq2rp4);

        rbq3rp1 = view.findViewById(R.id.rbq3rp1);
        rbq3rp2 = view.findViewById(R.id.rbq3rp2);
        rbq3rp3 = view.findViewById(R.id.rbq3rp3);
        rbq3rp4 = view.findViewById(R.id.rbq3rp4);

        rbq4rp1 = view.findViewById(R.id.rbq4rp1);
        rbq4rp2 = view.findViewById(R.id.rbq4rp2);
        rbq4rp3 = view.findViewById(R.id.rbq4rp3);
        rbq4rp4 = view.findViewById(R.id.rbq4rp4);

        rbq5rp1 = view.findViewById(R.id.rbq5rp1);
        rbq5rp2 = view.findViewById(R.id.rbq5rp2);
        rbq5rp3 = view.findViewById(R.id.rbq5rp3);
        rbq5rp4 = view.findViewById(R.id.rbq5rp4);


        String category;
        String title = getArguments().getString("title");
        if(title.equals("Quiz : Les bases du langage C")) {
            category = "basec";
        }
        else if(title.equals("Quiz : Les structures conditionelles et les boucles")) {
            category = "condit";
        }
        else if(title.equals("Quiz : Les fonctions, les tableaux et les pointeurs")) {
            category = "functarray";
        }
        else if(title.equals("Quiz : Les chaînes de caractères")) {
            category = "strings";
        }
        else if(title.equals("Quiz : Les structures et les énumérations")) {
            category = "struct";
        }
        else {
            category = "file";
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Quiz>> call = apiInterface.getQuiz(category);
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                if(!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code : " + response.code());
                    Toast.makeText(getContext(),"Code : " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Quiz> quiz = new ArrayList<>();
                quiz = response.body();

                for(Quiz q : quiz) {
                    if(q.getQuizID().equals(category+"1")) {
                        txtvquestion1.setText(q.getQuestion());
                        rbq1rp1.setText(q.getResp1());
                        rbq1rp2.setText(q.getResp2());
                        rbq1rp3.setText(q.getResp3());
                        rbq1rp4.setText(q.getResp4());
                        rep1 = q.getResp();
                    }
                    else if(q.getQuizID().equals(category+"2")) {
                        txtvquestion2.setText(q.getQuestion());
                        rbq2rp1.setText(q.getResp1());
                        rbq2rp2.setText(q.getResp2());
                        rbq2rp3.setText(q.getResp3());
                        rbq2rp4.setText(q.getResp4());
                        rep2 = q.getResp();
                    }
                    else if(q.getQuizID().equals(category+"3")) {
                        txtvquestion3.setText(q.getQuestion());
                        rbq3rp1.setText(q.getResp1());
                        rbq3rp2.setText(q.getResp2());
                        rbq3rp3.setText(q.getResp3());
                        rbq3rp4.setText(q.getResp4());
                        rep3 = q.getResp();
                    }
                    else if(q.getQuizID().equals(category+"4")) {
                        txtvquestion4.setText(q.getQuestion());
                        rbq4rp1.setText(q.getResp1());
                        rbq4rp2.setText(q.getResp2());
                        rbq4rp3.setText(q.getResp3());
                        rbq4rp4.setText(q.getResp4());
                        rep4 = q.getResp();
                    }
                    else {
                        txtvquestion5.setText(q.getQuestion());
                        rbq5rp1.setText(q.getResp1());
                        rbq5rp2.setText(q.getResp2());
                        rbq5rp3.setText(q.getResp3());
                        rbq5rp4.setText(q.getResp4());
                        rep5 = q.getResp();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Log.e(TAG, "onFailure: throwable msg : " + t.getMessage());
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
