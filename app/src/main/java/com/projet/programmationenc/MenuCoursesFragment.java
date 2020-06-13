package com.projet.programmationenc;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuCoursesFragment extends Fragment {
    private static final String TAG = "MenuCoursesFragment";
    private ImageButton btnbasec,btncondit,btnfunctarray,btnstrings,btnstruct,btnfile;
    private TextView txtvbasec,txtvcondit,txtvfunctarray,txtvstrings,txtvstruct,txtvfile,txtvprogrbasec,txtvprogrcondit,txtvprogrfunctarray,txtvprogrstrings,txtvprogrstruct,txtvprogrfile;
    private ProgressBar pbbasec,pbcondit,pbfunctarray,pbstrings,pbstruct,pbfile;
//    private FirebaseUser user;
//    public static List<String> completedBasic = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menucourses,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        user = FirebaseAuth.getInstance().getCurrentUser();

        btnbasec = view.findViewById(R.id.btnbasec);
        btncondit = view.findViewById(R.id.btncondit);
        btnfunctarray = view.findViewById(R.id.btnfunctarray);
        btnstrings = view.findViewById(R.id.btnstrings);
        btnstruct = view.findViewById(R.id.btnstruct);
        btnfile = view.findViewById(R.id.btnfile);

        txtvbasec = view.findViewById(R.id.txtvbasec);
        txtvcondit = view.findViewById(R.id.txtvcondit);
        txtvfunctarray = view.findViewById(R.id.txtvfunctarray);
        txtvstrings = view.findViewById(R.id.txtvstrings);
        txtvstruct = view.findViewById(R.id.txtvstruct);
        txtvfile = view.findViewById(R.id.txtvfile);

        txtvprogrbasec = view.findViewById(R.id.txtvprogrbasec);
        txtvprogrcondit = view.findViewById(R.id.txtvprogrcondit);
        txtvprogrfunctarray = view.findViewById(R.id.txtvprogrfunctarray);
        txtvprogrstrings = view.findViewById(R.id.txtvprogrstrings);
        txtvprogrstruct = view.findViewById(R.id.txtvprogrstruct);
        txtvprogrfile = view.findViewById(R.id.txtvprogrfile);

        pbbasec = view.findViewById(R.id.pbbasec);
        pbcondit = view.findViewById(R.id.pbcondit);
        pbfunctarray = view.findViewById(R.id.pbfunctarray);
        pbstrings = view.findViewById(R.id.pbstrings);
        pbstruct = view.findViewById(R.id.pbstruct);
        pbfile = view.findViewById(R.id.pbfile);


        List<String> completedBasic = ((HomeActivity) getActivity()).retrievedCompletedBasic;
        if(!BaseCFragment.completedBasic.isEmpty()) {
            completedBasic = BaseCFragment.completedBasic;
        }

        List<String> completedCondLoop = ((HomeActivity) getActivity()).retrievedCompletedCondLoop;
        if(!ConditFragment.completedCondLoop.isEmpty()) {
            completedCondLoop = ConditFragment.completedCondLoop;
        }

        List <String> completedFunctArrPoint = ((HomeActivity) getActivity()).retrievedCompletedFuncArrPoint;
        if(!FunctFragment.completedFuncArrPoint.isEmpty()) {
            completedFunctArrPoint = FunctFragment.completedFuncArrPoint;
        }

        List <String> completedStrings = ((HomeActivity) getActivity()).retrievedCompletedStrings;
        if(!StringsFragment.completedStrings.isEmpty()) {
            completedStrings = StringsFragment.completedStrings;
        }

        List <String> completedEnumStruct = ((HomeActivity) getActivity()).retrievedCompletedEnumStruct;
        if(!StructFragment.completedEnumStruct.isEmpty()) {
            completedEnumStruct = StructFragment.completedEnumStruct;
        }

        List <String> completedFiles = ((HomeActivity) getActivity()).retrievedCompletedFiles;
        if(!FileFragment.completedFiles.isEmpty()) {
            completedFiles = FileFragment.completedFiles;
        }


        btnbasec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).addToBackStack(null).commit();
            }
        });

        txtvbasec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).addToBackStack(null).commit();
            }
        });

        btncondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
            }
        });

        txtvcondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
            }
        });

        btnfunctarray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FunctFragment()).addToBackStack(null).commit();
            }
        });

        txtvfunctarray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FunctFragment()).addToBackStack(null).commit();
            }
        });

        btnstrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StringsFragment()).addToBackStack(null).commit();
            }
        });

        txtvstrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StringsFragment()).addToBackStack(null).commit();
            }
        });

        btnstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StructFragment()).addToBackStack(null).commit();
            }
        });

        txtvstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StructFragment()).addToBackStack(null).commit();
            }
        });

        btnfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FileFragment()).addToBackStack(null).commit();
            }
        });

        txtvfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FileFragment()).addToBackStack(null).commit();
            }
        });


        if(completedBasic.size() != 10) {
            txtvprogrcondit.setVisibility(View.GONE);
            pbcondit.setVisibility(View.GONE);

            txtvprogrfunctarray.setVisibility(View.GONE);
            pbfunctarray.setVisibility(View.GONE);

            txtvprogrstrings.setVisibility(View.GONE);
            pbstrings.setVisibility(View.GONE);

            txtvprogrstruct.setVisibility(View.GONE);
            pbstruct.setVisibility(View.GONE);

            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }
        else {
            txtvprogrcondit.setVisibility(View.VISIBLE);
            pbcondit.setVisibility(View.VISIBLE);
        }

        if(completedCondLoop.size() != 6) {
            txtvprogrfunctarray.setVisibility(View.GONE);
            pbfunctarray.setVisibility(View.GONE);

            txtvprogrstrings.setVisibility(View.GONE);
            pbstrings.setVisibility(View.GONE);

            txtvprogrstruct.setVisibility(View.GONE);
            pbstruct.setVisibility(View.GONE);

            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }
        else {
            txtvprogrfunctarray.setVisibility(View.VISIBLE);
            pbfunctarray.setVisibility(View.VISIBLE);
        }

        if(completedFunctArrPoint.size() != 6) {
            txtvprogrstrings.setVisibility(View.GONE);
            pbstrings.setVisibility(View.GONE);

            txtvprogrstruct.setVisibility(View.GONE);
            pbstruct.setVisibility(View.GONE);

            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }
        else {
            txtvprogrstrings.setVisibility(View.VISIBLE);
            pbstrings.setVisibility(View.VISIBLE);
        }

        if(completedStrings.size() != 3) {
            txtvprogrstruct.setVisibility(View.GONE);
            pbstruct.setVisibility(View.GONE);

            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }
        else {
            txtvprogrstruct.setVisibility(View.VISIBLE);
            pbstruct.setVisibility(View.VISIBLE);
        }

        if(completedEnumStruct.size() != 3) {
            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }
        else {
            txtvprogrfile.setVisibility(View.VISIBLE);
            pbfile.setVisibility(View.VISIBLE);
        }

        btnbasec.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
        btnbasec.setImageDrawable(getResources().getDrawable(R.drawable.ic_code_white_34dp));

        if(completedBasic.isEmpty()) {
            txtvprogrbasec.setText("0/10");
        }
        else if(completedBasic.size() == 1) {
            txtvprogrbasec.setText("1/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(1);
                }
            });
        }
        else if(completedBasic.size() == 2) {
            txtvprogrbasec.setText("2/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(2);
                }
            });
        }
        else if(completedBasic.size() == 3) {
            txtvprogrbasec.setText("3/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(3);
                }
            });
        }
        else if(completedBasic.size() == 4) {
            txtvprogrbasec.setText("4/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(4);
                }
            });
        }
        else if(completedBasic.size() == 5) {
            txtvprogrbasec.setText("5/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(5);
                }
            });
        }
        else if(completedBasic.size() == 6) {
            txtvprogrbasec.setText("6/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(6);
                }
            });
        }
        else if(completedBasic.size() == 7) {
            txtvprogrbasec.setText("7/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(7);
                }
            });
        }
        else if(completedBasic.size() == 8) {
            txtvprogrbasec.setText("8/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(8);
                }
            });
        }
        else if(completedBasic.size() == 9) {
            txtvprogrbasec.setText("9/10");
            pbbasec.post(new Runnable() {
                @Override
                public void run() {
                    pbbasec.setProgress(9);
                }
            });
        }
        else{
            txtvprogrbasec.setVisibility(View.GONE);
            pbbasec.setVisibility(View.GONE);
        }



        if(completedCondLoop.isEmpty()) {
            txtvprogrcondit.setText("0/6");
        }
        else if(completedCondLoop.size() == 1) {
            txtvprogrcondit.setText("1/6");
            pbcondit.post(new Runnable() {
                @Override
                public void run() {
                    pbcondit.setProgress(1);
                }
            });
        }
        else if(completedCondLoop.size() == 2) {
            txtvprogrcondit.setText("2/6");
            pbcondit.post(new Runnable() {
                @Override
                public void run() {
                    pbcondit.setProgress(2);
                }
            });
        }
        else if(completedCondLoop.size() == 3) {
            txtvprogrcondit.setText("3/6");
            pbcondit.post(new Runnable() {
                @Override
                public void run() {
                    pbcondit.setProgress(3);
                }
            });
        }
        else if(completedCondLoop.size() == 4) {
            txtvprogrcondit.setText("4/6");
            pbcondit.post(new Runnable() {
                @Override
                public void run() {
                    pbcondit.setProgress(4);
                }
            });
        }
        else if(completedCondLoop.size() == 5) {
            txtvprogrcondit.setText("5/6");
            pbcondit.post(new Runnable() {
                @Override
                public void run() {
                    pbcondit.setProgress(5);
                }
            });
        }
        else{
            txtvprogrcondit.setVisibility(View.GONE);
            pbcondit.setVisibility(View.GONE);
        }



        if(completedFunctArrPoint.isEmpty()) {
            txtvprogrfunctarray.setText("0/6");
        }
        else if(completedFunctArrPoint.size() == 1) {
            txtvprogrfunctarray.setText("1/6");
            pbfunctarray.post(new Runnable() {
                @Override
                public void run() {
                    pbfunctarray.setProgress(1);
                }
            });
        }
        else if(completedFunctArrPoint.size() == 2) {
            txtvprogrfunctarray.setText("2/6");
            pbfunctarray.post(new Runnable() {
                @Override
                public void run() {
                    pbfunctarray.setProgress(2);
                }
            });
        }
        else if(completedFunctArrPoint.size() == 3) {
            txtvprogrfunctarray.setText("3/6");
            pbfunctarray.post(new Runnable() {
                @Override
                public void run() {
                    pbfunctarray.setProgress(3);
                }
            });
        }
        else if(completedFunctArrPoint.size() == 4) {
            txtvprogrfunctarray.setText("4/6");
            pbfunctarray.post(new Runnable() {
                @Override
                public void run() {
                    pbfunctarray.setProgress(4);
                }
            });
        }
        else if(completedFunctArrPoint.size() == 5) {
            txtvprogrfunctarray.setText("5/6");
            pbfunctarray.post(new Runnable() {
                @Override
                public void run() {
                    pbfunctarray.setProgress(5);
                }
            });
        }
        else{
            txtvprogrfunctarray.setVisibility(View.GONE);
            pbfunctarray.setVisibility(View.GONE);
        }


        if(completedStrings.isEmpty()) {
            txtvprogrstrings.setText("0/3");
        }
        else if(completedStrings.size() == 1) {
            txtvprogrstrings.setText("1/3");
            pbstrings.post(new Runnable() {
                @Override
                public void run() {
                    pbstrings.setProgress(1);
                }
            });
        }
        else if(completedStrings.size() == 2) {
            txtvprogrstrings.setText("2/3");
            pbstrings.post(new Runnable() {
                @Override
                public void run() {
                    pbstrings.setProgress(2);
                }
            });
        }
        else{
            txtvprogrstrings.setVisibility(View.GONE);
            pbstrings.setVisibility(View.GONE);
        }



        if(completedEnumStruct.isEmpty()) {
            txtvprogrstruct.setText("0/3");
        }
        else if(completedEnumStruct.size() == 1) {
            txtvprogrstruct.setText("1/3");
            pbstruct.post(new Runnable() {
                @Override
                public void run() {
                    pbstruct.setProgress(1);
                }
            });
        }
        else if(completedEnumStruct.size() == 2) {
            txtvprogrstruct.setText("2/3");
            pbstruct.post(new Runnable() {
                @Override
                public void run() {
                    pbstruct.setProgress(2);
                }
            });
        }
        else{
            txtvprogrstruct.setVisibility(View.GONE);
            pbstruct.setVisibility(View.GONE);
        }


        if(completedFiles.isEmpty()) {
            txtvprogrfile.setText("0/2");
        }
        else if(completedFiles.size() == 1) {
            txtvprogrfile.setText("1/2");
            pbfile.post(new Runnable() {
                @Override
                public void run() {
                    pbfile.setProgress(1);
                }
            });
        }
        else{
            txtvprogrfile.setVisibility(View.GONE);
            pbfile.setVisibility(View.GONE);
        }



        if(completedBasic.size() == 10) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnbasec.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnbasec.setImageDrawable(getResources().getDrawable(R.drawable.ic_code_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btncondit.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btncondit.setImageDrawable(getResources().getDrawable(R.drawable.ic_all_inclusive_white_34dp));

            btncondit.setClickable(true);
            txtvcondit.setClickable(true);

            btnfunctarray.setClickable(false);
            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }
        else {
            btncondit.setClickable(false);
            txtvcondit.setClickable(false);
            btnfunctarray.setClickable(false);
            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }

        if(completedCondLoop.size() == 6) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btncondit.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btncondit.setImageDrawable(getResources().getDrawable(R.drawable.ic_all_inclusive_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnfunctarray.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnfunctarray.setImageDrawable(getResources().getDrawable(R.drawable.ic_build_white_34dp));

            btnfunctarray.setClickable(true);
            txtvfunctarray.setClickable(true);

            btnstrings.setClickable(false);
            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }
        else {
            btnfunctarray.setClickable(false);
            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }

        if(completedFunctArrPoint.size() == 6) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnfunctarray.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnfunctarray.setImageDrawable(getResources().getDrawable(R.drawable.ic_build_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnstrings.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnstrings.setImageDrawable(getResources().getDrawable(R.drawable.ic_widgets_white_34dp));

            btnstrings.setClickable(true);
            txtvstrings.setClickable(true);

            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }
        else {
            btnstrings.setClickable(false);
            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }

        if(completedStrings.size() == 3) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnstrings.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnstrings.setImageDrawable(getResources().getDrawable(R.drawable.ic_widgets_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnstruct.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnstruct.setImageDrawable(getResources().getDrawable(R.drawable.ic_device_hub_white_34dp));

            btnstruct.setClickable(true);
            txtvstruct.setClickable(true);

            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }
        else {
            btnstruct.setClickable(false);
            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }

        if(completedEnumStruct.size() == 3) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnstruct.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnstruct.setImageDrawable(getResources().getDrawable(R.drawable.ic_device_hub_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnfile.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_description_white_34dp));

            btnfile.setClickable(true);
            txtvfile.setClickable(true);
        }
        else {
            btnfile.setClickable(false);
            txtvfile.setClickable(false);
        }

        if(completedFiles.size() == 2) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnfile.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_description_white_34dp));
        }
    }
}
