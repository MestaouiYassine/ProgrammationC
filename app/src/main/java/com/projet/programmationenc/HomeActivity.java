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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private Student S;
    private ImageView imgvavatartopnagiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.nvhome);
        bottomNavigationView = findViewById(R.id.bnvhome);

        View headerView = navigationView.getHeaderView(0);
        imgvavatartopnagiv = headerView.findViewById(R.id.imgvavatartopnavig);
        txtvemail = headerView.findViewById(R.id.txtvemailnavhead);
        txtvfullname = headerView.findViewById(R.id.txtvfullnamenavhead);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            Toast.makeText(this,"User is signed in Pog",Toast.LENGTH_SHORT).show();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            databaseReference.child("Etudiants").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Log.e(TAG, "onDataChange: hahowa dkhel bach ijbed data mn realtime database");
                        S = snapshot.getValue(Student.class);
                        if(S.id.equals(user.getUid())) {
                            retrievedFirstName = S.firstname;
                            retrievedLastName = S.lastname;
                            retrievedPassword = S.password;
                            String fullname = retrievedFirstName + " " + retrievedLastName;
                            txtvemail.setText(user.getEmail());
                            txtvfullname.setText(fullname);
                                retrievedAvatar = S.avatarUri;
                                Glide.with(HomeActivity.this)
                                        .load(Uri.parse(retrievedAvatar))
                                        .apply(RequestOptions.fitCenterTransform())
                                        .into(imgvavatartopnagiv);
                                Log.e(TAG, "onDataChange: l9a avatar o zado f imgview dial top navig");
                            break;
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//Sets our toolbar as the actionbar
        drawer = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);// Setting the actionbarToggle to drawer layout
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new HomeFragment()).commit();
        ShowBackButton(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeb:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new HomeFragment()).addToBackStack(null).commit();
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
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer, new ProfilFragment()).addToBackStack(null).commit();
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
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
            }
            else { //when the navigation drawer is closed we will close the current activity
//                super.onBackPressed();
                this.moveTaskToBack(true);
            }
            ShowBackButton(false);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
    }
}
