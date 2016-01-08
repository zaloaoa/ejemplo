package es.tta.ejemplo_tta;

import java.io.Serializable;

/**
 * Created by Usuario on 17/12/2015.
 */
public class Test implements Serializable {

//codigo para saber que tipo de consejo:
    static public final short ADVISE_HTML = 0;
    static public final short ADVISE_VIDEO = 1;
    static public final short ADVISE_AUDIO = 2;
//sus atributos:
    private String wording;
    private Choice[] choices;//tiene las opciones y si son correctas  o no
    private String advise;
    private short adviseType;
//constructor
    public Test(String Wording,String [] choicesWording,boolean [] choicesCorrect, String Advise, short Type){
        wording = Wording;
        advise = Advise;
        adviseType = Type;
        if(choicesWording.length == choicesCorrect.length){
            choices = new Choice[choicesCorrect.length];
            int i = 0;
            //rellena las opciones y si es corecto o no:
            for(String choice : choicesWording){
                choices[i] = new Choice(choice,choicesCorrect[i]);
                i++;
            }
        }
    }

    public String getWording(){
        return wording;
    }

    public Choice[] getChoices(){
        return choices;
    }

    public String getAdvice(){
        return advise;
    }

    public short getAdviseType(){
        return adviseType;
    }


    public class Choice implements Serializable{

        private String wording;
        private boolean correct;

        public Choice(String Swording, boolean Correct){
            wording=Swording;
            correct=Correct;
        }

        public String getWording(){ return wording;  }

        public boolean isCorrect(){
            return correct;
        }
    }

}
