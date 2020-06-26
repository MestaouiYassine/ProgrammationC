package com.projet.programmationenc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView txtvemail;
    private TextView txtvfullname;
    private NavigationView navigationView;
    public BottomNavigationView bottomNavigationView;
    private FirebaseUser user;
    public String retrievedFirstName;
    public String retrievedLastName;
    public String retrievedPassword;
    public String retrievedAvatar;
    public List<String> retrievedCompletedBasic = new ArrayList<>();
    public List<String> retrievedCompletedCondLoop = new ArrayList<>();
    public List<String> retrievedCompletedFuncArrPoint = new ArrayList<>();
    public List<String> retrievedCompletedStrings = new ArrayList<>();
    public List<String> retrievedCompletedEnumStruct = new ArrayList<>();
    public List<String> retrievedCompletedFiles = new ArrayList<>();
    private CircleImageView imgvavatartopnagiv;
    private DatabaseReference databaseReference;
    private Student S;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BaseCFragment.completedBasic = new ArrayList<>();
        ConditFragment.completedCondLoop = new ArrayList<>();
        FunctFragment.completedFuncArrPoint = new ArrayList<>();
        StringsFragment.completedStrings = new ArrayList<>();
        StructFragment.completedEnumStruct = new ArrayList<>();
        FileFragment.completedFiles = new ArrayList<>();


        navigationView = findViewById(R.id.nvhome);
        bottomNavigationView = findViewById(R.id.bnvhome);

        View headerView = navigationView.getHeaderView(0);
        imgvavatartopnagiv = headerView.findViewById(R.id.imgvavatartopnavig);
        txtvemail = headerView.findViewById(R.id.txtvemailnavhead);
        txtvfullname = headerView.findViewById(R.id.txtvfullnamenavhead);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        RetrieveStudentData();
        RetrieveStudentInfo();

        databaseReference.child("Notifications").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Log.e(TAG, "onDataChange: datasnap : " + dataSnapshot.getKey());
                        databaseReference.child("Notifications").child(user.getUid()).child(dataSnapshot.getKey()).child("connected").setValue("yes");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//Sets our toolbar as the actionbar
        drawer = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);// Setting the actionbarToggle to drawer layout
        actionBarDrawerToggle.syncState();

        ShowBackButton(false);

        if(getIntent().getStringExtra("key") != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key",getIntent().getStringExtra("key"));
            ProfileFragment profileFragment = new ProfileFragment();
            profileFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,profileFragment).commit();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ProfileFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.discussion:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new DiscussionFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.courses:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new MenuCoursesFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.exercices:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ExercicesFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.forum:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ForumFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ProfileFragment()).addToBackStack(null).commit();
                        break;
                }

//                getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, selectedFragment).addToBackStack(null).commit();
                ShowBackButton(false);
                return true;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.editprofile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new EditProfileFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.changepassword:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ChangePasswordFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ContactFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.signout:
                        BaseCFragment.completedBasic = null;
                        ConditFragment.completedCondLoop = null;
                        FunctFragment.completedFuncArrPoint = null;
                        StringsFragment.completedStrings = null;
                        StructFragment.completedEnumStruct = null;
                        FileFragment.completedFiles = null;
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                ShowBackButton(true);
                bottomNavigationView.setVisibility(View.GONE);
                return true;
            }
        });

    }

    public void RetrieveStudentData() {
        databaseReference.child("Students").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    retrievedPassword = S.getPass();
                    if (!S.getCompletedBasic().equals("null")) {
                        String string = S.getCompletedBasic();
                        String[] tstring = string.split("-");
                        retrievedCompletedBasic.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedCondLoop().equals("null")) {
                        String string = S.getCompletedCondLoop();
                        String[] tstring = string.split("-");
                        retrievedCompletedCondLoop.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedFuncArrPoint().equals("null")) {
                        String string = S.getCompletedFuncArrPoint();
                        String[] tstring = string.split("-");
                        retrievedCompletedFuncArrPoint.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedStrings().equals("null")) {
                        String string = S.getCompletedStrings();
                        String[] tstring = string.split("-");
                        retrievedCompletedStrings.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedEnumStruct().equals("null")) {
                        String string = S.getCompletedEnumStruct();
                        String[] tstring = string.split("-");
                        retrievedCompletedEnumStruct.addAll(Arrays.asList(tstring));
                    }
                    if (!S.getCompletedFiles().equals("null")) {
                        String string = S.getCompletedFiles();
                        String[] tstring = string.split("-");
                        retrievedCompletedFiles.addAll(Arrays.asList(tstring));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public void RetrieveStudentInfo() {
        databaseReference.child("Students").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    S = dataSnapshot.getValue(Student.class);
                    retrievedFirstName = S.getFirstName();
                    retrievedLastName = S.getLastName();
                    retrievedAvatar = S.getAvatar();

                    String fullname = retrievedFirstName + " " + retrievedLastName;
                    txtvemail.setText(user.getEmail());
                    txtvfullname.setText(fullname);
                    Uri uri = Uri.parse(retrievedAvatar);
                    Glide.with(HomeActivity.this)
                            .load(uri)
                            .apply(RequestOptions.fitCenterTransform())
                            .into(imgvavatartopnagiv);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }

    public void ShowBackButton(Boolean show) {
        if (show) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            //You must regain the power of swipe for the drawer.
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            actionBarDrawerToggle.setToolbarNavigationClickListener(null);
        }
    }

    //if we press the back button while our navigation drawer is opened we don't need to leave the activity immediately
    //instead we want to close our navigation drawer
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            PostCommentFragment postCommentFragment = new PostCommentFragment();
            if(PostCommentFragment.claddcoment != null && PostCommentFragment.claddcoment.getVisibility() == View.VISIBLE) {
                PostCommentFragment.claddcoment.setVisibility(View.INVISIBLE);
                TranslateAnimation animate = new TranslateAnimation(
                        0,                 // fromXDelta
                        0,                 // toXDelta
                        0,                 // fromYDelta
                        PostCommentFragment.claddcoment.getHeight()); // toYDelta
                animate.setDuration(350);
                animate.setFillAfter(true);
                PostCommentFragment.claddcoment.startAnimation(animate);
                PostCommentFragment.fabcomment.setVisibility(View.VISIBLE);
                return;
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
            } else { //when the navigation drawer is closed we will close the current activity
//                super.onBackPressed();
                this.moveTaskToBack(true);
            }
            ShowBackButton(false);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
    }

}
