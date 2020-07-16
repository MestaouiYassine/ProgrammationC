package com.projet.programmationenc;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
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
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";
    private CircleImageView imgvavatarprofile;
    private TextView txtvfullnameprofile, txtvstatusprofile, txtvprofilebasec,txtvtotalfriends,txtvtotalposts,txtvtotalcomments;
    private ImageButton btnchangestatus;
    private Button btnsendrequest, btncancelrequest;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String fullname, status;
    private Uri uri;
    private Student S;
    private String friendstatus = "notfriends";
    private String key;
    private Friend F1, F2;
    private ConstraintLayout clprofile;
    private CircularProgressBar pbprofilecourses;

    private List<String> retrievedBasic = new ArrayList<>();
    private List<String> retrievedCondLoop = new ArrayList<>();
    private List<String> retrievedFuncArrPoint = new ArrayList<>();
    private List<String> retrievedStrings = new ArrayList<>();
    private List<String> retrievedEnumStruct = new ArrayList<>();
    private List<String> retrievedFiles = new ArrayList<>();

    private int totalPosts,totalComments,totalFriends;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Profil");
        imgvavatarprofile = view.findViewById(R.id.imgvavatarprofile);
        txtvfullnameprofile = view.findViewById(R.id.txtvfullnameprofile);
        txtvstatusprofile = view.findViewById(R.id.txtvstatusprofile);
        btnchangestatus = view.findViewById(R.id.btnchangestatus);
        btnsendrequest = view.findViewById(R.id.btnsendrequest);
        btncancelrequest = view.findViewById(R.id.btncancelrequest);
        clprofile = view.findViewById(R.id.clprofile);
        pbprofilecourses = view.findViewById(R.id.pbprofilecourses);
        txtvprofilebasec = view.findViewById(R.id.txtvprofilecourses);
        txtvtotalfriends = view.findViewById(R.id.txtvtotalfriends);
        txtvtotalposts = view.findViewById(R.id.txtvtotalposts);
        txtvtotalcomments = view.findViewById(R.id.txtvtotalcomments);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(getContext());

        if (getArguments() != null) {
            key = getArguments().getString("key");
            RetrieveOtherProfile(key);
            RetrieveProgress(key);
            RetrieveFriends(key);
            RetrievePosts(key);
            RetrieveComments(key);
        } else {
            RetrieveStudentProfile();
            RetrieveProgress(user.getUid());
            RetrieveFriends(user.getUid());
            RetrievePosts(user.getUid());
            RetrieveComments(user.getUid());
        }

        btnchangestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("status", status);
                ChangeStatusFragment changeStatusFragment = new ChangeStatusFragment();
                changeStatusFragment.setArguments(bundle);
                Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
                if (currentFragment instanceof ProfileFragment) {
                    FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
                    fragTransaction.detach(currentFragment);
                    fragTransaction.commit();
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, changeStatusFragment).addToBackStack(null).commit();
            }
        });

        btnsendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnsendrequest.setEnabled(false);
                if (friendstatus.equals("notfriends")) {
                    SendRequestFriend();
                } else if (friendstatus.equals("sent")) {
                    CancelRequestFriend();
                } else if (friendstatus.equals("received")) {
                    AcceptRequestFriend();
                } else if (friendstatus.equals("friends")) {
                    DeleteFriend();
                }
            }
        });

        btncancelrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeclineRequestFriend();
            }
        });
    }

    public void RetrieveStudentProfile() {
        progressDialog.setTitle("Chargement des données");
        progressDialog.setMessage("Veuillez patienter quelques instants");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        databaseReference.child("Students").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && isAdded()) {
                    S = dataSnapshot.getValue(Student.class);
                    fullname = S.getFirstName() + " " + S.getLastName();
                    uri = Uri.parse(S.getAvatar());
                    status = S.getStatus();

                    Glide.with(getActivity())
                            .load(uri)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(imgvavatarprofile);

                    txtvfullnameprofile.setText(fullname);
                    txtvstatusprofile.setText(status);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void RetrieveOtherProfile(String key) {
        progressDialog.setTitle("Chargement des données");
        progressDialog.setMessage("Veuillez patienter quelques instants");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(clprofile);
        constraintSet.clear(R.id.txtvstatusprofile, ConstraintSet.BOTTOM);
        constraintSet.clear(R.id.btnchangestatus, ConstraintSet.BOTTOM);
        constraintSet.connect(R.id.btnsendrequest, ConstraintSet.BOTTOM, R.id.clprofile, ConstraintSet.BOTTOM, 32);
        constraintSet.applyTo(clprofile);
        databaseReference.child("Students").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && isAdded()) {
                    S = dataSnapshot.getValue(Student.class);
                    fullname = S.getFirstName() + " " + S.getLastName();
                    uri = Uri.parse(S.getAvatar());
                    status = S.getStatus();

                    Glide.with(getActivity())
                            .load(uri)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(imgvavatarprofile);

                    txtvfullnameprofile.setText(fullname);
                    txtvstatusprofile.setText(status);
                    btnchangestatus.setVisibility(View.GONE);
                    btnsendrequest.setVisibility(View.VISIBLE);

                    databaseReference.child("Requests").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild(key)) {
                                String req = dataSnapshot.child(key).child("type").getValue(String.class);
                                if (req != null && req.equals("received")) {
                                    friendstatus = "received";
                                    btnsendrequest.setText("Accepter l'invitation");
                                    btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_20, 0, 0, 0);
                                    ConstraintSet constraintSet = new ConstraintSet();
                                    constraintSet.clone(clprofile);
                                    constraintSet.clear(R.id.btnsendrequest, ConstraintSet.BOTTOM);
                                    constraintSet.applyTo(clprofile);
                                    btncancelrequest.setVisibility(View.VISIBLE);
                                } else if (req != null && req.equals("sent")) {
                                    friendstatus = "sent";
                                    btnsendrequest.setText("Annuler l'invitation");
                                    btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_disabled_20, 0, 0, 0);
                                }
                            } else {
                                databaseReference.child("Friends").child(user.getUid()).child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            friendstatus = "friends";
                                            btnsendrequest.setText("Supprimer " + fullname);
                                            btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_20, 0, 0, 0);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void SendRequestFriend() {
        databaseReference.child("Requests").child(user.getUid()).child(key).child("type").setValue("sent");
        databaseReference.child("Requests").child(key).child(user.getUid()).child("type").setValue("received");
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("from", user.getUid());
//        hashMap.put("type", "Invitation d'amitié");
//        hashMap.put("connected", "no");
//        databaseReference.child("Notifications").child(key).push().setValue(hashMap);
        friendstatus = "sent";
        btnsendrequest.setText("Annuler l'invitation");
        btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_disabled_20, 0, 0, 0);
        Toast.makeText(getActivity(), "Invitation envoyée !", Toast.LENGTH_SHORT).show();
        btnsendrequest.setEnabled(true);
    }

    public void CancelRequestFriend() {
        databaseReference.child("Requests").child(user.getUid()).child(key).removeValue();
        databaseReference.child("Requests").child(key).child(user.getUid()).removeValue();
//        databaseReference.child("Notifications").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                        Log.e(TAG, "onDataChange: datasnap : " + dataSnapshot.getKey());
//                        databaseReference.child("Notifications").child(key).child(dataSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                if (snapshot.exists()) {
//                                    String id = snapshot.child("from").getValue(String.class);
//                                    if (id.equals(user.getUid())) {
//                                        databaseReference.child("Notifications").child(key).child(dataSnapshot.getKey()).removeValue();
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        friendstatus = "notfriends";
        btnsendrequest.setText("Envoyer une invitation");
        btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_20, 0, 0, 0);
        Toast.makeText(getActivity(), "Invitation annulée !", Toast.LENGTH_SHORT).show();
        btnsendrequest.setEnabled(true);
    }

    public void AcceptRequestFriend() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        databaseReference.child("Students").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    S = snapshot.child(user.getUid()).getValue(Student.class);
                    F1 = new Friend(S.getStudentID(), S.getFirstName(), S.getLastName(), S.getAvatar(), S.getStatus(), sdf.format(new Date()));
                    Log.e(TAG, "onDataChange: f1 : " + F1.getFriendID());
                    S = snapshot.child(key).getValue(Student.class);
                    Log.e(TAG, "onDataChange: key : " + key);
                    F2 = new Friend(S.getStudentID(), S.getFirstName(), S.getLastName(), S.getAvatar(), S.getStatus(), sdf.format(new Date()));
                    Log.e(TAG, "onDataChange: f2 : " + F2.getFriendID());

                    databaseReference.child("Friends").child(user.getUid()).child(key).setValue(F2);
                    databaseReference.child("Friends").child(key).child(user.getUid()).setValue(F1);
                    databaseReference.child("Requests").child(user.getUid()).child(key).removeValue();
                    databaseReference.child("Requests").child(key).child(user.getUid()).removeValue();
                    btncancelrequest.setVisibility(View.GONE);
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(clprofile);
                    constraintSet.connect(R.id.btnsendrequest, ConstraintSet.BOTTOM, R.id.clprofile, ConstraintSet.BOTTOM, 32);
                    constraintSet.applyTo(clprofile);
                    friendstatus = "friends";
                    btnsendrequest.setText("Supprimer " + fullname);
                    btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_20, 0, 0, 0);
                    Toast.makeText(getActivity(), "Personne ajoutée !", Toast.LENGTH_SHORT).show();
                    btnsendrequest.setEnabled(true);

