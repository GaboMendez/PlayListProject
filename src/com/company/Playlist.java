package com.company;
import java.util.ArrayList;

/**
 * Created by Eduardo on 17/06/02.
 */
public class Playlist
{
    public static int contador = 0;
    public String nombre;
    public int ID;
    public ArrayList<Integer> Canciones = new ArrayList<>();

    public Playlist(){
        this.ID = contador++;
    }

    public String paraElArchivo()
    {
        return ID + "|" + nombre;
    }
    public String paraElOtroArchivo(){
        return Integer.toString(ID) + "|";
    }




}
