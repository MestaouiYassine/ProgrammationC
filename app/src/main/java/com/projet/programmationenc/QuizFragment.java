package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizFragment extends Fragment {
    private static final String TAG = "QuizFragment";
    private TextView txtvquestion1,txtvquestion2,txtvquestion3,txtvquestion4,txtvquestion5,txtvqzresult;
    private RadioGroup rgq1,rgq2,rgq3,rgq4,rgq5;
    private RadioButton rbq1rp1,rbq1rp2,rbq1rp3,rbq1rp4,rbq2rp1,rbq2rp2,rbq2rp3,rbq2rp4,rbq3rp1,rbq3rp2,rbq3rp3,rbq3rp4,rbq4rp1,rbq4rp2,rbq4rp3,rbq4rp4,rbq5rp1,rbq5rp2,rbq5rp3,rbq5rp4;
    private String rep1,rep2,rep3,rep4,rep5;
    private Button btnqzcheck,btnqzshow;
    private int result = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String base_url = ((HomeActivity) getActivity()).base_url;

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        txtvquestion1 = view.findViewById(R.id.txtvquestion1);
        txtvquestion2 = view.findViewById(R.id.txtvquestion2);
        txtvquestion3 = view.findViewById(R.id.txtvquestion3);
        txtvquestion4 = view.findViewById(R.id.txtvquestion4);
        txtvquestion5 = view.findViewById(R.id.txtvquestion5);

        txtvqzresult = view.findViewById(R.id.txtvqzresult);

        rgq1 = view.findViewById(R.id.rgq1);
        rgq2 = view.findViewById(R.id.rgq2);
        rgq3 = view.findViewById(R.id.rgq3);
        rgq4 = view.findViewById(R.id.rgq4);
        rgq5 = view.findViewById(R.id.rgq5);

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

        btnqzcheck = view.findViewById(R.id.btnqzcheck);
        btnqzshow = view.findViewById(R.id.btnqzshow);

        String category;
        String title = getArguments().getString("title");
        switch (title) {
            case "Quiz 1 : Les bases du langage C":
                category = "basec";
                break;
            case "Quiz 1 : Les structures conditionelles et les boucles":
                category = "condit";
                break;
            case "Quiz 1 : Les fonctions, les tableaux et les pointeurs":
                category = "functarray";
                break;
            case "Quiz 1 : Les chaînes de caractères":
                category = "strings";
                break;
            case "Quiz 1 : Les structures et les énumérations":
                category = "struct";
                break;
            default:
                category = "file";
                break;
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

        List<RadioButton> rg1 = new ArrayList<>();
        rg1.add(rbq1rp1);
        rg1.add(rbq1rp2);
        rg1.add(rbq1rp3);
        rg1.add(rbq1rp4);

        List<RadioButton> rg2 = new ArrayList<>();
        rg2.add(rbq2rp1);
        rg2.add(rbq2rp2);
        rg2.add(rbq2rp3);
        rg2.add(rbq2rp4);

        List<RadioButton> rg3 = new ArrayList<>();
        rg3.add(rbq3rp1);
        rg3.add(rbq3rp2);
        rg3.add(rbq3rp3);
        rg3.add(rbq3rp4);

        List<RadioButton> rg4 = new ArrayList<>();
        rg4.add(rbq4rp1);
        rg4.add(rbq4rp2);
        rg4.add(rbq4rp3);
        rg4.add(rbq4rp4);

        List<RadioButton> rg5 = new ArrayList<>();
        rg5.add(rbq5rp1);
        rg5.add(rbq5rp2);
        rg5.add(rbq5rp3);
        rg5.add(rbq5rp4);



//        if(result == 0) {
            btnqzcheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(result == 0 && btnqzcheck.getText().equals("Vérifier")) {
                        if(rgq1.getCheckedRadioButtonId() == -1 || rgq2.getCheckedRadioButtonId() == -1 || rgq3.getCheckedRadioButtonId() == -1 || rgq4.getCheckedRadioButtonId() == -1 || rgq5.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getContext(), "Veuillez répondre à tous les quiz", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            for(RadioButton r : rg1) {
                                if(r.getText().equals(rep1) && r.getId() == rgq1.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
                                    result++;
                                    break;
                                }
                            }
                            for(RadioButton r : rg1) {
                                if(!r.getText().equals(rep1) && r.getId() == rgq1.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.red));
                                }
//                                if(r.getText().equals(rep1)) {
//                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
//                                }
                            }


                            for(RadioButton r : rg2) {
                                if(r.getText().equals(rep2) && r.getId() == rgq2.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
                                    result++;
                                    break;
                                }
                            }
                            for(RadioButton r : rg2) {
                                if(!r.getText().equals(rep2) && r.getId() == rgq2.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.red));
                                }
//                                if(r.getText().equals(rep2)) {
//                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
//                                }
                            }


                            for(RadioButton r : rg3) {
                                if(r.getText().equals(rep3) && r.getId() == rgq3.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
                                    result++;
                                    break;
                                }
                            }
                            for(RadioButton r : rg3) {
                                if(!r.getText().equals(rep3) && r.getId() == rgq3.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.red));
                                }
