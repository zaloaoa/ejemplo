package es.tta.ejemplo_tta;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Usuario on 17/12/2015.
 */

//comunicarte con el servidor, tendrá los datos (los testes)
public class Data implements Serializable{
    private int i;
    private int max;

    Test [] test;
    public Data(){
        test = new Test [3];//hay tres teses
        /*test primero*/
        String [] choicesWording = new String[4];//4 opciones
        boolean [] choicesCorrect = new boolean[4];
        choicesWording[0] = "Asteartea";
        choicesCorrect[0] = false;
        choicesWording[1] = "Astelehena";
        choicesCorrect[1] = true;
        choicesWording[2] = "Asteazkena";
        choicesCorrect[2] = false;
        choicesWording[3] = "Osteguna";
        choicesCorrect[3] = false;
        String advise = "<html><body>La opcion correcta es <b>Astelehena</b></body></html>";
        test[0] = new Test("¿Como se dice lunes en euskara?",choicesWording,choicesCorrect,advise,Test.ADVISE_HTML);
        /*test segundo*/
        choicesWording = new String[3];
        choicesCorrect = new boolean[3];
        choicesWording[0] = "Eskailerak igo";
        choicesCorrect[0] = true;
        choicesWording[1] = "eskaierak jaitsi";
        choicesCorrect[1] = false;
        choicesWording[2] = "eskaileretan gelditu";
        choicesCorrect[2] = false;
        advise = "http://51.254.221.215/uploads/subir.mp4";
        test[1] = new Test("¿Como se dice subir escaleras en euskera?",choicesWording,choicesCorrect,advise,Test.ADVISE_VIDEO);
        /*para el tercer test*/
        choicesWording = new String[3];
        choicesCorrect = new boolean[3];
        choicesWording[0] = "A";
        choicesCorrect[0] = true;
        choicesWording[1] = "B";
        choicesCorrect[1] = false;
        choicesWording[2] = "C";
        choicesCorrect[2] = false;
        advise = "http://51.254.221.215/uploads/pr.ogg";
        test[2] = new Test("¿bli bli bli?",choicesWording,choicesCorrect,advise,Test.ADVISE_AUDIO);
        i=0;
        max=3;
    }
    protected Test getTest(){
        if(i==(max-1))
            i=0;
        else
            i++;
        return test[i];
       /* Random rand = new Random();
        int i = rand.nextInt(3);
        return test[i];*/

    }


}
