package com.company;

/**
 * Created by Eduardo on 17/06/02.
 */
public class Cancion
{

    public static int contador = 0;
    public String titulo;
    public String artista;
    public String genero;
    public String duracion;
    public int ID = 0;




   public Cancion() {

        this.ID = contador++;

   }

   public String paraElArchivo()
   {
       return ID + "|" + artista + "|" + titulo + "|" + genero + "|" + duracion;
   }
   public String paraElOtroArchivo(){
       return Integer.toString(ID);
   }
    ////
   public String paraElArchivoCSV()
    {
        return ID + "," + artista + "," + titulo + "," + genero + "," + duracion;
    }
    ////

    @Override
    public String toString()
    {
        return "#" + ID + ". " + titulo + " by " + artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancion cancion = (Cancion) o;

        if (titulo != null ? !titulo.equals(cancion.titulo) : cancion.titulo != null) return false;
        if (artista != null ? !artista.equals(cancion.artista) : cancion.artista != null) return false;
        if (genero != null ? !genero.equals(cancion.genero) : cancion.genero != null) return false;
        return duracion != null ? duracion.equals(cancion.duracion) : cancion.duracion == null;
    }

}