//                                if(r.getText().equals(rep3)) {
//                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
//                                }
                            }


                            for(RadioButton r : rg4) {
                                if(r.getText().equals(rep4) && r.getId() == rgq4.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
                                    result++;
                                    break;
                                }
                            }
                            for(RadioButton r : rg4) {
                                if(!r.getText().equals(rep4) && r.getId() == rgq4.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.red));
                                }
//                                if(r.getText().equals(rep4)) {
//                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
//                                }
                            }


                            for(RadioButton r : rg5) {
                                if(r.getText().equals(rep5) && r.getId() == rgq5.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
                                    result++;
                                    break;
                                }
                            }
                            for(RadioButton r : rg5) {
                                if(!r.getText().equals(rep5) && r.getId() == rgq5.getCheckedRadioButtonId()) {
                                    r.setTextColor(getResources().getColor(R.color.red));
                                }
//                                if(r.getText().equals(rep5)) {
//                                    r.setTextColor(getResources().getColor(R.color.lightgreen));
//                                }
                            }

                            txtvqzresult.setVisibility(View.VISIBLE);

                            txtvqzresult.setText("Résultat : " + result + "/5");

                            if(result == 5) {
                                txtvqzresult.setTextColor(getResources().getColor(R.color.lightgreen));
                            }
                            else {
                                txtvqzresult.setTextColor(getResources().getColor(R.color.red));
                            }

                            if(result == 5) {
                                btnqzcheck.setText("Continuer");
                                btnqzcheck.setBackground(getResources().getDrawable(R.drawable.button));
                            }
                            else {
                                btnqzcheck.setText("Réessayer");
                                btnqzcheck.setBackground(getResources().getDrawable(R.drawable.buttonred));

                                btnqzshow.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    else if(result == 5) {
                        getActivity().onBackPressed();
                    }
                    else {
                        rgq1.clearCheck();
                        rgq2.clearCheck();
                        rgq3.clearCheck();
                        rgq4.clearCheck();
                        rgq5.clearCheck();

                        result = 0;

                        Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                        if (currentFragment instanceof QuizFragment) {
                            FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                            fragTransaction.detach(currentFragment);
                            fragTransaction.attach(currentFragment);
                            fragTransaction.commit();
                        }
                    }
                }
            });

            btnqzshow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(RadioButton r : rg1) {
                        if(r.getText().equals(rep1)) {
                            r.setChecked(true);
                            r.setTextColor(getResources().getColor(R.color.lightgreen));
                            break;
                        }
                    }

                    for(RadioButton r : rg2) {
                        if(r.getText().equals(rep2)) {
                            r.setChecked(true);
                            r.setTextColor(getResources().getColor(R.color.lightgreen));
                            break;
                        }
                    }

                    for(RadioButton r : rg3) {
                        if(r.getText().equals(rep3)) {
                            r.setChecked(true);
                            r.setTextColor(getResources().getColor(R.color.lightgreen));
                            break;
                        }
                    }

                    for(RadioButton r : rg4) {
                        if(r.getText().equals(rep4)) {
                            r.setChecked(true);
                            r.setTextColor(getResources().getColor(R.color.lightgreen));
                            break;
                        }
                    }

                    for(RadioButton r : rg5) {
                        if(r.getText().equals(rep5)) {
                            r.setChecked(true);
                            r.setTextColor(getResources().getColor(R.color.lightgreen));
                            break;
                        }
                    }
                }
            });

    }
}
