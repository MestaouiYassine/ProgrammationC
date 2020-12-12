package com.projet.programmationenc.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.projet.programmationenc.CallBack.ApiInterface;
import com.projet.programmationenc.ui.HomeActivity;
import com.projet.programmationenc.Moduls.Exercice;
import com.projet.programmationenc.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExFragment extends Fragment {
    private static final String TAG = "ExFragment";
    private TextView txtvcontentex,txtvsolutionex,txtvshowsolution;
    private Button btncontinueex;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ex,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Exercice");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        txtvcontentex = view.findViewById(R.id.txtvcontentex);
        txtvsolutionex = view.findViewById(R.id.txtvsolutionex);
        txtvshowsolution = view.findViewById(R.id.txtvshowsolution);

        btncontinueex = view.findViewById(R.id.btncontinueex);

        String exid;
        String extitle = getArguments().getString("extitle");
        switch (extitle) {
            case "Exercice 1 : Les bases du langage C":
                exid = "basec1";
                break;
            case "Exercice 2 : Les bases du langage C":
                exid = "basec2";
                break;
            case "Exercice 1 : Les structures conditionelles et les boucles":
                exid = "condit1";
                break;
            case "Exercice 2 : Les structures conditionelles et les boucles":
                exid = "condit2";
                break;
            case "Exercice 1 : Les fonctions, les tableaux et les pointeurs":
                exid = "functarray1";
                break;
            case "Exercice 2 : Les fonctions, les tableaux et les pointeurs":
                exid = "functarray2";
                break;
            case "Exercice 1 : Les chaînes de caractères":
                exid = "strings1";
                break;
            case "Exercice 2 : Les chaînes de caractères":
                exid = "strings2";
                break;
            case "Exercice 1 : Les structures et les énumérations":
                exid = "struct1";
                break;
            case "Exercice 2 : Les structures et les énumérations":
                exid = "struct2";
                break;
            case "Exercice 1 : Les fichiers":
                exid = "file1";
                break;
            default:
                exid = "file2";
                break;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.106/progc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Exercice> call = apiInterface.getExercice(exid);
        call.enqueue(new Callback<Exercice>() {
            @Override
            public void onResponse(Call<Exercice> call, Response<Exercice> response) {
                if(!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: Code : " + response.code());
                    Toast.makeText(getActivity(),"Code : " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                Exercice exercice = response.body();
                txtvcontentex.setText(exercice.getContentEx());
                txtvsolutionex.setText(exercice.getSolutionEx());
            }

            @Override
            public void onFailure(Call<Exercice> call, Throwable t) {
                Log.e(TAG, "onFailure: throwable msg : " + t.getMessage());
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        txtvshowsolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtvsolutionex.setVisibility(View.VISIBLE);
            }
        });

        btncontinueex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }
}
