package com.projet.programmationenc;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
//    private TextView txtvbasec,txtvcondit,txtvfunctarray,txtvstrings,txtvstruct,txtvfile;
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

//        txtvbasec = view.findViewById(R.id.txtvbasec);
//        txtvcondit = view.findViewById(R.id.txtvcondit);
//        txtvfunctarray = view.findViewById(R.id.txtvfunctarray);
//        txtvstrings = view.findViewById(R.id.txtvstrings);
//        txtvstruct = view.findViewById(R.id.txtvstruct);
//        txtvfile = view.findViewById(R.id.txtvfile);

//        Drawable unwrappedDrawable = AppCompatResources.getDrawable(getContext(), R.drawable.roundeddarkgraybutton);
//        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);

//        String[] basicCourses = new String[completedBasic.size()];
//        completedBasic.toArray(basicCourses);
//
//        String base_url = "http://192.168.1.104/progc/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(base_url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<Student> call = apiInterface.updateBasic(user.getUid(),basicCourses);
//
//        call.enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//                if(!response.isSuccessful()) {
//                    Log.e(TAG, "onResponse: Code " + response.code());
//                    return;
//                }
//                Log.e(TAG, "onResponse: " + "basicCourses in mysql");
//
//                getActivity().finish();
//                getActivity().overridePendingTransition(0, 0);
//                startActivity(getActivity().getIntent());
//                getActivity().overridePendingTransition(0, 0);
////                                            Intent intent = getActivity().getIntent();
////                                            intent.putExtra("fragedit","changepassword");
////                                            startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t) {
//                Log.e(TAG, "onFailure: " + t.getMessage());
//            }
//        });

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

//        txtvbasec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new BaseCFragment()).addToBackStack(null).commit();
//            }
//        });

        btncondit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
            }
        });

//        txtvcondit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ConditFragment()).addToBackStack(null).commit();
//            }
//        });

        btnfunctarray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FunctFragment()).addToBackStack(null).commit();
            }
        });

//        txtvfunctarray.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FunctFragment()).addToBackStack(null).commit();
//            }
//        });

        btnstrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StringsFragment()).addToBackStack(null).commit();
            }
        });

//        txtvstrings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StringsFragment()).addToBackStack(null).commit();
//            }
//        });

        btnstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StructFragment()).addToBackStack(null).commit();
            }
        });

//        txtvstruct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new StructFragment()).addToBackStack(null).commit();
//            }
//        });

        btnfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FileFragment()).addToBackStack(null).commit();
            }
        });

//        txtvfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new FileFragment()).addToBackStack(null).commit();
//            }
//        });


//        DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));

        btnbasec.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
        btnbasec.setImageDrawable(getResources().getDrawable(R.drawable.ic_code_white_34dp));

        if(completedBasic.size() == 10) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnbasec.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnbasec.setImageDrawable(getResources().getDrawable(R.drawable.ic_code_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btncondit.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btncondit.setImageDrawable(getResources().getDrawable(R.drawable.ic_all_inclusive_white_34dp));

            btncondit.setClickable(true);
//            txtvcondit.setClickable(true);

            btnfunctarray.setClickable(false);
//            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
//            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }
        else {
            btncondit.setClickable(false);
//            txtvcondit.setClickable(false);
            btnfunctarray.setClickable(false);
//            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
//            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }

        if(completedCondLoop.size() == 6) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btncondit.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btncondit.setImageDrawable(getResources().getDrawable(R.drawable.ic_all_inclusive_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnfunctarray.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnfunctarray.setImageDrawable(getResources().getDrawable(R.drawable.ic_build_white_34dp));

            btnfunctarray.setClickable(true);
//            txtvfunctarray.setClickable(true);

            btnstrings.setClickable(false);
//            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }
        else {
            btnfunctarray.setClickable(false);
//            txtvfunctarray.setClickable(false);
            btnstrings.setClickable(false);
//            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }

        if(completedFunctArrPoint.size() == 6) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnfunctarray.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnfunctarray.setImageDrawable(getResources().getDrawable(R.drawable.ic_build_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnstrings.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnstrings.setImageDrawable(getResources().getDrawable(R.drawable.ic_widgets_white_34dp));

            btnstrings.setClickable(true);
//            txtvstrings.setClickable(true);

            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }
        else {
            btnstrings.setClickable(false);
//            txtvstrings.setClickable(false);
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }

        if(completedStrings.size() == 3) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnstrings.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnstrings.setImageDrawable(getResources().getDrawable(R.drawable.ic_widgets_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnstruct.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnstruct.setImageDrawable(getResources().getDrawable(R.drawable.ic_device_hub_white_34dp));

            btnstruct.setClickable(true);
//            txtvstruct.setClickable(true);

            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }
        else {
            btnstruct.setClickable(false);
//            txtvstruct.setClickable(false);
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }

        if(completedEnumStruct.size() == 3) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnstruct.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnstruct.setImageDrawable(getResources().getDrawable(R.drawable.ic_device_hub_white_34dp));

//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.darkgray));
            btnfile.setBackground(getResources().getDrawable(R.drawable.roundeddarkgraybutton));
            btnfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_description_white_34dp));

            btnfile.setClickable(true);
//            txtvfile.setClickable(true);
        }
        else {
            btnfile.setClickable(false);
//            txtvfile.setClickable(false);
        }

        if(completedFiles.size() == 2) {
//            DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.lightgreen));
            btnfile.setBackground(getResources().getDrawable(R.drawable.roundedlightgreenbutton));
            btnfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_description_white_34dp));
        }
    }
}
