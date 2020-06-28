package com.projet.programmationenc;

import android.app.Application;
import android.content.Context;

public class GetTimeAgo extends Application {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;


    public static String getTimeAgo(long time, Context ctx) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = System.currentTimeMillis();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "juste maintenant";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "il y a une minute";
        } else if (diff < 50 * MINUTE_MILLIS) {
            if(diff / MINUTE_MILLIS == 1) {
                return "il y a une minute";
            }
            return "il y a " + diff / MINUTE_MILLIS + " minutes";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "il y a une heure";
        } else if (diff < 24 * HOUR_MILLIS) {
            if(diff / HOUR_MILLIS == 1) {
                return "il y a une heure";
            }
            return "il y a " + diff / HOUR_MILLIS + " heures";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "hier";
        } else {
            return diff / DAY_MILLIS + " il y a quelques jours";
        }
    }

}
