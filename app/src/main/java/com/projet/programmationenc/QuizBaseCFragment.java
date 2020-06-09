package com.projet.programmationenc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizBaseCFragment extends Fragment {
    private EditText edt1q1basec,edt2q1basec,edt1q2basec,edt2q2basec,edt1q3basec,edt2q3basec,edt1q4basec,edt2q4basec,edt3q4basec,edt4q4basec,edt5q4basec,edt1q5basec,edt2q5basec;
    private Button btnqzbasec;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizbasec,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                if(edt1q1basec.getText().toString().isEmpty() || edt2q1basec.getText().toString().isEmpty() || edt1q2basec.getText().toString().isEmpty() || edt2q2basec.getText().toString().isEmpty() || edt1q3basec.getText().toString().isEmpty() || edt2q3basec.getText().toString().isEmpty() || edt1q4basec.getText().toString().isEmpty() || edt2q4basec.getText().toString().isEmpty() || edt3q4basec.getText().toString().isEmpty() || edt4q4basec.getText().toString().isEmpty() || edt5q4basec.getText().toString().isEmpty() || edt1q5basec.getText().toString().isEmpty() || edt2q5basec.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(),"Veuillez remplir tous les espaces",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Question1
                    if(edt1q1basec.getText().toString().equals("printf")) {
                        edt1q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q1basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q1basec.getText().toString().equals(";")) {
                        edt2q1basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q1basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question2
                    if(edt1q2basec.getText().toString().equals("s")) {
                        edt1q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q2basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q2basec.getText().toString().equals("+")) {
                        edt2q2basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q2basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question3
                    if(edt1q3basec.getText().toString().equals("#")) {
                        edt1q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q3basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q3basec.getText().toString().equals("v")) {
                        edt2q3basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q3basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question4
                    if(edt1q4basec.getText().toString().equals("main()")) {
                        edt1q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q4basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q4basec.getText().toString().equals("scanf")) {
                        edt2q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q4basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q4basec.getText().toString().equals("&a") || edt3q4basec.getText().toString().equals("&b")) {
                        edt3q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q4basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt4q4basec.getText().toString().equals("&a") || edt4q4basec.getText().toString().equals("&b")) {
                        edt4q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt4q4basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt5q4basec.getText().toString().equals("a*b") || edt5q4basec.getText().toString().equals("b*a")) {
                        edt5q4basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt5q4basec.setTextColor(getResources().getColor(R.color.red));
                    }

                //Question5
                    if(edt1q5basec.getText().toString().equals("const")) {
                        edt1q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q5basec.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q5basec.getText().toString().equals("#define")) {
                        edt2q5basec.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q5basec.setTextColor(getResources().getColor(R.color.red));
                    }

                }
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
