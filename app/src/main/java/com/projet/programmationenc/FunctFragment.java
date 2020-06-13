package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FunctFragment extends Fragment {
    private static final String TAG = "FunctFragment";
    private RelativeLayout btnfonction1,btnfonction2,btntab1dim,btntabndim,btnpointers1,btnpointers2;
    private TextView txtvfonction1,txtvfonction2,txtvtab1dim,txtvtabndim,txtvpointers1,txtvpointers2;
    private String id;
    private FirebaseUser user;
    public static List<String> completedFuncArrPoint;
    private DatabaseReference databaseReference;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_funct,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if(((HomeActivity) getActivity()).retrievedCompletedFuncArrPoint.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedFuncArrPoint is empty");
        }
        else {
            completedFuncArrPoint = ((HomeActivity) getActivity()).retrievedCompletedFuncArrPoint;
        }

        btnfonction1 = view.findViewById(R.id.btnfonction1);
        btnfonction2 = view.findViewById(R.id.btnfonction2);
        btntab1dim = view.findViewById(R.id.btntab1dim);
        btntabndim = view.findViewById(R.id.btntabndim);
        btnpointers1 = view.findViewById(R.id.btnpointers1);
        btnpointers2 = view.findViewById(R.id.btnpointers2);

        txtvfonction1 = view.findViewById(R.id.txtvfonction1);
        txtvfonction2 = view.findViewById(R.id.txtvfonction2);
        txtvtab1dim = view.findViewById(R.id.txtvtab1dim);
        txtvtabndim = view.findViewById(R.id.txtvtabndim);
        txtvpointers1 = view.findViewById(R.id.txtvpointers1);
        txtvpointers2 = view.findViewById(R.id.txtvpointers2);


        if(completedFuncArrPoint.contains("fonction1")) {
            txtvfonction1.setText("Complet");
            txtvfonction1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFuncArrPoint.contains("fonction2")) {
            txtvfonction2.setText("Complet");
            txtvfonction2.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFuncArrPoint.contains("tab1dim")) {
            txtvtab1dim.setText("Complet");
            txtvtab1dim.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFuncArrPoint.contains("tabndim")) {
            txtvtabndim.setText("Complet");
            txtvtabndim.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFuncArrPoint.contains("pointers1")) {
            txtvpointers1.setText("Complet");
            txtvpointers1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFuncArrPoint.contains("pointers2")) {
            txtvpointers2.setText("Complet");
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnfonction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("fonction1")) {
                    completedFuncArrPoint.add("fonction1");
                    updateFuncArrPointCourse();
                }
                id = "fonction1";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnfonction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("fonction2")) {
                    completedFuncArrPoint.add("fonction2");
                    updateFuncArrPointCourse();
                }
                id = "fonction2";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntab1dim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("tab1dim")) {
                    completedFuncArrPoint.add("tab1dim");
                    updateFuncArrPointCourse();
                }
                id = "tab1dim";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntabndim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("tabndim")) {
                    completedFuncArrPoint.add("tabndim");
                    updateFuncArrPointCourse();
                }
                id = "tabndim";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnpointers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("pointers1")) {
                    completedFuncArrPoint.add("pointers1");
                    updateFuncArrPointCourse();
                }
                id = "pointers1";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnpointers2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFuncArrPoint.contains("pointers2")) {
                    completedFuncArrPoint.add("pointers2");
                    updateFuncArrPointCourse();
                }
                id = "pointers2";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        if(completedFuncArrPoint.isEmpty()) {


            btnfonction2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfonction2.setClickable(false);
            txtvfonction2.setTextColor(getResources().getColor(R.color.black));
            txtvfonction2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfonction2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntab1dim.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntab1dim.setClickable(false);
            txtvtab1dim.setTextColor(getResources().getColor(R.color.black));
            txtvtab1dim.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtab1dim.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntabndim.setClickable(false);
            txtvtabndim.setTextColor(getResources().getColor(R.color.black));
            txtvtabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtabndim.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers1.setClickable(false);
            txtvpointers1.setTextColor(getResources().getColor(R.color.black));
            txtvpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers2.setClickable(false);
            txtvpointers2.setTextColor(getResources().getColor(R.color.black));
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedFuncArrPoint.size() == 1 && completedFuncArrPoint.contains("fonction1")) {

            btntab1dim.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntab1dim.setClickable(false);
            txtvtab1dim.setTextColor(getResources().getColor(R.color.black));
            txtvtab1dim.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtab1dim.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntabndim.setClickable(false);
            txtvtabndim.setTextColor(getResources().getColor(R.color.black));
            txtvtabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtabndim.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers1.setClickable(false);
            txtvpointers1.setTextColor(getResources().getColor(R.color.black));
            txtvpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers2.setClickable(false);
            txtvpointers2.setTextColor(getResources().getColor(R.color.black));
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedFuncArrPoint.size() == 2 && completedFuncArrPoint.contains("fonction2")) {

            btntabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntabndim.setClickable(false);
            txtvtabndim.setTextColor(getResources().getColor(R.color.black));
            txtvtabndim.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtabndim.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers1.setClickable(false);
            txtvpointers1.setTextColor(getResources().getColor(R.color.black));
            txtvpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers2.setClickable(false);
            txtvpointers2.setTextColor(getResources().getColor(R.color.black));
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedFuncArrPoint.size() == 3 && completedFuncArrPoint.contains("tab1dim")) {

            btnpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers1.setClickable(false);
            txtvpointers1.setTextColor(getResources().getColor(R.color.black));
            txtvpointers1.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers2.setClickable(false);
            txtvpointers2.setTextColor(getResources().getColor(R.color.black));
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedFuncArrPoint.size() == 4 && completedFuncArrPoint.contains("tabndim")) {

            btnpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnpointers2.setClickable(false);
            txtvpointers2.setTextColor(getResources().getColor(R.color.black));
            txtvpointers2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvpointers2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
    }

    private void updateFuncArrPointCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedFuncArrPoint) {
            if(!s.equals(completedFuncArrPoint.get(completedFuncArrPoint.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeFunct = stringBuilder.toString();

        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    S.setCompletedFuncArrPoint(completeFunct);
                    databaseReference.child("Students").child(user.getUid()).child("completedFuncArrPoint").setValue(S.getCompletedFuncArrPoint());
                    Log.e(TAG, "onDataChange: CompletedFuncArrPoint modification done : " + S.getCompletedFuncArrPoint());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });

    }
}
