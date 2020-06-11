package com.projet.programmationenc;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuizStringsFragment extends Fragment {
    private EditText edt1q1strings,edt1q2strings,edt2q2strings,edt1q3strings,edt2q3strings,edt1q4strings,edt2q4strings,edt1q5strings,edt2q5strings;
    private Button btnqzstrings,btnqzstringsshow;
    private TextView txtvqzstrings;
    private int result = 0;
    private List<EditText> listedtstrings = new ArrayList<>();
    private boolean solutionshown = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizstrings,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1strings = view.findViewById(R.id.edt1q1strings);

        edt1q2strings = view.findViewById(R.id.edt1q2strings);
        edt2q2strings = view.findViewById(R.id.edt2q2strings);

        edt1q3strings = view.findViewById(R.id.edt1q3strings);
        edt2q3strings = view.findViewById(R.id.edt2q3strings);

        edt1q4strings = view.findViewById(R.id.edt1q4strings);
        edt2q4strings = view.findViewById(R.id.edt2q4strings);

        edt1q5strings = view.findViewById(R.id.edt1q5strings);
        edt2q5strings = view.findViewById(R.id.edt2q5strings);

        btnqzstrings = view.findViewById(R.id.btnqzstrings);
        btnqzstringsshow = view.findViewById(R.id.btnqzstringsshow);

        txtvqzstrings = view.findViewById(R.id.txtvqzstrings);

        listedtstrings.add(edt1q1strings);listedtstrings.add(edt1q2strings);listedtstrings.add(edt2q2strings);listedtstrings.add(edt1q3strings);listedtstrings.add(edt2q3strings);listedtstrings.add(edt1q4strings);listedtstrings.add(edt2q4strings);listedtstrings.add(edt1q5strings);listedtstrings.add(edt2q5strings);

        edt1q1strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt1q2strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt2q2strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 3;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt1q3strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt2q3strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt1q4strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt2q4strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt1q5strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q5strings.getText().length() != 4) {
                    edt2q5strings.requestFocus();
                }
            }
        });

        edt2q5strings.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 4;
                if(s.length() == l && edt1q1strings.getText().length() != 4) {
                    edt1q1strings.requestFocus();
                }
                else if(s.length() == l && edt1q2strings.getText().length() != 4) {
                    edt1q2strings.requestFocus();
                }
                else if(s.length() == l && edt2q2strings.getText().length() != 3) {
                    edt2q2strings.requestFocus();
                }
                else if(s.length() == l && edt1q3strings.getText().length() != 1) {
                    edt1q3strings.requestFocus();
                }
                else if(s.length() == l && edt2q3strings.getText().length() != 6) {
                    edt2q3strings.requestFocus();
                }
                else if(s.length() == l && edt1q4strings.getText().length() != 5) {
                    edt1q4strings.requestFocus();
                }
                else if(s.length() == l && edt2q4strings.getText().length() != 4) {
                    edt2q4strings.requestFocus();
                }
                else if(s.length() == l && edt1q5strings.getText().length() != 6) {
                    edt1q5strings.requestFocus();
                }
            }
        });

        btnqzstrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == 0 && btnqzstrings.getText().equals("Vérifier")) {
                    if (edt1q1strings.getText().toString().isEmpty() || edt1q2strings.getText().toString().isEmpty() || edt2q2strings.getText().toString().isEmpty() || edt1q3strings.getText().toString().isEmpty() || edt2q3strings.getText().toString().isEmpty() || edt1q4strings.getText().toString().isEmpty() || edt2q4strings.getText().toString().isEmpty() || edt1q5strings.getText().toString().isEmpty() || edt2q5strings.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Veuillez remplir tous les espaces", Toast.LENGTH_SHORT).show();
                    } else {
                        //Question1
                        if (edt1q1strings.getText().toString().equals("char")) {
                            edt1q1strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q1strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q1strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q1strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question2
                        if (edt1q2strings.getText().toString().equals("char")) {
                            edt1q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q2strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q2strings.getText().toString().equals("str")) {
                            edt2q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q2strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question3
                        if (edt1q3strings.getText().toString().equals("#")) {
                            edt1q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q3strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q3strings.getText().toString().equals("string")) {
                            edt2q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q3strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question4
                        if (edt1q4strings.getText().toString().equals("char*")) {
                            edt1q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q4strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q4strings.getText().toString().equals("x[3]")) {
                            edt2q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q4strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question5
                        if (edt1q5strings.getText().toString().equals("strcat")) {
                            edt1q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q5strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q5strings.getText().toString().equals("puts")) {
                            edt2q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q5strings.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        txtvqzstrings.setVisibility(View.VISIBLE);
                        txtvqzstrings.setText("Résultat : " + result + "/9");

                        if(result == 9) {
                            btnqzstrings.setText("Continuer");
                            btnqzstrings.setBackground(getResources().getDrawable(R.drawable.button));

                            txtvqzstrings.setTextColor(getResources().getColor(R.color.lightgreen));

                            for (EditText e : listedtstrings) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                        else {
                            btnqzstrings.setText("Réessayer");
                            btnqzstrings.setBackground(getResources().getDrawable(R.drawable.buttonred));
                            btnqzstringsshow.setVisibility(View.VISIBLE);

                            txtvqzstrings.setTextColor(getResources().getColor(R.color.red));

                            for(EditText e : listedtstrings) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                    }
                }
                else if(result == 9 || solutionshown) {
                    getActivity().onBackPressed();
                }
                else {
                    for(EditText e : listedtstrings) {
                        e.setText("");
                    }

                    result = 0;

                    Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                    if (currentFragment instanceof QuizStringsFragment) {
                        FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                        fragTransaction.detach(currentFragment);
                        fragTransaction.attach(currentFragment);
                        fragTransaction.commit();
                    }
                }
            }
        });

        btnqzstringsshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionshown = true;
                btnqzstrings.setText("Continuer");
                btnqzstrings.setBackground(getResources().getDrawable(R.drawable.button));
                txtvqzstrings.setVisibility(View.GONE);
                //Question1
                edt1q1strings.setText("char");
                edt1q1strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q1strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question2
                edt1q2strings.setText("char");
                edt1q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q2strings.setText("str");
                edt2q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q2strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question3
                edt1q3strings.setText("#");
                edt1q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q3strings.setText("string");
                edt2q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q3strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question4
                edt1q4strings.setText("char*");
                edt1q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q4strings.setText("x[3]");
                edt2q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q4strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question5
                edt1q5strings.setText("strcat");
                edt1q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q5strings.setText("puts");
                edt2q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q5strings.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

            }
        });
    }
}
