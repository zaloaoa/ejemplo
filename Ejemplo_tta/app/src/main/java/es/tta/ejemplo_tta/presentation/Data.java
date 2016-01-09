package es.tta.ejemplo_tta.presentation;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import es.tta.ejemplo_tta.model.Exercise;
import es.tta.ejemplo_tta.model.Test;

/**
 * Created by Usuario on 17/12/2015.
 */

//comunicarte con el servidor, tendrá los datos (los testes)
public class Data {

    private final static String EXTRA_DNI="es.tta.ejemplo_tta.dni";//el dni:12345678A
    private final static String EXTRA_PASWW = "es.tta.ejemplo_tta.auth";//el password que es tta
    private final static String EXTRA_NAME = "es.tta.ejemplo_tta.name";
    private final static String EXTRA_EXERCISE_ID = "es.tta.ejemplo_tta.exerciseid";
    private final static String EXTRA_EXERCISE_WORDING = "es.tta.ejemplo_tta.exerciseWording";
    private final static String EXTRA_TEST="es.tta.ejemplo_tta.test";
    private final static String EXTRA_USER = "es.tta.ejemplo_tta.user";

    private int nextText;
    private int nextExercise;
    private final Bundle bundle;

    public int getNextExercise() {
        return nextExercise;
    }

    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

    public int getNextText() {
        return nextText;
    }

    public void setNextText(int nextText) {
        this.nextText = nextText;
    }





    public Data(Bundle bundle) {

        if(bundle ==null)
            bundle = new Bundle();

        this.bundle = bundle;
    }

    public void putExtraDni(String dni){

        bundle.putString(EXTRA_DNI,dni);
    }

    public String getExtraDni(){
        return bundle.getString(EXTRA_DNI);
    }

    public void putExtraPasww(String auth) {

        bundle.putString(EXTRA_PASWW, auth);
    }



    public String getExtraPasww() {

        return bundle.getString(EXTRA_PASWW);
    }



    public Bundle getBundle() {
        return bundle;
    }

    public void putUserId(int id) {

        bundle.putInt(EXTRA_USER, id);
    }

    public int getUserId() {
        return bundle.getInt(EXTRA_USER);
    }



    public void putUserName(String name) {

        bundle.getString(EXTRA_NAME,name);
    }




    public void putExercise( Exercise exercise){

        bundle.putInt(EXTRA_EXERCISE_ID, exercise.getId());
        bundle.putString(EXTRA_EXERCISE_WORDING, exercise.getWording());

    }

    public Exercise getExercise(){

        Exercise exercise= new Exercise();
        exercise.setId(bundle.getInt(EXTRA_EXERCISE_ID));
        exercise.setWording(bundle.getString(EXTRA_EXERCISE_WORDING));
        return exercise;
    }


    public Test getTest(){

        try{

            Test test= new Test();
            JSONObject json= new JSONObject(bundle.getString(EXTRA_TEST));
            test.setWording(json.getString("wording"));
            JSONArray array= json.getJSONArray("choices");
            for(int i=0; i<array.length();i++){
                JSONObject item= array.getJSONObject(i);
                Test.Choice choice= new Test.Choice();
                choice.setId(item.getInt("id"));
                choice.setAnswer(item.getString("answer"));
                choice.setCorrect(item.getBoolean("correct"));
                choice.setAdvise(item.optString("advise", null));
                choice.setMime(item.optString("mime", null));
                test.getChoices().add(choice);
            }

            return test;
        }catch (JSONException e){
            return null;
        }


    }
    public void putTest(Test test)  {

        try {
            JSONObject json = new JSONObject();
            json.put("wording", test.getWording());
            JSONArray array = new JSONArray();
            for (Test.Choice choice : test.getChoices()) {

                JSONObject item = new JSONObject();
                item.put("id", choice.getId());
                item.put("answer", choice.getAnswer());
                item.put("correct", choice.isCorrect());
                item.put("advise", choice.getAdvise());
                item.put("mime", choice.getMime());
                array.put(item);

            }

            json.put("choices", array);
            bundle.putString(EXTRA_TEST, json.toString());

        }catch (JSONException e){
            e.printStackTrace();
        }


    }

}
