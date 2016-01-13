package es.tta.ejemplo_tta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import es.tta.ejemplo_tta.model.Exercise;
import es.tta.ejemplo_tta.model.Status;
import es.tta.ejemplo_tta.model.Test;
import es.tta.ejemplo_tta.presentation.Data;
import es.tta.ejemplo_tta.proof.view.ProgressTask;

public class MenuActivity extends ModelActivity {
    public final static String EXTRA_EXERCISE = "es.tta.ejemplo_tta.exercise";
    public final static String EXTRA_DATA ="es.tta.ejemplo_tta.data";

   // private Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       // Intent intent =getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText(("Bienvenido " + data.getExtraDni()));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Status user= server.getStatus(data.getExtraDni(),data.getExtraPasww());//se coge el estado del servidor

                    data.putUserId(user.getId());
                    data.putUserName(user.getUser());
                    data.setNextText(user.getNextTest());
                    data.setNextExercise(user.getNextExercise());

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }

    public void test(View view){
        new ProgressTask<Test>(this){


            @Override
            protected Test work() throws Exception {


                return server.getTest(data.getNextText());
            }

            @Override
            protected void onFinish(Test result) {

                data.putTest(result);
                startModelActivity(TestActivity.class);

            }
        }.execute();


    }

    public void ejercicio(View view){
        new ProgressTask<Exercise>(this){


            @Override
            protected Exercise work() throws Exception {
                return server.getExercise(data.getNextExercise());
            }

            @Override
            protected void onFinish(Exercise result) {
                data.putExercise(result);
                startModelActivity(ExerciseActivity.class);

            }
        }.execute();


    }

    public void seguimiento(View view){
        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();

    }






}
