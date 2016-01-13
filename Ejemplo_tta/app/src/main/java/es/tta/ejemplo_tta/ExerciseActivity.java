package es.tta.ejemplo_tta;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import es.tta.ejemplo_tta.model.Exercise;

public class ExerciseActivity extends ModelActivity  {

    private Uri pictureURI;
    final private int READ_REQUEST_CODE=0;
    final private int VIDEO_REQUEST_CODE=1;
    final private int AUDIO_REQUEST_CODE=2;
    final private int PICTURE_REQUEST_CODE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Exercise exercise= data.getExercise();

        TextView textExercise = (TextView) findViewById(R.id.exercise_wording);
        textExercise.setText(exercise.getWording());



    }

    public void sendFile(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent,READ_REQUEST_CODE);
    }

    public void sendFoto(View view){

        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))

            Toast.makeText(getApplicationContext(),R.string.nohaycamara,Toast.LENGTH_SHORT).show();
        else{

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null){
                /*Hay aplicación para capturar imagen*/
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try {
                    File file = File.createTempFile("tta", ".jpg", dir);
                    pictureURI = Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureURI);
                    startActivityForResult(intent,PICTURE_REQUEST_CODE);
                }catch (IOException e){}
            }else{
                /*No hay aplicación para capturar imagen*/
                Toast.makeText(getApplicationContext(),R.string.nohayapp,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sendAudio(View view){
        //si no hay microfono
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(getApplicationContext(),R.string.nohaymicro,Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if(intent.resolveActivity(getPackageManager()) != null)
                /*se comienza a grabar*/
                startActivityForResult(intent,AUDIO_REQUEST_CODE);
            else
                //no hay aplicacion para grabar el audio
                Toast.makeText(getApplicationContext(),R.string.nohayapp,Toast.LENGTH_SHORT).show();
        }
    }

    public void sendVideo(View view){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            /*No hay camara en el dispositivo*/
            Toast.makeText(getApplicationContext(),R.string.nohaycamara,Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            //se comprueba si hay camara
            if(intent.resolveActivity(getPackageManager()) != null)
                //se graba
                startActivityForResult(intent,VIDEO_REQUEST_CODE);
            else
                //no hay ninguna app para grbar
                Toast.makeText(getApplicationContext(),R.string.nohayapp,Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if(resultcode != Activity.RESULT_OK)
            return;
        switch(requestCode){
            case READ_REQUEST_CODE:
                sendFile(data.getData());
                break;
            case VIDEO_REQUEST_CODE:
                sendFile(data.getData());
                break;
            case AUDIO_REQUEST_CODE:
                sendFile(data.getData());
                break;
            case PICTURE_REQUEST_CODE:
                sendFile(pictureURI);
                break;
        }
    }

    private void sendFile(Uri uri){
        Toast.makeText(getApplicationContext(),R.string.enviarelfichero,Toast.LENGTH_SHORT).show();
    }




}
