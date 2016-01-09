package es.tta.ejemplo_tta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Usuario on 09/01/2016.
 */
public class NetworkReceiver extends BroadcastReceiver {
    //método para hacer lo que quieras cuando te quedas sin red
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conn = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
    }
}
