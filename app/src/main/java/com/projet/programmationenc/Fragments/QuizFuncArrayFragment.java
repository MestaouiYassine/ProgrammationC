package com.projet.programmationenc.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.projet.programmationenc.ui.HomeActivity;
import com.projet.programmationenc.R;

import java.util.ArrayList;
import java.util.List;

public class QuizFuncArrayFragment extends Fragment {
    private EditText edt1q1funcarray,edt2q1funcarray,edt1q2funcarray,edt2q2funcarray,edt1q3funcarray,edt2q3functarray,edt1q4funcarray,edt2q4funcarray,edt3q4funcarray,edt1q5funcarray,edt2q5funcarray,edt1q6funcarray;
    private Button btnqzfuncarray,btnqzfuncarrayshow;
    private TextView txtvqzfuncarray;
    private int result = 0;
    private List<EditText> listedtfuncarray = new ArrayList<>();
    private boolean solutionshown = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizfunctarray,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Quiz");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1funcarray = view.findViewById(R.id.edt1q1funcarray);
        edt2q1funcarray = view.findViewById(R.id.edt2q1funcarray);

        edt1q2funcarray = view.findViewById(R.id.edt1q2funcarray);
        edt2q2funcarray = view.findViewById(R.id.edt2q2funcarray);

        edt1q3funcarray = view.findViewById(R.id.edt1q3funcarray);
        edt2q3functarray = view.findViewById(R.id.edt2q3functarray);

        edt1q4funcarray = view.findViewById(R.id.edt1q4funcarray);
        edt2q4funcarray = view.findViewById(R.id.edt2q4funcarray);
        edt3q4funcarray = view.findViewById(R.id.edt3q4funcarray);

        edt1q5funcarray = view.findViewById(R.id.edt1q5funcarray);
        edt2q5funcarray = view.findViewById(R.id.edt2q5funcarray);

        edt1q6funcarray = view.findViewById(R.id.edt1q6funcarray);

        btnqzfuncarray = view.findViewById(R.id.btnqzfuncarray);
        btnqzfuncarrayshow = view.findViewById(R.id.btnqzfuncarrayshow);

        txtvqzfuncarray = view.findViewById(R.id.txtvqzfuncarray);

        listedtfuncarray.add(edt1q1funcarray);listedtfuncarray.add(edt2q1funcarray);listedtfuncarray.add(edt1q2funcarray);listedtfuncarray.add(edt2q2funcarray);listedtfuncarray.add(edt1q3funcarray);listedtfuncarray.add(edt2q3functarray);listedtfuncarray.add(edt1q4funcarray);listedtfuncarray.add(edt2q4funcarray);listedtfuncarray.add(edt3q4funcarray);listedtfuncarray.add(edt1q5funcarray);listedtfuncarray.add(edt2q5funcarray);listedtfuncarray.add(edt1q6funcarray);

