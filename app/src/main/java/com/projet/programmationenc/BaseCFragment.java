package com.projet.programmationenc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseCFragment extends Fragment {
    private static final String TAG = "BaseCFragment";
    private RelativeLayout btnpremierprogc,btnbackslashn,btntypevar,btntypecar,btnputchar,btnlireclav,btntypebase,btnspeciform,btnop,btnconstant;
    private TextView txtvpremierprogc,txtvbackslashn,txtvtypevar,txtvtypecar,txtvputchar,txtvlireclav,txtvtypebase,txtvspeciform,txtvop,txtvconstant;
    private String id;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    public static List<String> completedBasic;
    private Student S;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).ShowBackButton(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        if(((HomeActivity) getActivity()).retrievedCompletedBasic.isEmpty()) {
            Log.e(TAG, "onViewCreated: retrievedCompletedBasic is empty");
        }
        else {
            completedBasic = ((HomeActivity) getActivity()).retrievedCompletedBasic;
        }


        btnpremierprogc = view.findViewById(R.id.btnpremierprogc);
        btnbackslashn = view.findViewById(R.id.btnbackslashn);
        btntypevar = view.findViewById(R.id.btntypevar);
        btntypecar = view.findViewById(R.id.btntypecar);
        btnputchar = view.findViewById(R.id.btnputchar);
        btnlireclav = view.findViewById(R.id.btnlireclav);
        btntypebase = view.findViewById(R.id.btntypebase);
        btnspeciform = view.findViewById(R.id.btnspeciform);
        btnop = view.findViewById(R.id.btnop);
        btnconstant = view.findViewById(R.id.btnconstant);

        txtvpremierprogc = view.findViewById(R.id.txtvpremierprogc);
        txtvbackslashn = view.findViewById(R.id.txtvbackslashn);
        txtvtypevar = view.findViewById(R.id.txtvtypevar);
        txtvtypecar = view.findViewById(R.id.txtvtypecar);
        txtvputchar = view.findViewById(R.id.txtvputchar);
        txtvlireclav = view.findViewById(R.id.txtvlireclav);
        txtvtypebase = view.findViewById(R.id.txtvtypebase);
        txtvspeciform = view.findViewById(R.id.txtvspeciform);
        txtvop = view.findViewById(R.id.txtvop);
        txtvconstant = view.findViewById(R.id.txtvconstant);


        if(completedBasic.contains("premierprogc")) {
            txtvpremierprogc.setText("Complet");
            txtvpremierprogc.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("backslashn")) {
            txtvbackslashn.setText("Complet");
            txtvbackslashn.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("typevar")) {
            txtvtypevar.setText("Complet");
            txtvtypevar.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("typecar")) {
            txtvtypecar.setText("Complet");
            txtvtypecar.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("putchar")) {
            txtvputchar.setText("Complet");
            txtvputchar.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("lireclav")) {
            txtvlireclav.setText("Complet");
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("typebase")) {
            txtvtypebase.setText("Complet");
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("speciform")) {
            txtvspeciform.setText("Complet");
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("op")) {
            txtvop.setText("Complet");
            txtvop.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }

        if(completedBasic.contains("constant")) {
            txtvconstant.setText("Complet");
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        }


        btnpremierprogc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("premierprogc")) {
                    completedBasic.add("premierprogc");
                    updateBaseCourse();
                }
                id = "premierprogc";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
