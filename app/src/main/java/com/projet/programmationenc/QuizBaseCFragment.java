package com.projet.programmationenc;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class QuizBaseCFragment extends Fragment {
    private EditText edt1q1basec,edt2q1basec,edt1q2basec,edt2q2basec,edt1q3basec,edt2q3basec,edt1q4basec,edt2q4basec,edt3q4basec,edt4q4basec,edt5q4basec,edt1q5basec,edt2q5basec;
    private Button btnqzbasec,btnqzbasecshow;
    private TextView txtvqzbasecresult;
    private int result = 0;
    private List<EditText> listedtbasec = new ArrayList<>();
    private boolean solutionshown = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizbasec,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Quiz");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1basec = view.findViewById(R.id.edt1q1basec);
        edt2q1basec = view.findViewById(R.id.edt2q1basec);

        edt1q2basec = view.findViewById(R.id.edt1q2basec);
        edt2q2basec = view.findViewById(R.id.edt2q2basec);

        edt1q3basec = view.findViewById(R.id.edt1q3basec);
        edt2q3basec = view.findViewById(R.id.edt2q3basec);

        edt1q4basec = view.findViewById(R.id.edt1q4basec);
        edt2q4basec = view.findViewById(R.id.edt2q4basec);
        edt3q4basec = view.findViewById(R.id.edt3q4basec);
        edt4q4basec = view.findViewById(R.id.edt4q4basec);
        edt5q4basec = view.findViewById(R.id.edt5q4basec);

        edt1q5basec = view.findViewById(R.id.edt1q5basec);
        edt2q5basec = view.findViewById(R.id.edt2q5basec);

        btnqzbasec = view.findViewById(R.id.btnqzbasec);
        btnqzbasecshow = view.findViewById(R.id.btnqzbasecshow);

        txtvqzbasecresult = view.findViewById(R.id.txtvqzbasecresult);

        listedtbasec.add(edt1q1basec);listedtbasec.add(edt2q1basec);listedtbasec.add(edt1q2basec);listedtbasec.add(edt2q2basec);listedtbasec.add(edt1q3basec);listedtbasec.add(edt2q3basec);listedtbasec.add(edt1q4basec);listedtbasec.add(edt2q4basec);listedtbasec.add(edt3q4basec);listedtbasec.add(edt4q4basec);listedtbasec.add(edt5q4basec);listedtbasec.add(edt1q5basec);listedtbasec.add(edt2q5basec);

        edt1q1basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt2q1basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt1q2basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt2q2basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt1q3basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt2q3basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt1q4basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt2q4basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt1q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt3q4basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 2;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt4q4basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 2;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt5q4basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt1q5basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length()== l && edt2q5basec.getText().length() != 7) {
                    edt2q5basec.requestFocus();
                }
            }
        });

        edt2q5basec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 7;
                if(s.length() == l && edt1q1basec.getText().length() != 6) {
                    edt1q1basec.requestFocus();
                }
                else if(s.length() == l && edt2q1basec.getText().length() != 1) {
                    edt2q1basec.requestFocus();
                }
                else if(s.length() == l && edt1q2basec.getText().length() != 1) {
                    edt1q2basec.requestFocus();
                }
                else if(s.length() == l && edt2q2basec.getText().length() != 1) {
                    edt2q2basec.requestFocus();
                }
                else if(s.length() == l && edt1q3basec.getText().length() != 1) {
                    edt1q3basec.requestFocus();
                }
                else if(s.length() == l && edt2q3basec.getText().length() != 1) {
                    edt2q3basec.requestFocus();
                }
                else if(s.length() == l && edt1q4basec.getText().length() != 6) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt2q4basec.getText().length() != 5) {
                    edt2q4basec.requestFocus();
                }
                else if(s.length() == l && edt3q4basec.getText().length() != 2) {
                    edt3q4basec.requestFocus();
                }
                else if(s.length() == l && edt4q4basec.getText().length() != 2) {
                    edt4q4basec.requestFocus();
                }
                else if(s.length() == l && edt5q4basec.getText().length() != 3) {
                    edt5q4basec.requestFocus();
                }
                else if(s.length()== l && edt1q5basec.getText().length() != 5) {
                    edt1q5basec.requestFocus();
                }
            }
        });

        btnqzbasec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == 0 && btnqzbasec.getText().equals("Vérifier")) {
                    if(edt1q1basec.getText().toString().isEmpty() || edt2q1basec.getText().toString().isEmpty() || edt1q2basec.getText().toString().isEmpty() || edt2q2basec.getText().toString().isEmpty() || edt1q3basec.getText().toString().isEmpty() || edt2q3basec.getText().toString().isEmpty() || edt1q4basec.getText().toString().isEmpty() || edt2q4basec.getText().toString().isEmpty() || edt3q4basec.getText().toString().isEmpty() || edt4q4basec.getText().toString().isEmpty() || edt5q4basec.getText().toString().isEmpty() || edt1q5basec.getText().toString().isEmpty() || edt2q5basec.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(),"Veuillez remplir tous les espaces",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //Question1
                        if(edt1q1basec.getText().toString().equals("printf")) {
                            edt1q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt1q1basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt2q1basec.getText().toString().equals(";")) {
                            edt2q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt2q1basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question2
                        if(edt1q2basec.getText().toString().equals("s")) {
                            edt1q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt1q2basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt2q2basec.getText().toString().equals("+")) {
                            edt2q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt2q2basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question3
                        if(edt1q3basec.getText().toString().equals("#")) {
                            edt1q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt1q3basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt2q3basec.getText().toString().equals("v")) {
                            edt2q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt2q3basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question4
                        if(edt1q4basec.getText().toString().equals("main()")) {
                            edt1q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt1q4basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt2q4basec.getText().toString().equals("scanf")) {
                            edt2q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt2q4basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt3q4basec.getText().toString().equals("&a") || edt3q4basec.getText().toString().equals("&b")) {
                            edt3q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt3q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt3q4basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt3q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt4q4basec.getText().toString().equals("&a") || edt4q4basec.getText().toString().equals("&b")) {
                            edt4q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt4q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt4q4basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt4q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt5q4basec.getText().toString().equals("a*b") || edt5q4basec.getText().toString().equals("b*a")) {
                            edt5q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt5q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt5q4basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt5q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                    //Question5
                        if(edt1q5basec.getText().toString().equals("const")) {
                            edt1q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt1q5basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if(edt2q5basec.getText().toString().equals("#define")) {
                            edt2q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        }
                        else {
                            edt2q5basec.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        txtvqzbasecresult.setVisibility(View.VISIBLE);
                        txtvqzbasecresult.setText("Résultat : " + result + "/13");

                        if(result == 13) {
                            btnqzbasec.setText("Continuer");
                            btnqzbasec.setBackground(getResources().getDrawable(R.drawable.button));

                            txtvqzbasecresult.setTextColor(getResources().getColor(R.color.lightgreen));

                            for(EditText e : listedtbasec) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                        else {
                            btnqzbasec.setText("Réessayer");
                            btnqzbasec.setBackground(getResources().getDrawable(R.drawable.buttonred));
                            btnqzbasecshow.setVisibility(View.VISIBLE);

                            txtvqzbasecresult.setTextColor(getResources().getColor(R.color.red));

                            for(EditText e : listedtbasec) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }

                    }
                }
                else if(result == 13 || solutionshown) {
                    getActivity().onBackPressed();
                }
                else {
//                    edt1q1basec.setText("");edt2q1basec.setText("");edt1q2basec.setText("");edt2q2basec.setText("");edt1q3basec.setText("");edt2q3basec.setText("");edt1q4basec.setText("");edt2q4basec.setText("");edt3q4basec.setText("");edt4q4basec.setText("");edt5q4basec.setText("");edt1q5basec.setText("");edt2q5basec.setText("");
                    for(EditText e : listedtbasec) {
                        e.setText("");
                    }
                    result = 0;

                    Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                    if (currentFragment instanceof QuizBaseCFragment) {
                        FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                        fragTransaction.detach(currentFragment);
                        fragTransaction.attach(currentFragment);
                        fragTransaction.commit();
                    }
                }
            }
        });

        btnqzbasecshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionshown = true;
                btnqzbasec.setText("Continuer");
                btnqzbasec.setBackground(getResources().getDrawable(R.drawable.button));
                txtvqzbasecresult.setVisibility(View.GONE);
                //Question1
                edt1q1basec.setText("printf");
                edt1q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q1basec.setText(";");
                edt2q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q1basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question2
                edt1q2basec.setText("s");
                edt1q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q2basec.setText("+");
                edt2q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q2basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question3
                edt1q3basec.setText("#");
                edt1q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q3basec.setText("v");
                edt2q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q3basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question4
                edt1q4basec.setText("main()");
                edt1q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q4basec.setText("scanf");
                edt2q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt3q4basec.setText("&a");
                edt3q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt3q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt4q4basec.setText("&b");
                edt4q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt4q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt5q4basec.setText("a*b");
                edt5q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt5q4basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question5
                edt1q5basec.setText("const");
                edt1q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q5basec.setText("#define");
                edt2q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q5basec.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
            }
        });

    }
}

//                if(edt1q1basec.getText().toString().length() == 6) {
//                    if(edt2q1basec.getText().toString().length() == 1) {
//                        if(edt1q2basec.getText().toString().length() == 1) {
//                            if(edt2q2basec.getText().toString().length() == 1) {
//                                if(edt1q3basec.getText().toString().length() == 1) {
//                                    if(edt2q3basec.getText().toString().length() == 1) {
//                                        if(edt1q4basec.getText().toString().length() == 6) {
//                                            if(edt2q4basec.getText().toString().length() == 5) {
//                                                if(edt3q4basec.getText().toString().length() == 2) {
//                                                    if(edt4q4basec.getText().toString().length() == 2) {
//                                                        if(edt5q4basec.getText().toString().length() == 3) {
//                                                            if(edt1q5basec.getText().toString().length() == 5) {
//                                                                if(edt2q5basec.getText().toString().length() == 7) {
//
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
