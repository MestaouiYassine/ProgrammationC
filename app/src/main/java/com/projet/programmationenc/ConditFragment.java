package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class ConditFragment extends Fragment {
    private static final String TAG = "ConditFragment";
    private RelativeLayout btnifelse,btnoplog,btnswitch,btnwhile,btndowhile,btnfor;
    private TextView txtvifelse,txtvoplog,txtvswitch,txtvwhile,txtvdowhile,txtvfor;
    private String id;
    private FirebaseUser user;
    public static List<String> completedCondLoop;
    private DatabaseReference databaseReference;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_condit,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Conditions et boucles");
        ((HomeActivity) getActivity()).ShowBackButton(true);


        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if(((HomeActivity) getActivity()).retrievedCompletedCondLoop.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedCondLoop is  empty");
        }
        else {
            completedCondLoop = ((HomeActivity) getActivity()).retrievedCompletedCondLoop;
        }

        btnifelse = view.findViewById(R.id.btnifelse);
        btnoplog = view.findViewById(R.id.btnoplog);
        btnswitch = view.findViewById(R.id.btnswitch);
        btnwhile = view.findViewById(R.id.btnwhile);
        btndowhile = view.findViewById(R.id.btndowhile);
        btnfor = view.findViewById(R.id.btnfor);

        txtvifelse = view.findViewById(R.id.txtvifelse);
        txtvoplog = view.findViewById(R.id.txtvoplog);
        txtvswitch = view.findViewById(R.id.txtvswitch);
        txtvwhile = view.findViewById(R.id.txtvwhile);
        txtvdowhile = view.findViewById(R.id.txtvdowhile);
        txtvfor = view.findViewById(R.id.txtvfor);


        if(completedCondLoop.contains("ifelse")) {
            txtvifelse.setText("Complet");
            txtvifelse.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedCondLoop.contains("oplog")) {
            txtvoplog.setText("Complet");
            txtvoplog.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedCondLoop.contains("switch")) {
            txtvswitch.setText("Complet");
            txtvswitch.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedCondLoop.contains("while")) {
            txtvwhile.setText("Complet");
            txtvwhile.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedCondLoop.contains("dowhile")) {
            txtvdowhile.setText("Complet");
            txtvdowhile.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedCondLoop.contains("for")) {
            txtvfor.setText("Complet");
            txtvfor.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }



        btnifelse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("ifelse")) {
                    completedCondLoop.add("ifelse");
                    updateCondLoopCourse();
                }
                id = "ifelse";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnoplog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("oplog")) {
                    completedCondLoop.add("oplog");
                    updateCondLoopCourse();
                }
                id = "oplog";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("switch")) {
                    completedCondLoop.add("switch");
                    updateCondLoopCourse();
                }
                id = "switch";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnwhile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("while")) {
                    completedCondLoop.add("while");
                    updateCondLoopCourse();
                }
                id = "while";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btndowhile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("dowhile")) {
                    completedCondLoop.add("dowhile");
                    updateCondLoopCourse();
                }
                id = "dowhile";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedCondLoop.contains("for")) {
                    completedCondLoop.add("for");
                    updateCondLoopCourse();
                }
                id = "for";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        if(completedCondLoop.isEmpty()) {


            btnoplog.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnoplog.setClickable(false);
            txtvoplog.setTextColor(getResources().getColor(R.color.black));
            txtvoplog.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvoplog.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnswitch.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnswitch.setClickable(false);
            txtvswitch.setTextColor(getResources().getColor(R.color.black));
            txtvswitch.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvswitch.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnwhile.setClickable(false);
            txtvwhile.setTextColor(getResources().getColor(R.color.black));
            txtvwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvwhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btndowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btndowhile.setClickable(false);
            txtvdowhile.setTextColor(getResources().getColor(R.color.black));
            txtvdowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvdowhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfor.setClickable(false);
            txtvfor.setTextColor(getResources().getColor(R.color.black));
            txtvfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedCondLoop.size() == 1 && completedCondLoop.contains("ifelse")) {

            btnswitch.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnswitch.setClickable(false);
            txtvswitch.setTextColor(getResources().getColor(R.color.black));
            txtvswitch.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvswitch.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnwhile.setClickable(false);
            txtvwhile.setTextColor(getResources().getColor(R.color.black));
            txtvwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvwhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btndowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btndowhile.setClickable(false);
            txtvdowhile.setTextColor(getResources().getColor(R.color.black));
            txtvdowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvdowhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfor.setClickable(false);
            txtvfor.setTextColor(getResources().getColor(R.color.black));
            txtvfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedCondLoop.size() == 2 && completedCondLoop.contains("oplog")) {

            btnwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnwhile.setClickable(false);
            txtvwhile.setTextColor(getResources().getColor(R.color.black));
            txtvwhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvwhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btndowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btndowhile.setClickable(false);
            txtvdowhile.setTextColor(getResources().getColor(R.color.black));
            txtvdowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvdowhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfor.setClickable(false);
            txtvfor.setTextColor(getResources().getColor(R.color.black));
            txtvfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedCondLoop.size() == 3 && completedCondLoop.contains("switch")) {

            btndowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            btndowhile.setClickable(false);
            txtvdowhile.setTextColor(getResources().getColor(R.color.black));
            txtvdowhile.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvdowhile.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfor.setClickable(false);
            txtvfor.setTextColor(getResources().getColor(R.color.black));
            txtvfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedCondLoop.size() == 4 && completedCondLoop.contains("while")) {

            btnfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnfor.setClickable(false);
            txtvfor.setTextColor(getResources().getColor(R.color.black));
            txtvfor.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvfor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
    }

    private void updateCondLoopCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedCondLoop) {
            if(!s.equals(completedCondLoop.get(completedCondLoop.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeCondit= stringBuilder.toString();

        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    S.setCompletedCondLoop(completeCondit);
                    databaseReference.child("Students").child(user.getUid()).child("completedCondLoop").setValue(S.getCompletedCondLoop());
                    Log.e(TAG, "onDataChange: CompletedCondit modification done : " + S.getCompletedCondLoop());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });

    }
}