//                bundle.putStringArrayList("list",completedBasic);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnbackslashn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("backslashn")) {
                    completedBasic.add("backslashn");
                    updateBaseCourse();
                }
                id = "backslashn";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypevar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("typevar")) {
                    completedBasic.add("typevar");
                    updateBaseCourse();
                }
                id = "typevar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("typecar")) {
                    completedBasic.add("typecar");
                    updateBaseCourse();
                }
                id = "typecar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnputchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("putchar")) {
                    completedBasic.add("putchar");
                    updateBaseCourse();
                }
                id = "putchar";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnlireclav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("lireclav")) {
                    completedBasic.add("lireclav");
                    updateBaseCourse();
                }
                id = "lireclav";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btntypebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("typebase")) {
                    completedBasic.add("typebase");
                    updateBaseCourse();
                }
                id = "typebase";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnspeciform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("speciform")) {
                    completedBasic.add("speciform");
                    updateBaseCourse();
                }
                id = "speciform";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("op")) {
                    completedBasic.add("op");
                    updateBaseCourse();
                }
                id = "op";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        btnconstant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!completedBasic.contains("constant")) {
                    completedBasic.add("constant");
                    updateBaseCourse();
                }
                id = "constant";
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                CoursesFragment coursesFragment = new CoursesFragment();
                coursesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, coursesFragment).addToBackStack(null).commit();
            }
        });

        if(completedBasic.isEmpty()) {

            btnbackslashn.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnbackslashn.setClickable(false);
            txtvbackslashn.setTextColor(getResources().getColor(R.color.black));
            txtvbackslashn.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvbackslashn.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypevar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypevar.setClickable(false);
            txtvtypevar.setTextColor(getResources().getColor(R.color.black));
            txtvtypevar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypevar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypecar.setClickable(false);
            txtvtypecar.setTextColor(getResources().getColor(R.color.black));
            txtvtypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypecar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnputchar.setClickable(false);
            txtvputchar.setTextColor(getResources().getColor(R.color.black));
            txtvputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvputchar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnlireclav.setClickable(false);
            txtvlireclav.setTextColor(getResources().getColor(R.color.black));
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvlireclav.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedBasic.size() == 1 && completedBasic.contains("premierprogc")){

            btntypevar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypevar.setClickable(false);
            txtvtypevar = view.findViewById(R.id.txtvtypevar);
            txtvtypevar.setTextColor(getResources().getColor(R.color.black));
            txtvtypevar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypevar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypecar.setClickable(false);
            txtvtypecar = view.findViewById(R.id.txtvtypecar);
            txtvtypecar.setTextColor(getResources().getColor(R.color.black));
            txtvtypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypecar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnputchar.setClickable(false);
            txtvputchar = view.findViewById(R.id.txtvputchar);
            txtvputchar.setTextColor(getResources().getColor(R.color.black));
            txtvputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvputchar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnlireclav.setClickable(false);
            txtvlireclav = view.findViewById(R.id.txtvlireclav);
            txtvlireclav.setTextColor(getResources().getColor(R.color.black));
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvlireclav.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase = view.findViewById(R.id.txtvtypebase);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 2 && completedBasic.contains("backslashn")) {

            btntypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypecar.setClickable(false);
            txtvtypecar = view.findViewById(R.id.txtvtypecar);
            txtvtypecar.setTextColor(getResources().getColor(R.color.black));
            txtvtypecar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypecar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnputchar.setClickable(false);
            txtvputchar = view.findViewById(R.id.txtvputchar);
            txtvputchar.setTextColor(getResources().getColor(R.color.black));
            txtvputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvputchar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnlireclav.setClickable(false);
            txtvlireclav = view.findViewById(R.id.txtvlireclav);
            txtvlireclav.setTextColor(getResources().getColor(R.color.black));
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvlireclav.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase = view.findViewById(R.id.txtvtypebase);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 3 && completedBasic.contains("typevar")) {

            btnputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnputchar.setClickable(false);
            txtvputchar = view.findViewById(R.id.txtvputchar);
            txtvputchar.setTextColor(getResources().getColor(R.color.black));
            txtvputchar.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvputchar.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnlireclav.setClickable(false);
            txtvlireclav = view.findViewById(R.id.txtvlireclav);
            txtvlireclav.setTextColor(getResources().getColor(R.color.black));
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvlireclav.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase = view.findViewById(R.id.txtvtypebase);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 4 && completedBasic.contains("typecar")) {

            btnlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnlireclav.setClickable(false);
            txtvlireclav = view.findViewById(R.id.txtvlireclav);
            txtvlireclav.setTextColor(getResources().getColor(R.color.black));
            txtvlireclav.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvlireclav.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase = view.findViewById(R.id.txtvtypebase);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 5  && completedBasic.contains("putchar")) {

            btntypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            btntypebase.setClickable(false);
            txtvtypebase = view.findViewById(R.id.txtvtypebase);
            txtvtypebase.setTextColor(getResources().getColor(R.color.black));
            txtvtypebase.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvtypebase.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 6 && completedBasic.contains("lireclav")) {

            btnspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnspeciform.setClickable(false);
            txtvspeciform = view.findViewById(R.id.txtvspeciform);
            txtvspeciform.setTextColor(getResources().getColor(R.color.black));
            txtvspeciform.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvspeciform.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }
        else if(completedBasic.size() == 7  && completedBasic.contains("typebase")) {

            btnop.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnop.setClickable(false);
            txtvop = view.findViewById(R.id.txtvop);
            txtvop.setTextColor(getResources().getColor(R.color.black));
            txtvop.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvop.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);

        }
        else if(completedBasic.size() == 8 && completedBasic.contains("speciform")) {

            btnconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            btnconstant.setClickable(false);
            txtvconstant = view.findViewById(R.id.txtvconstant);
            txtvconstant.setTextColor(getResources().getColor(R.color.black));
            txtvconstant.setBackgroundColor(getResources().getColor(R.color.grayround));
            txtvconstant.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock_graylock_24dp,0);
        }

    }

    private void updateBaseCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : completedBasic) {
            if(!s.equals(completedBasic.get(completedBasic.size() - 1))) {
                stringBuilder.append(s + "-");
            }
            else {
                stringBuilder.append(s);
            }
        }

        String completeBase = stringBuilder.toString();

        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                        S = dataSnapshot.getValue(Student.class);
                        S.setCompletedBasic(completeBase);
                        databaseReference.child("Students").child(user.getUid()).child("completedBasic").setValue(S.getCompletedBasic());
                        Log.e(TAG, "onDataChange: CompletedBasic modification done : " + S.getCompletedBasic());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }
}
