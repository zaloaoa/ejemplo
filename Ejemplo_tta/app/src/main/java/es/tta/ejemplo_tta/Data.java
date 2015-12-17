package es.tta.ejemplo_tta;

/**
 * Created by Usuario on 17/12/2015.
 */

//comunicarte con el servidor, tendrá los datos (los testes)
public class Data {
    public Test getTest(){
        return new Test();//devuelve enunciado y opciones
    }
}