        edt1q1funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt2q1funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt1q2funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 7;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt2q2funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt1q3funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt2q3functarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt1q4funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt2q4funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt3q4funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt1q5funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt2q5funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q6funcarray.getText().length() != 1) {
                    edt1q6funcarray.requestFocus();
                }
            }
        });

        edt1q6funcarray.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1funcarray.getText().length() != 5) {
                    edt1q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q1funcarray.getText().length() != 3) {
                    edt2q1funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q2funcarray.getText().length() != 7) {
                    edt1q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q2funcarray.getText().length() != 5) {
                    edt2q2funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q3funcarray.getText().length() != 3) {
                    edt1q3funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q3functarray.getText().length() != 3) {
                    edt2q3functarray.requestFocus();
                }
                else if(s.length() == l && edt1q4funcarray.getText().length() != 1) {
                    edt1q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q4funcarray.getText().length() != 1) {
                    edt2q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt3q4funcarray.getText().length() != 1) {
                    edt3q4funcarray.requestFocus();
                }
                else if(s.length() == l && edt1q5funcarray.getText().length() != 4) {
                    edt1q5funcarray.requestFocus();
                }
                else if(s.length() == l && edt2q5funcarray.getText().length() != 1) {
                    edt2q5funcarray.requestFocus();
                }
            }
        });

        btnqzfuncarray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == 0 && btnqzfuncarray.getText().equals("Vérifier")) {
                    if (edt1q1funcarray.getText().toString().isEmpty() || edt2q1funcarray.getText().toString().isEmpty() || edt1q2funcarray.getText().toString().isEmpty() || edt2q2funcarray.getText().toString().isEmpty() || edt1q3funcarray.getText().toString().isEmpty() || edt2q3functarray.getText().toString().isEmpty() || edt1q4funcarray.getText().toString().isEmpty() || edt2q4funcarray.getText().toString().isEmpty() || edt3q4funcarray.getText().toString().isEmpty() || edt1q5funcarray.getText().toString().isEmpty() || edt2q5funcarray.getText().toString().isEmpty() || edt1q6funcarray.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Veuillez remplir tous les espaces", Toast.LENGTH_SHORT).show();
                    } else {
                        //Question1
                        if (edt1q1funcarray.getText().toString().equals("float")) {
                            edt1q1funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q1funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q1funcarray.getText().toString().equals("int")) {
                            edt2q1funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q1funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question2
                        if (edt1q2funcarray.getText().toString().equals("return;")) {
                            edt1q2funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q2funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q2funcarray.getText().toString().equals("print")) {
                            edt2q2funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q2funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question3
                        if (edt1q3funcarray.getText().toString().equals("for")) {
                            edt1q3funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q3funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q3funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q3funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q3functarray.getText().toString().equals("tab")) {
                            edt2q3functarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q3functarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q3functarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q3functarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question4
                        if (edt1q4funcarray.getText().toString().equals("*")) {
                            edt1q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q4funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q4funcarray.getText().toString().equals("&")) {
                            edt2q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q4funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt3q4funcarray.getText().toString().equals("*")) {
                            edt3q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt3q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt3q4funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt3q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question5
                        if (edt1q5funcarray.getText().toString().equals("int*")) {
                            edt1q5funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q5funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q5funcarray.getText().toString().equals("*")) {
                            edt2q5funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q5funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question6
                        if (edt1q6funcarray.getText().toString().equals("1")) {
                            edt1q6funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q6funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q6funcarray.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q6funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        txtvqzfuncarray.setVisibility(View.VISIBLE);
                        txtvqzfuncarray.setText("Résultat : " + result + "/12");

                        if(result == 12) {
                            btnqzfuncarray.setText("Continuer");
                            btnqzfuncarray.setBackground(getResources().getDrawable(R.drawable.button));

                            txtvqzfuncarray.setTextColor(getResources().getColor(R.color.lightgreen));

                            for (EditText e : listedtfuncarray) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                        else {
                            btnqzfuncarray.setText("Réessayer");
                            btnqzfuncarray.setBackground(getResources().getDrawable(R.drawable.buttonred));
                            btnqzfuncarrayshow.setVisibility(View.VISIBLE);

                            txtvqzfuncarray.setTextColor(getResources().getColor(R.color.red));

                            for(EditText e : listedtfuncarray) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                    }
                }
                else if(result == 12 || solutionshown) {
                    getActivity().onBackPressed();
                }
                else {
//                    edt1q1condit.setText("");edt2q1condit.setText("");edt3q1condit.setText("");edt4q1condit.setText("");edt1q2condit.setText("");edt2q2condit.setText("");edt3q2condit.setText("");edt1q3condit.setText("");edt2q3condit.setText("");edt3q3condit.setText("");edt1q4condit.setText("");edt2q4condit.setText("");edt3q4condit.setText("");edt1q5condit.setText("");edt2q5condit.setText("");edt3q5condit.setText("");
                    for(EditText e : listedtfuncarray) {
                        e.setText("");
                    }

                    result = 0;

                    Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                    if (currentFragment instanceof QuizFuncArrayFragment) {
                        FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                        fragTransaction.detach(currentFragment);
                        fragTransaction.attach(currentFragment);
                        fragTransaction.commit();
                    }
                }
            }
        });

        btnqzfuncarrayshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionshown = true;
                btnqzfuncarray.setText("Continuer");
                btnqzfuncarray.setBackground(getResources().getDrawable(R.drawable.button));
                txtvqzfuncarray.setVisibility(View.GONE);
                //Question1
                edt1q1funcarray.setText("float");
                edt1q1funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q1funcarray.setText("int");
                edt2q1funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q1funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question2
                edt1q2funcarray.setText("return;");
                edt1q2funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q2funcarray.setText("print");
                edt2q2funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q2funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question3
                edt1q3funcarray.setText("for");
                edt1q3funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q3funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q3functarray.setText("tab");
                edt2q3functarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q3functarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question4
                edt1q4funcarray.setText("*");
                edt1q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q4funcarray.setText("&");
                edt2q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt3q4funcarray.setText("*");
                edt3q4funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt3q4funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));


                //Question5
                edt1q5funcarray.setText("int*");
                edt1q5funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q5funcarray.setText("*");
                edt2q5funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q5funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question6
                edt1q6funcarray.setText("1");
                edt1q6funcarray.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q6funcarray.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
            }
        });
    }
}
