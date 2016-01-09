package es.tta.ejemplo_tta.presentation;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Usuario on 09/01/2016.
 */
public class Preferences {
    private SharedPreferences prefs;
    public final static String EXTRA_PREFERENCIAS="es.tta.ejemplo_tta.preferences";

    public Preferences(Context context){

        prefs=context.getSharedPreferences(EXTRA_PREFERENCIAS, context.MODE_PRIVATE);

    }

    public void saveLogin(String login){

        SharedPreferences.Editor editor;
        editor = prefs.edit();
        editor.putString(EXTRA_PREFERENCIAS,login);
        editor.commit();
    }

    public  String loadLogin() {

        return prefs.getString(EXTRA_PREFERENCIAS, null);

    }

}
