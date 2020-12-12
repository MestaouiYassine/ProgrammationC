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

public class QuizStructFragment extends Fragment {
    private EditText edt1q1struct,edt1q2struct,edt2q2struct,edt1q3struct,edt2q3struct,edt1q4struct,edt2q4struct,edt1q5struct,edt2q5struct,edt3q5struct;
    private Button btnqzstruct,btnqzstructshow;
    private TextView txtvqzstruct;
    private int result = 0;
    private List<EditText> listedtstruct = new ArrayList<>();
    private boolean solutionshown = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizstruct,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Quiz");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1struct = view.findViewById(R.id.edt1q1struct);

        edt1q2struct = view.findViewById(R.id.edt1q2struct);
        edt2q2struct = view.findViewById(R.id.edt2q2struct);

        edt1q3struct = view.findViewById(R.id.edt1q3struct);
        edt2q3struct = view.findViewById(R.id.edt2q3struct);

        edt1q4struct = view.findViewById(R.id.edt1q4struct);
        edt2q4struct = view.findViewById(R.id.edt2q4struct);

        edt1q5struct = view.findViewById(R.id.edt1q5struct);
        edt2q5struct = view.findViewById(R.id.edt2q5struct);
        edt3q5struct = view.findViewById(R.id.edt3q5struct);

        btnqzstruct = view.findViewById(R.id.btnqzstruct);
        btnqzstructshow = view.findViewById(R.id.btnqzstructshow);

        txtvqzstruct = view.findViewById(R.id.txtvqzstruct);

        listedtstruct.add(edt1q1struct);listedtstruct.add(edt1q2struct);listedtstruct.add(edt2q2struct);listedtstruct.add(edt1q3struct);listedtstruct.add(edt2q3struct);listedtstruct.add(edt1q4struct);listedtstruct.add(edt2q4struct);listedtstruct.add(edt1q5struct);listedtstruct.add(edt2q5struct);listedtstruct.add(edt3q5struct);

        edt1q1struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt1q2struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt2q2struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt1q3struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt2q3struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt1q4struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt2q4struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt1q5struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt2q5struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt3q5struct.getText().length() != 1) {
                    edt3q5struct.requestFocus();
                }
            }
        });

        edt3q5struct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1struct.getText().length() != 4) {
                    edt1q1struct.requestFocus();
                }
                else if(s.length() == l && edt1q2struct.getText().length() != 4) {
                    edt1q2struct.requestFocus();
                }
                else if(s.length() == l && edt2q2struct.getText().length() != 1) {
                    edt2q2struct.requestFocus();
                }
                else if(s.length() == l && edt1q3struct.getText().length() != 6) {
                    edt1q3struct.requestFocus();
                }
                else if(s.length() == l && edt2q3struct.getText().length() != 1) {
                    edt2q3struct.requestFocus();
                }
                else if(s.length() == l && edt1q4struct.getText().length() != 6) {
                    edt1q4struct.requestFocus();
                }
                else if(s.length() == l && edt2q4struct.getText().length() != 1) {
                    edt2q4struct.requestFocus();
                }
                else if(s.length() == l && edt1q5struct.getText().length() != 6) {
                    edt1q5struct.requestFocus();
                }
                else if(s.length() == l && edt2q5struct.getText().length() != 3) {
                    edt2q5struct.requestFocus();
                }
            }
        });

        btnqzstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == 0 && btnqzstruct.getText().equals("Vérifier")) {
                    if (edt1q1struct.getText().toString().isEmpty() || edt1q2struct.getText().toString().isEmpty() || edt2q2struct.getText().toString().isEmpty() || edt1q3struct.getText().toString().isEmpty() || edt2q3struct.getText().toString().isEmpty() || edt1q4struct.getText().toString().isEmpty() || edt2q4struct.getText().toString().isEmpty() || edt1q5struct.getText().toString().isEmpty() || edt2q5struct.getText().toString().isEmpty() || edt3q5struct.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Veuillez remplir tous les espaces", Toast.LENGTH_SHORT).show();
                    } else {
                        //Question1
                        if (edt1q1struct.getText().toString().equals("enum")) {
                            edt1q1struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q1struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q1struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q1struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question2
                        if (edt1q2struct.getText().toString().equals("enum")) {
                            edt1q2struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q2struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q2struct.getText().toString().equals(";")) {
                            edt2q2struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q2struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question3
                        if (edt1q3struct.getText().toString().equals("struct")) {
                            edt1q3struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q3struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q3struct.getText().toString().equals(";")) {
                            edt2q3struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q3struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question4
                        if (edt1q4struct.getText().toString().equals("struct")) {
                            edt1q4struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q4struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q4struct.getText().toString().equals(";")) {
                            edt2q4struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q4struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question5
                        if (edt1q5struct.getText().toString().equals("struct")) {
                            edt1q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q5struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q5struct.getText().toString().equals("for")) {
                            edt2q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q5struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt3q5struct.getText().toString().equals(".")) {
                            edt3q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt3q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt3q5struct.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt3q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        txtvqzstruct.setVisibility(View.VISIBLE);
                        txtvqzstruct.setText("Résultat : " + result + "/10");

                        if(result == 10) {
                            btnqzstruct.setText("Continuer");
                            btnqzstruct.setBackground(getResources().getDrawable(R.drawable.button));

                            txtvqzstruct.setTextColor(getResources().getColor(R.color.lightgreen));

                            for (EditText e : listedtstruct) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                        else {
                            btnqzstruct.setText("Réessayer");
                            btnqzstruct.setBackground(getResources().getDrawable(R.drawable.buttonred));
                            btnqzstructshow.setVisibility(View.VISIBLE);

                            txtvqzstruct.setTextColor(getResources().getColor(R.color.red));

                            for(EditText e : listedtstruct) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }

                    }
                }
                else if(result == 10 || solutionshown) {
                    getActivity().onBackPressed();
                }
                else {
                    for(EditText e : listedtstruct) {
                        e.setText("");
                    }

                    result = 0;

                    Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                    if (currentFragment instanceof QuizStructFragment) {
                        FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                        fragTransaction.detach(currentFragment);
                        fragTransaction.attach(currentFragment);
                        fragTransaction.commit();
                    }
                }
            }
        });

        btnqzstructshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionshown = true;
                btnqzstruct.setText("Continuer");
                btnqzstruct.setBackground(getResources().getDrawable(R.drawable.button));
                txtvqzstruct.setVisibility(View.GONE);
                //Question1
                edt1q1struct.setText("enum");
                edt1q1struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q1struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question2
                edt1q2struct.setText("enum");
                edt1q2struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q2struct.setText(";");
                edt2q2struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q2struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question3
                edt1q3struct.setText("struct");
                edt1q3struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q3struct.setText(";");
                edt2q3struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q3struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question4
                edt1q4struct.setText("struct");
                edt1q4struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q4struct.setText(";");
                edt2q4struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q4struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question5
                edt1q5struct.setText("struct");
                edt1q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q5struct.setText("for");
                edt2q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt3q5struct.setText(".");
                edt3q5struct.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt3q5struct.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

            }
        });
    }
}
