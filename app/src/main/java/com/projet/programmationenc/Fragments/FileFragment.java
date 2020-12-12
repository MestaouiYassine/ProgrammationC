package com.projet.programmationenc.Fragments;

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
import com.projet.programmationenc.ui.HomeActivity;
import com.projet.programmationenc.Moduls.Student;
import com.projet.programmationenc.R;

import java.util.List;

public class FileFragment extends Fragment {
    private static final String TAG = "FileFragment";
    private RelativeLayout btnfile1,btnfile2;
    private TextView txtvfile1,txtvfile2;
    public static List<String> completedFiles;
    private String id;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_file,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Les fichiers");
        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if(((HomeActivity) getActivity()).retrievedCompletedFiles.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedFiles is foking empty");
        }
        else {
            completedFiles = ((HomeActivity) getActivity()).retrievedCompletedFiles;
        }

        btnfile1 = view.findViewById(R.id.btnfile1);
        btnfile2 = view.findViewById(R.id.btnfile2);

        txtvfile1 = view.findViewById(R.id.txtvfile1);
        txtvfile2 = view.findViewById(R.id.txtvfile2);


        if(completedFiles.contains("file1")) {
            txtvfile1.setText("Complet");
            txtvfile1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedFiles.contains("file2")) {
            txtvfile2.setText("Complet");
            txtvfile2.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFiles.contains("file1")) {
                    completedFiles.add("file1");
                    updateFileCourse();
                }
                id = "file1";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedFiles.contains("file2")) {
                    completedFiles.add("file2");
                    updateFileCourse();
                }
                id = "file2";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });



        if(completedFiles.isEmpty()) {

            btnfile2.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfile2.setClickable(false);
            txtvfile2.setTextColor(getResources().getColor(R.color.black));
            txtvfile2.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfile2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
    }

    private void updateFileCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedFiles) {
            if(!s.equals(completedFiles.get(completedFiles.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeFiles = stringBuilder.toString();

        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    S.setCompletedFiles(completeFiles);
                    databaseReference.child("Students").child(user.getUid()).child("completedFiles").setValue(S.getCompletedFiles());
                    Log.e(TAG, "onDataChange: CompletedFiles modification done : " + S.getCompletedFiles());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });

    }
}
