package es.tta.ejemplo_tta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void subir_fichero(View view){
        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();

    }
    public void sacar_foto(View view){
        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();

    }
    public void grabar_audio(View view){
        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();

    }
    public void grabar_video(View view){

        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();
    }


}
