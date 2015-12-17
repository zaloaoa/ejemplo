package es.tta.ejemplo_tta;

/**
 * Created by Usuario on 17/12/2015.
 */
public class Test {


    public String getWording(){
        String pregunta="¿Cuál de las siguientes opciones NO se indica en el fichero de manifiesto de la app?";
        return pregunta;
    }

    public Choice[]getChoices(){
        Choice[]choices=new Choice[5];
        choices[0]=new Choice ("Versión de aplicación",false);
        choices[1]=new Choice("Listado de componentes de la aplicación",false);
        choices[2]=new Choice ("Opciones del menú de ajustes",true);
        choices[3]=new Choice("Nivel mínimo de la API Android requerida",false);
        choices[4]=new Choice("Nombre del paquete java de la aplicación",false);

        return choices;



    }

    public class Choice{
        private String enunciado;
        private boolean correcto;
        public Choice(String enunciado, boolean correcto){
            this.enunciado=enunciado;
            this.correcto=correcto;

        }

        public String getEnunciado(){
            return enunciado;
        }

        public boolean isCorrecto(){
            return correcto;
        }
    }
}
