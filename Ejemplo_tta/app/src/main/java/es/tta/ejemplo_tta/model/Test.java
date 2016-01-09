package es.tta.ejemplo_tta.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Usuario on 17/12/2015.
 */
public class Test {

    private String wording;
    private ArrayList choices= new ArrayList<Choice>();
    static public final String VIDEO = "audio/mpeg";
    static public final String HTML = "text/html";
    static public final String AUDIO = "video/mp4";


    public Test(){

    }

    public String getWording(){

        return wording;
    }

    public void setWording(String wording){

        this.wording=wording;
    }


    public ArrayList<Choice> getChoices(){
        return choices;
    }

    public Choice getChoice(int i){

        return (Choice) choices.get(i);
    }

    public void setChoices(ArrayList choices) {
        this.choices = choices;
    }



    public static class Choice{

        private int id;
        private String advise;
        private String answer;
        private boolean correct;
        private String mime;



        public Choice(){}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAdvise() {
            return advise;
        }

        public void setAdvise(String advise) {
            this.advise = advise;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public boolean isCorrect() {
            return correct;
        }

        public void setCorrect(boolean correct) {
            this.correct = correct;
        }

        public String getMime() {
            return mime;
        }

        public void setMime(String mime) {
            this.mime = mime;
        }


    }






}
