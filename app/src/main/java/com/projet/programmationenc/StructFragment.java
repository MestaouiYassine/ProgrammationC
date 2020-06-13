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

public class StructFragment extends Fragment {
    private static final String TAG = "StructFragment";
    private RelativeLayout btnenum,btnsstruct,btnstructtab;
    private TextView txtvenum,txtvsstruct,txtvstructtab;
    public static List<String> completedEnumStruct;
    private String id;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_structs,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if(((HomeActivity) getActivity()).retrievedCompletedEnumStruct.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedEnumStruct is foking empty");
        }
        else {
            completedEnumStruct = ((HomeActivity) getActivity()).retrievedCompletedEnumStruct;
        }

        btnenum = view.findViewById(R.id.btnenum);
        btnsstruct = view.findViewById(R.id.btnsstruct);
        btnstructtab = view.findViewById(R.id.btnstructtab);

        txtvenum = view.findViewById(R.id.txtvenum);
        txtvsstruct = view.findViewById(R.id.txtvsstruct);
        txtvstructtab = view.findViewById(R.id.txtvstructtab);


        if(completedEnumStruct.contains("enum")) {
            txtvenum.setText("Complet");
            txtvenum.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedEnumStruct.contains("struct")) {
            txtvsstruct.setText("Complet");
            txtvsstruct.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedEnumStruct.contains("structtab")) {
            txtvstructtab.setText("Complet");
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("enum")) {
                    completedEnumStruct.add("enum");
                    updateEnumStructCourse();
                }
                id = "enum";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnsstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("struct")) {
                    completedEnumStruct.add("struct");
                    updateEnumStructCourse();
                }
                id = "struct";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnstructtab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedEnumStruct.contains("structtab")) {
                    completedEnumStruct.add("structtab");
                    updateEnumStructCourse();
                }
                id = "structtab";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });


        if(completedEnumStruct.isEmpty()) {

            btnsstruct.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnsstruct.setClickable(false);
            txtvsstruct.setTextColor(getResources().getColor(R.color.black));
            txtvsstruct.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvsstruct.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstructtab.setClickable(false);
            txtvstructtab.setTextColor(getResources().getColor(R.color.black));
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstructtab.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedEnumStruct.size() == 1 && completedEnumStruct.contains("enum")) {

            btnstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnstructtab.setClickable(false);
            txtvstructtab.setTextColor(getResources().getColor(R.color.black));
            txtvstructtab.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvstructtab.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
    }

    private void updateEnumStructCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedEnumStruct) {
            if(!s.equals(completedEnumStruct.get(completedEnumStruct.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeStruct = stringBuilder.toString();

        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    S.setCompletedEnumStruct(completeStruct);
                    databaseReference.child("Students").child(user.getUid()).child("completedEnumStruct").setValue(S.getCompletedEnumStruct());
                    Log.e(TAG, "onDataChange: CompletedStruct modification done : " + S.getCompletedEnumStruct());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });

    }
}
