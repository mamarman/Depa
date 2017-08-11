package com.mamarman.depa.fragment;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.net.ConnectivityManager;

/**
 * Created by Malic on 8/11/2017.
 */

public class DetectConnection  {

    public static boolean chackInternetConnettion(Context context){
        ConnectivityManager conManagen = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conManagen.getActiveNetworkInfo() != null &&
                conManagen.getActiveNetworkInfo().isAvailable()&&
                conManagen.getActiveNetworkInfo().isConnected()){
            return true;
        }
        else {
            return false;
        }

    }


}
