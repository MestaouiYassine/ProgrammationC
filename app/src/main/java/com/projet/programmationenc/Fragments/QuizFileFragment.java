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

public class QuizFileFragment extends Fragment {
    private EditText edt1q1file,edt1q2file,edt2q2file,edt1q3file,edt2q3file,edt1q4file,edt2q4file,edt1q5file;
    private Button btnqzfile,btnqzfileshow;
    private TextView txtvqzfile;
    private int result = 0;
    private List<EditText> listedtfile = new ArrayList<>();
    private boolean solutionshown = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizfile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Quiz");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        edt1q1file = view.findViewById(R.id.edt1q1file);

        edt1q2file = view.findViewById(R.id.edt1q2file);
        edt2q2file = view.findViewById(R.id.edt2q2file);

        edt1q3file = view.findViewById(R.id.edt1q3file);
        edt2q3file = view.findViewById(R.id.edt2q3file);

        edt1q4file = view.findViewById(R.id.edt1q4file);
        edt2q4file = view.findViewById(R.id.edt2q4file);

        edt1q5file = view.findViewById(R.id.edt1q5file);

        btnqzfile = view.findViewById(R.id.btnqzfile);
        btnqzfileshow = view.findViewById(R.id.btnqzfileshow);

        txtvqzfile = view.findViewById(R.id.txtvqzfile);

        listedtfile.add(edt1q1file);listedtfile.add(edt1q2file);listedtfile.add(edt2q2file);listedtfile.add(edt1q3file);listedtfile.add(edt2q3file);listedtfile.add(edt1q4file);listedtfile.add(edt2q4file);listedtfile.add(edt1q5file);

        edt1q1file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt1q2file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 5;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt2q2file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt1q3file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 7;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt2q3file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 1;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt1q4file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt2q4file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 7;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt1q5file.getText().length() != 6) {
                    edt1q5file.requestFocus();
                }
            }
        });

        edt1q5file.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int l = 6;
                if(s.length() == l && edt1q1file.getText().length() != 5) {
                    edt1q1file.requestFocus();
                }
                else if(s.length() == l && edt1q2file.getText().length() != 5) {
                    edt1q2file.requestFocus();
                }
                else if(s.length() == l && edt2q2file.getText().length() != 1) {
                    edt2q2file.requestFocus();
                }
                else if(s.length() == l && edt1q3file.getText().length() != 7) {
                    edt1q3file.requestFocus();
                }
                else if(s.length() == l && edt2q3file.getText().length() != 1) {
                    edt2q3file.requestFocus();
                }
                else if(s.length() == l && edt1q4file.getText().length() != 6) {
                    edt1q4file.requestFocus();
                }
                else if(s.length() == l && edt2q4file.getText().length() != 7) {
                    edt2q4file.requestFocus();
                }
            }
        });

        btnqzfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == 0 && btnqzfile.getText().equals("Vérifier")) {
                    if (edt1q1file.getText().toString().isEmpty() || edt1q2file.getText().toString().isEmpty() || edt2q2file.getText().toString().isEmpty() || edt1q3file.getText().toString().isEmpty() || edt2q3file.getText().toString().isEmpty() || edt1q4file.getText().toString().isEmpty() || edt2q4file.getText().toString().isEmpty() || edt1q5file.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Veuillez remplir tous les espaces", Toast.LENGTH_SHORT).show();
                    } else {
                        //Question1
                        if (edt1q1file.getText().toString().equals("fopen")) {
                            edt1q1file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q1file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q1file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q1file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question2
                        if (edt1q2file.getText().toString().equals("fopen")) {
                            edt1q2file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q2file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q2file.getText().toString().equals("w")) {
                            edt2q2file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q2file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question3
                        if (edt1q3file.getText().toString().equals("fprintf")) {
                            edt1q3file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q3file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q3file.getText().toString().equals("x")) {
                            edt2q3file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q3file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question4
                        if (edt1q4file.getText().toString().equals("fscanf")) {
                            edt1q4file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q4file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        if (edt2q4file.getText().toString().equals("&nombre")) {
                            edt2q4file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt2q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt2q4file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt2q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        //Question5
                        if (edt1q5file.getText().toString().equals("fclose")) {
                            edt1q5file.setTextColor(getResources().getColor(R.color.lightgreen));
                            DrawableCompat.setTint(edt1q5file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));
                            result++;
                        } else {
                            edt1q5file.setTextColor(getResources().getColor(R.color.red));
                            DrawableCompat.setTint(edt1q5file.getBackground(), ContextCompat.getColor(getContext(), R.color.red));
                        }

                        txtvqzfile.setVisibility(View.VISIBLE);
                        txtvqzfile.setText("Résultat : " + result + "/8");

                        if(result == 8) {
                            btnqzfile.setText("Continuer");
                            btnqzfile.setBackground(getResources().getDrawable(R.drawable.button));

                            txtvqzfile.setTextColor(getResources().getColor(R.color.lightgreen));

                            for (EditText e : listedtfile) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                        else {
                            btnqzfile.setText("Réessayer");
                            btnqzfile.setBackground(getResources().getDrawable(R.drawable.buttonred));
                            btnqzfileshow.setVisibility(View.VISIBLE);

                            txtvqzfile.setTextColor(getResources().getColor(R.color.red));

                            for(EditText e : listedtfile) {
                                e.setFocusable(false);
                                e.setEnabled(false);
                                e.setCursorVisible(false);
                                e.setKeyListener(null);
                                e.setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                    }
                }
                else if(result == 8 || solutionshown) {
                    getActivity().onBackPressed();
                }
                else {
                    for(EditText e : listedtfile) {
                        e.setText("");
                    }

                    result = 0;

                    Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                    if (currentFragment instanceof QuizFileFragment) {
                        FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                        fragTransaction.detach(currentFragment);
                        fragTransaction.attach(currentFragment);
                        fragTransaction.commit();
                    }
                }
            }
        });

        btnqzfileshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionshown = true;
                btnqzfile.setText("Continuer");
                btnqzfile.setBackground(getResources().getDrawable(R.drawable.button));
                txtvqzfile.setVisibility(View.GONE);
                //Question1
                edt1q1file.setText("fopen");
                edt1q1file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q1file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question2
                edt1q2file.setText("fopen");
                edt1q2file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q2file.setText("w");
                edt2q2file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q2file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question3
                edt1q3file.setText("fprintf");
                edt1q3file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q3file.setText("x");
                edt2q3file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q3file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question4
                edt1q4file.setText("fscanf");
                edt1q4file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                edt2q4file.setText("&nombre");
                edt2q4file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt2q4file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

                //Question5
                edt1q5file.setText("fclose");
                edt1q5file.setTextColor(getResources().getColor(R.color.lightgreen));
                DrawableCompat.setTint(edt1q5file.getBackground(), ContextCompat.getColor(getContext(), R.color.lightgreen));

            }
        });
    }
}