//                    databaseReference.child("Notifications").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if (snapshot.exists()) {
//                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                                    Log.e(TAG, "onDataChange: datasnap : " + dataSnapshot.getKey());
//                                    databaseReference.child("Notifications").child(user.getUid()).child(dataSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                            if (snapshot.exists()) {
//                                                String id = snapshot.child("from").getValue(String.class);
//                                                if (id.equals(key)) {
//                                                    databaseReference.child("Notifications").child(user.getUid()).child(dataSnapshot.getKey()).removeValue();
//                                                }
//                                            }
//                                        }
//
//                                        @Override
//                                        public void onCancelled(@NonNull DatabaseError error) {
//
//                                        }
//                                    });
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void DeclineRequestFriend() {
        databaseReference.child("Requests").child(user.getUid()).child(key).removeValue();
        databaseReference.child("Requests").child(key).child(user.getUid()).removeValue();
        btncancelrequest.setVisibility(View.GONE);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(clprofile);
        constraintSet.connect(R.id.btnsendrequest, ConstraintSet.BOTTOM, R.id.clprofile, ConstraintSet.BOTTOM, 32);
        constraintSet.applyTo(clprofile);
        friendstatus = "notfriends";
        btnsendrequest.setText("Envoyer une invitation");
        btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_20, 0, 0, 0);
        Toast.makeText(getActivity(), "Invitation déclinée !", Toast.LENGTH_SHORT).show();
        btnsendrequest.setEnabled(true);

