package com.projet.programmationenc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizConditFragment extends Fragment {
    private EditText edt1q1condit,edt2q1condit,edt3q1condit,edt4q1condit,edt1q2condit,edt2q2condit,edt3q2condit,edt1q3condit,edt2q3condit,edt3q3condit,edt1q4condit,edt2q4condit,edt3q4condit,edt1q5condit,edt2q5condit,edt3q5condit;
    private Button btnqzcondit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizcondit,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1condit = view.findViewById(R.id.edt1q1condit);
        edt2q1condit = view.findViewById(R.id.edt2q1condit);
        edt3q1condit = view.findViewById(R.id.edt3q1condit);
        edt4q1condit = view.findViewById(R.id.edt4q1condit);

        edt1q2condit = view.findViewById(R.id.edt1q2condit);
        edt2q2condit = view.findViewById(R.id.edt2q2condit);
        edt3q2condit = view.findViewById(R.id.edt3q2condit);

        edt1q3condit = view.findViewById(R.id.edt1q3condit);
        edt2q3condit = view.findViewById(R.id.edt2q3condit);
        edt3q3condit = view.findViewById(R.id.edt3q3condit);

        edt1q4condit = view.findViewById(R.id.edt1q4condit);
        edt2q4condit = view.findViewById(R.id.edt2q4condit);
        edt3q4condit = view.findViewById(R.id.edt3q4condit);

        edt1q5condit = view.findViewById(R.id.edt1q5condit);
        edt2q5condit = view.findViewById(R.id.edt2q5condit);
        edt3q5condit = view.findViewById(R.id.edt3q5condit);

        btnqzcondit = view.findViewById(R.id.btnqzcondit);


        edt1q1condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt2q1condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 2;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt3q1condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 7;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt4q1condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt1q2condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt2q2condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt3q2condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt1q3condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt2q3condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt3q3condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt1q4condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 2;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt2q4condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt3q4condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt1q5condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt2q5condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt3q5condit.getText().length() != 3) {
                    edt3q5condit.requestFocus();
                }
            }
        });

        edt3q5condit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1condit.getText().length() != 4) {
                    edt1q1condit.requestFocus();
                }
                else if(s.length() == l && edt2q1condit.getText().length() != 2) {
                    edt2q1condit.requestFocus();
                }
                else if(s.length() == l && edt3q1condit.getText().length() != 7) {
                    edt3q1condit.requestFocus();
                }
                else if(s.length() == l && edt4q1condit.getText().length() != 3) {
                    edt4q1condit.requestFocus();
                }
                else if(s.length() == l && edt1q2condit.getText().length() != 6) {
                    edt1q2condit.requestFocus();
                }
                else if(s.length() == l && edt2q2condit.getText().length() != 4) {
                    edt2q2condit.requestFocus();
                }
                else if(s.length() == l && edt3q2condit.getText().length() != 6) {
                    edt3q2condit.requestFocus();
                }
                else if(s.length() == l && edt1q3condit.getText().length() != 5) {
                    edt1q3condit.requestFocus();
                }
                else if(s.length() == l && edt2q3condit.getText().length() != 3) {
                    edt2q3condit.requestFocus();
                }
                else if(s.length() == l && edt3q3condit.getText().length() != 1) {
                    edt3q3condit.requestFocus();
                }
                else if(s.length() == l && edt1q4condit.getText().length() != 2) {
                    edt1q4condit.requestFocus();
                }
                else if(s.length() == l && edt2q4condit.getText().length() != 1) {
                    edt2q4condit.requestFocus();
                }
                else if(s.length() == l && edt3q4condit.getText().length() != 1) {
                    edt3q4condit.requestFocus();
                }
                else if(s.length() == l && edt1q5condit.getText().length() != 3) {
                    edt1q5condit.requestFocus();
                }
                else if(s.length() == l && edt2q5condit.getText().length() != 1) {
                    edt2q5condit.requestFocus();
                }
            }
        });

        btnqzcondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1q1condit.getText().toString().isEmpty() || edt2q1condit.getText().toString().isEmpty() || edt3q1condit.getText().toString().isEmpty() || edt4q1condit.getText().toString().isEmpty() || edt1q2condit.getText().toString().isEmpty() || edt2q2condit.getText().toString().isEmpty() || edt3q2condit.getText().toString().isEmpty() || edt1q3condit.getText().toString().isEmpty() || edt2q3condit.getText().toString().isEmpty() || edt3q3condit.getText().toString().isEmpty() || edt1q4condit.getText().toString().isEmpty() || edt2q4condit.getText().toString().isEmpty() || edt3q4condit.getText().toString().isEmpty() || edt1q5condit.getText().toString().isEmpty() || edt2q5condit.getText().toString().isEmpty() || edt3q5condit.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(),"Veuillez remplir tous les espaces",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Question1
                    if(edt1q1condit.getText().toString().equals("&age")) {
                        edt1q1condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q1condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q1condit.getText().toString().equals("if")) {
                        edt2q1condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q1condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q1condit.getText().toString().equals("else if")) {
                        edt3q1condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q1condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt4q1condit.getText().toString().equals("age")) {
                        edt4q1condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt4q1condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question2
                    if(edt1q2condit.getText().toString().equals("switch")) {
                        edt1q2condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q2condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q2condit.getText().toString().equals("case")) {
                        edt2q2condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q2condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q2condit.getText().toString().equals("break;")) {
                        edt3q2condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q2condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question3
                    if(edt1q3condit.getText().toString().equals("while")) {
                        edt1q3condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q3condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q3condit.getText().toString().equals("i<3")) {
                        edt2q3condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q3condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q3condit.getText().toString().equals("i")) {
                        edt3q3condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q3condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question4
                    if(edt1q4condit.getText().toString().equals("do")) {
                        edt1q4condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q4condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q4condit.getText().toString().equals("c")) {
                        edt2q4condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q4condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q4condit.getText().toString().equals(";")) {
                        edt3q4condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q4condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question5
                    if(edt1q5condit.getText().toString().equals("for")) {
                        edt1q5condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q5condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q5condit.getText().toString().equals("<")) {
                        edt2q5condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q5condit.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt3q5condit.getText().toString().equals("i+1") || edt3q5condit.getText().toString().equals("i++") || edt3q5condit.getText().toString().equals("++i")) {
                        edt3q5condit.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt3q5condit.setTextColor(getResources().getColor(R.color.red));
                    }
                }
            }
        });
    }
}
