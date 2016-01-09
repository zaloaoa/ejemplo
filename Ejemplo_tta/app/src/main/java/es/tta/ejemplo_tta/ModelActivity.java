package es.tta.ejemplo_tta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.tta.ejemplo_tta.model.Business;
import es.tta.ejemplo_tta.presentation.Data;
import es.tta.ejemplo_tta.presentation.Preferences;
import es.tta.ejemplo_tta.proof.comms.RestClient;

public abstract class ModelActivity extends AppCompatActivity {
//es la clase madre de la que extienden todas las actividades
    public static final String URL="http://u017633.ehu.eus:18080/AlumnoTta/rest/tta";
    protected RestClient rest;
    protected Business server;
    protected Preferences prefs;
    protected Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new Data(getIntent().getExtras());//coge los datos
        rest= new RestClient(URL);

        String auth= data.getExtraPasww();
        if(auth !=null) {
            rest.setAuthorization(auth);
            rest.setHttpBasicAuth(data.getExtraDni(),data.getExtraPasww());
        }
        server= new Business(rest);
        prefs= new Preferences(this);


    }

    protected <T> void startModelActivity(Class<T> cls){
        Intent intent= newIntent(cls);
        startActivity(intent);
    }


    protected <T> Intent newIntent(Class<T> cls){

        Intent intent= new Intent(getApplicationContext(),cls);
        intent.putExtras(data.getBundle());//metes los datos de la actividad para propagar los datos a la siguiente actividad
        return intent;
    }


}