//        databaseReference.child("Notifications").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                        Log.e(TAG, "onDataChange: datasnap : " + dataSnapshot.getKey());
//                        databaseReference.child("Notifications").child(user.getUid()).child(dataSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                if (snapshot.exists()) {
//                                    String id = snapshot.child("from").getValue(String.class);
//                                    if (id.equals(key)) {
//                                        databaseReference.child("Notifications").child(user.getUid()).child(dataSnapshot.getKey()).removeValue();
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    public void DeleteFriend() {
        databaseReference.child("Friends").child(user.getUid()).child(key).removeValue();
        databaseReference.child("Friends").child(key).child(user.getUid()).removeValue();
        friendstatus = "notfriends";
        btnsendrequest.setText("Envoyer une invitation");
        btnsendrequest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_person_add_20, 0, 0, 0);
        Toast.makeText(getActivity(), "Personne supprimée !", Toast.LENGTH_SHORT).show();
        btnsendrequest.setEnabled(true);
    }

    public void RetrieveProgress(String key) {
        databaseReference.child("Students").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    if (!S.getCompletedBasic().equals("null")) {
                        String string = S.getCompletedBasic();
                        String[] tstring = string.split("-");
                        retrievedBasic.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedCondLoop().equals("null")) {
                        String string = S.getCompletedCondLoop();
                        String[] tstring = string.split("-");
                        retrievedCondLoop.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedFuncArrPoint().equals("null")) {
                        String string = S.getCompletedFuncArrPoint();
                        String[] tstring = string.split("-");
                        retrievedFuncArrPoint.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedStrings().equals("null")) {
                        String string = S.getCompletedStrings();
                        String[] tstring = string.split("-");
                        retrievedStrings.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedEnumStruct().equals("null")) {
                        String string = S.getCompletedEnumStruct();
                        String[] tstring = string.split("-");
                        retrievedEnumStruct.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedFiles().equals("null")) {
                        String string = S.getCompletedFiles();
                        String[] tstring = string.split("-");
                        retrievedFiles.addAll(Arrays.asList(tstring));
                    }

                    float totalprogress = ((retrievedBasic.size() + retrievedCondLoop.size()  + retrievedFuncArrPoint.size() + retrievedStrings.size() + retrievedEnumStruct.size() + retrievedFiles.size())*(float)100/30);
                    Log.e(TAG, "onDataChange: total progress : " + totalprogress );
                    Log.e(TAG, "onDataChange: base c  : " + retrievedBasic.size() );
                    Log.e(TAG, "onDataChange: condit  : " + retrievedCondLoop.size() );
                    Log.e(TAG, "onDataChange: funct  : " + retrievedFuncArrPoint.size() );
                    Log.e(TAG, "onDataChange: strings  : " + retrievedStrings.size() );
                    Log.e(TAG, "onDataChange: struct  : " + retrievedEnumStruct.size() );
                    Log.e(TAG, "onDataChange: file  : " + retrievedFiles.size() );
                    if(totalprogress == 100) {
                        pbprofilecourses.setProgressBarColor(getResources().getColor(R.color.lightgreen));
                    }
                    pbprofilecourses.setProgress(totalprogress);
                    txtvprofilebasec.setText(new DecimalFormat("##.#").format(totalprogress) + " %");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public void RetrieveFriends(String key) {
        databaseReference.child("Friends").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                totalFriends = (int)snapshot.getChildrenCount();
                if(snapshot.getChildrenCount() == 1) {
                    txtvtotalfriends.setText(totalFriends + " Ami");
                }
                else {
                    txtvtotalfriends.setText(totalFriends + " Amis");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void RetrievePosts(String key) {
        databaseReference.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    if(dataSnapshot.child("studentID").getValue(String.class).equals(key)) {
                        totalPosts++;
                        Log.e(TAG, "onDataChange: totalposts : " + totalPosts );
                    }
                }
                if(totalPosts == 1) {
                    txtvtotalposts.setText(totalPosts + " Publication");
                }
                else {
                    txtvtotalposts.setText(totalPosts + " Publications");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void RetrieveComments(String key) {
        databaseReference.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    if(dataSnapshot.hasChild("Comments")) {
                        databaseReference.child("Posts").child(dataSnapshot.getKey()).child("Comments").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot snapshot1 : snapshot.getChildren()) {
                                    if(snapshot1.child("commentID").getValue(String.class).equals(key)) {
                                        totalComments++;
                                        Log.e(TAG, "onDataChange: totalcomments : " + totalComments );
                                    }
                                }
                                if(totalComments == 1) {
                                    txtvtotalcomments.setText(totalComments + " Commentaire");
                                }
                                else {
                                    txtvtotalcomments.setText(totalComments + " Commentaires");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
//        Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragcontainer);
//        if (currentFragment instanceof ProfileFragment) {
//            FragmentTransaction fragTransaction =   getActivity().getSupportFragmentManager().beginTransaction();
//            fragTransaction.detach(currentFragment);
//            fragTransaction.attach(currentFragment);
//            fragTransaction.commit();
//        }
    }
}
