package com.projet.programmationenc.Service;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class App extends Application {
    public static final String CHANNEL_1_ID = "channel1";
//    public static final String CHANNEL_2_ID = "channel2";
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    @Override
    public void onCreate() {
        super.onCreate();

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        createNotificationChannels();
        PresenceSystem();
    }
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    private void PresenceSystem() {
        if(user != null) {
            databaseReference.child("Students").child(user.getUid()).child("online").onDisconnect().setValue(false);
            databaseReference.child("Students").child(user.getUid()).child("lastseen").setValue(ServerValue.TIMESTAMP);
        }
    }
}
