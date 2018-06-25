package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public class NetworkUtils {

    public static NetworkInfo getNetworkInfo(final Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static boolean isConnected(final Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected());
    }

}

