package es.tta.ejemplo_tta;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;




public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private int correct;
    private String advise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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
        Data data = new Data();
        Test test = data.getTest();//devuelve el enunciado, las opciones y si son correctas o no

        TextView textwording = (TextView) findViewById(R.id.test_wording);//cojo la vista, el enunciado
        textwording.setText(test.getWording());//meto en enunciado

        int i = 0;
        RadioGroup group = (RadioGroup) findViewById(R.id.test_choices);//cojo la view de las opciones

        for (Test.Choice choice : test.getChoices()) {
            //en choice va metiendo cada vez la opcion
            RadioButton radio = new RadioButton(this);//crear radioButton para ir metiendo en radioGroup
            radio.setText(choice.getEnunciado());//consigo el enucnado
            radio.setOnClickListener(this);//le paso la clase, cuando cliko una opcion paso a onclick
            group.addView(radio);//lo añado a la vista radiogroup
            if (choice.isCorrecto()) {
                correct = i;
            }
            i++;
        }

        advise = "el consejo es.....";
    }

        @Override
        public void onClick(View view)
        {
            findViewById(R.id.button_enviar).setVisibility(View.VISIBLE);

        }


        public void send(View view)
        {
            RadioGroup group=(RadioGroup)findViewById(R.id.test_choices);
            findViewById(R.id.button_enviar).setVisibility(View.GONE);
            int choices=group.getChildCount();//el tamaño de las opciones de radiogroup
            for (int i=0;i<choices;i++){
                group.getChildAt(i).setEnabled(false);//que no se puedan clikar

            }

            int selectedid=group.getCheckedRadioButtonId();//conseguir el id del k esta pulsado, para luego conseguir el index
            group.getChildAt(correct).setBackgroundColor(Color.GREEN);//pner a greeen la correcta
            View radiobutton=group.findViewById(selectedid);//cojo la view, del opcion que esta seleccionado
            int selected=group.indexOfChild(radiobutton);//cojo su index

            if(selected!=correct) {
                group.getChildAt(selected).setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(), "Has fallado", Toast.LENGTH_SHORT).show();

                if (advise != null && !advise.isEmpty()) {
                    findViewById(R.id.button_help).setVisibility(View.VISIBLE);
                }
            }
                else{
                    Toast.makeText(getApplicationContext(),"Has acertado",Toast.LENGTH_SHORT).show();
                }
            }

            public void ayuda(View view){
                //le paso la view del boton ayuda
                view.setEnabled(false);
                TextView helpText=(TextView)findViewById(R.id.textoayuda);
                helpText.setText(advise);

                 }




        }








