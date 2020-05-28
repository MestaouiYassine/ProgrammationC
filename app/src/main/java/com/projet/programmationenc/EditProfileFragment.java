package com.projet.programmationenc;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theartofdev.edmodo.cropper.CropImage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfileFragment extends Fragment {
//    private final int code = 1;
    private static final String TAG = "EditProfileFragment";
    private FirebaseUser user;
    private String firstnameedit,lastnameedit;
    private ImageView imgvavataredit;
    private EditText edtlastnameedit,edtfirstnameedit;
    private TextView txtvchangeavatar;
    private Button btnconfirmedit;
    private ImageButton btnremoveavatar;
//    private DatabaseReference databaseReference;
    Uri imgavataruri;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editprofile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = FirebaseAuth.getInstance().getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance().getReference();
        imgvavataredit = view.findViewById(R.id.imgvavataredit);
        edtlastnameedit = view.findViewById(R.id.edtlastnameedit);
        edtfirstnameedit = view.findViewById(R.id.edtfirstnameedit);
        btnconfirmedit = view.findViewById(R.id.btnconfirmedit);
        btnremoveavatar = view.findViewById(R.id.btnremoveavatar);
        txtvchangeavatar = view.findViewById(R.id.txtvchangeavatar);

        edtfirstnameedit.setText(((HomeActivity) getActivity()).retrievedFirstName);
        edtlastnameedit.setText(((HomeActivity) getActivity()).retrievedLastName);
        if(((HomeActivity) getActivity()).retrievedAvatar != null) {
        imgavataruri = Uri.parse(((HomeActivity) getActivity()).retrievedAvatar);
            Glide.with(this)
                    .load(imgavataruri)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(imgvavataredit);

        }

        imgvavataredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageFile();
            }
        });

        txtvchangeavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageFile();
            }
        });

        btnremoveavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgavataruri = Uri.parse("android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round");
                        Glide.with(getActivity())
                                .load(imgavataruri)
                                .apply(RequestOptions.fitCenterTransform())
                                .into(imgvavataredit);
            }
        });

        btnconfirmedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstnameedit = edtfirstnameedit.getText().toString();
                lastnameedit = edtlastnameedit.getText().toString();
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,6}";
                boolean flag = true;

                if(firstnameedit.isEmpty()) {
                    edtfirstnameedit.setError("Veuillez saisir le prénom.");
                    flag = false;
                }

                if(lastnameedit.isEmpty()) {
                    edtlastnameedit.setError("Veuillez saisir le nom.");
                    flag = false;
                }

                if(!flag) {
                    return;
                }
                else {
                    String base_url = "http://192.168.1.104/progc/";

//                                Gson gson = new GsonBuilder()
//                                        .setLenient()
//                                        .create();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                    Call<Student> call = apiInterface.updateStudent(user.getUid(),firstnameedit,lastnameedit,imgavataruri.toString());

                    call.enqueue(new Callback<Student>() {
                        @Override
                        public void onResponse(Call<Student> call, Response<Student> response) {
                            if(!response.isSuccessful()) {
                                Log.e(TAG, "onResponse: Code " + response.code());
                                return;
                            }
                            Log.e(TAG, "onResponse: " + "Data updates");
                            Toast.makeText(getContext(),"Modification réussie !",Toast.LENGTH_SHORT).show();

                            getActivity().finish();
                            getActivity().overridePendingTransition(0, 0);
                            startActivity(getActivity().getIntent());
                            getActivity().overridePendingTransition(0, 0);
//                            refreshFragmentUI(getActivity().getSupportFragmentManager().findFragmentByTag("fragedit"));

//                            Fragment frg = getActivity().getSupportFragmentManager().findFragmentByTag("fragedit");
//                            FragmentTransaction transaction = getActivity().getSupportFragmentManager()
//                                    .beginTransaction();
//                            if (Build.VERSION.SDK_INT >= 26) {
//                                transaction.setReorderingAllowed(false);
//                            }
//                            transaction.detach(frg).attach
//                                    (frg).commit();

//                            Fragment frg = null;
//                            frg = getActivity().getSupportFragmentManager().findFragmentByTag("fragedit");
//                            final FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                            ft.detach(frg);
//                            ft.attach(frg);
//                            ft.commit();

//                            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
//                            if (currentFragment instanceof EditProfileFragment) {
//                                getActivity().getSupportFragmentManager().beginTransaction().detach(currentFragment);
//                                getActivity().getSupportFragmentManager().beginTransaction().attach(currentFragment);
//                                getActivity().getSupportFragmentManager().beginTransaction().commit();
//                            }
                        }

                        @Override
                        public void onFailure(Call<Student> call, Throwable t) {
                            Log.e(TAG, "onFailure: " + t.getMessage());
                        }
                    });
                }
            }
        });

    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            // Refresh your fragment here
//            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
//            Log.i("IsRefresh", "Yes");
//        }
//    }

//    public void refreshFragmentUI(Fragment fragment) {
//        getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .detach(fragment)
//                .attach(fragment)
//                .commit();
//    }

    private void openImageFile() {
        CropImage.activity()
                .setAspectRatio(1,1)
                .start(getContext(), this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                imgavataruri = result.getUri();
                Glide.with(this)
                        .load(imgavataruri)
                        .apply(RequestOptions.fitCenterTransform())
                        .into(imgvavataredit);
            }
        }

//        if(requestCode == 1) {
//            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//            if (Build.VERSION.SDK_INT >= 26) {
//                ft.setReorderingAllowed(false);
//            }
//            ft.detach(this).attach(this).commit();
//        }
    }

}

