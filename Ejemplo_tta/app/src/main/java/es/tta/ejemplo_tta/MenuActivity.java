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

import es.tta.ejemplo_tta.presentation.Data;

public class MenuActivity extends AppCompatActivity {
    public final static String EXTRA_EXERCISE = "es.tta.ejemplo_tta.exercise";
    public final static String EXTRA_DATA ="es.tta.ejemplo_tta.data";

    private Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent =getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText(("Bienvenido "+intent.getStringExtra(MainActivity.EXTRA_LOGIN)));
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
        data = new Data();
    }

    public void test(View view){
        Intent intent=new Intent (this, TestActivity.class);
        intent.putExtra(EXTRA_DATA,data);//pasamos el objeto data, k tiene todo
        startActivity(intent);

    }

    public void ejercicio(View view){

        Intent intent=new Intent (this, ExerciseActivity.class);
        intent.putExtra(EXTRA_EXERCISE,"aaaaaaaaaaa");
        startActivity(intent);
    }

    public void seguimiento(View view){
        Toast.makeText(getApplicationContext(), "No hace nada", Toast.LENGTH_SHORT).show();

    }






}
