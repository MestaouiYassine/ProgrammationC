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

public class QuizStringsFragment extends Fragment {
    private EditText edt1q1strings,edt1q2strings,edt2q2strings,edt1q3strings,edt2q3strings,edt1q4strings,edt2q4strings,edt1q5strings,edt2q5strings;
    private Button btnqzstrings;
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
                if(edt1q1strings.getText().toString().isEmpty() || edt1q2strings.getText().toString().isEmpty() || edt2q2strings.getText().toString().isEmpty() || edt1q3strings.getText().toString().isEmpty() || edt2q3strings.getText().toString().isEmpty() || edt1q4strings.getText().toString().isEmpty() || edt2q4strings.getText().toString().isEmpty() || edt1q5strings.getText().toString().isEmpty() || edt2q5strings.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(),"Veuillez remplir tous les espaces",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Question1
                    if(edt1q1strings.getText().toString().equals("char")) {
                        edt1q1strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q1strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question2
                    if(edt1q2strings.getText().toString().equals("char")) {
                        edt1q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q2strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q2strings.getText().toString().equals("str")) {
                        edt2q2strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q2strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question3
                    if(edt1q3strings.getText().toString().equals("#")) {
                        edt1q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q3strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q3strings.getText().toString().equals("string")) {
                        edt2q3strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q3strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question4
                    if(edt1q4strings.getText().toString().equals("char*")) {
                        edt1q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q4strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q4strings.getText().toString().equals("x[3]")) {
                        edt2q4strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q4strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    //Question5
                    if(edt1q5strings.getText().toString().equals("strcat")) {
                        edt1q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt1q5strings.setTextColor(getResources().getColor(R.color.red));
                    }

                    if(edt2q5strings.getText().toString().equals("puts")) {
                        edt2q5strings.setTextColor(getResources().getColor(R.color.lightgreen));
                    }
                    else {
                        edt2q5strings.setTextColor(getResources().getColor(R.color.red));
                    }
                }
            }
        });
    }
}
