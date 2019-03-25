package com.company;
import TextfileTests.ReadFile;
import TextfileTests.WriteFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



public class Main
{
    public static HashMap<Integer,Cancion> Master  = new HashMap<>();
    public static HashMap<Integer, Playlist> PlaylistList = new HashMap<>();
    public static Scanner reader = new Scanner(System.in);

    static void Menu()
    {
        System.out.println("1. Ver lista master");
        System.out.println("2. Ver lista de playlists");
        System.out.println("3. Agregar cancion");
        System.out.println("4. Borrar cancion");
        System.out.println("5. Editar cancion");
        System.out.println("6. Crear playlist");
        System.out.println("7. Borrar playlist");
        System.out.println("8. Salir");
    }

    static void espacios()
    {
        System.out.print("\n \n \n");
    }
    static void imprimirMaster()
    {
        if (!Master.isEmpty())
        {
            for(Cancion imprimir: Master.values())
            {
                System.out.println(imprimir);
            }
        } else {

            System.out.println("La lista master se encuentra vacia");
        }

    }
    static void crearCancion()
    {

        Cancion nueva = new Cancion();

        System.out.print("Escriba el nombre de la cancion: ");
        nueva.titulo = reader.nextLine();

        System.out.print("Escriba el nombre del artista: ");
        nueva.artista = reader.nextLine();

        System.out.print("Escriba el genero de la cancion: ");
        nueva.genero = reader.nextLine();

        System.out.print("Escribe la duracion de la cancion: ");
        nueva.duracion = reader.nextLine();

        Master.put(nueva.ID, nueva);
    }
    static int validarEntero()
    {
        String entrada;
        while (true)
        {
            entrada = reader.nextLine();
            try
            {
                Integer.parseInt(entrada);
                break;
            }catch(Exception e ){
                System.out.println("Su entrada fue invalida, intentelo de nuevo");
            }
        }

        return Integer.valueOf(entrada);


    }
    static void borrarCancion()
    {
        if (!Master.isEmpty())
        {
            System.out.println("Ingrese el ID de la cancion que desea borrar");
            int opcion = validarEntero();

            if (Master.containsKey(opcion))
            {
                System.out.println(Master.get(opcion).titulo + " fue borrada exitosamente");
                Master.remove(opcion);
            } else {
                System.out.println("Entrada invalida");
            }
        } else {
            //System.out.println("La lista master está vacia");
        }

    }
    static void pulseParaContinuar()
    {
        System.out.println("Pulse una tecla para continuar");
        reader.nextLine();
    }
    static void menuEdicion(int id)
    {
        System.out.println("Qué desea editar de la cancion " + Master.get(id));

        System.out.println("1. Nombre");
        System.out.println("2. Artista");
        System.out.println("3. Genero");
        System.out.println("4. Duracion");
        System.out.println("5. Terminar la edicion");
    }
    static void crearPlaylist()
    {
        Playlist nueva = new Playlist();

        System.out.println("Introduzca el nombre del playlist");
        nueva.nombre = reader.nextLine();

        if (!Master.isEmpty())
        {

            System.out.println("Lista de canciones----------");
            imprimirMaster();

            while (true)
            {
                System.out.print("Agregue una cancion escribiendo el id, o termine el proceso escribiendo -1 :");
                int idcancion = validarEntero();

                if (idcancion == -1){
                    //proceso terminado
                    break;
                }

                if (Master.containsKey(idcancion))
                {
                    nueva.Canciones.add(idcancion);
                    System.out.println(Master.get(idcancion).titulo + " agregada.");
                } else {
                    System.out.println("Entrada invalida, introduzca de nuevo el ID");
                }

            }
        }

        PlaylistList.put(nueva.ID, nueva);
        System.out.println("Exito");
    }
    static void editarCancion()
    {

        if (!Master.isEmpty())
        {
            System.out.println("Introduzca el ID de la cancion a editar: ");
            int opcion = validarEntero();

            if (Master.containsKey(opcion))
            {
                boolean loop = true;
                while (loop)
                {
                    menuEdicion(opcion);
                    int opcion2 = validarEntero();

                    switch (opcion2)
                    {
                        case 1:
                            System.out.print ("Introduzca el nuevo nombre: ");
                            Master.get(opcion).titulo = reader.nextLine();
                            break;

                        case 2:
                            System.out.print ("Introduzca el nuevo artista: ");
                            Master.get(opcion).artista = reader.nextLine();
                            break;

                        case 3:
                            System.out.print("Introduzca el nuevo genero: ");
                            Master.get(opcion).genero = reader.nextLine();
                            break;

                        case 4:
                            System.out.print("Introduzca la nueva duracion: ");
                            Master.get(opcion).duracion = reader.nextLine();
                            break;

                        case 5:
                            System.out.println("Cancion editada exitosamente");
                            loop = false;
                            break;

                        default:
                            System.out.println("Entrada incorrecta");
                            break;
                    }
                }





            } else {
                System.out.println("el ID elegido no está en la lista");
            }

        } else {
            //System.out.println("La lista master está vacia");
        }
    }
    static void imprimirPlaylistList()
    {
        if (!PlaylistList.isEmpty())
        {
            for (Playlist imprimir : PlaylistList.values())
            {
                System.out.println("Playlist #" + imprimir.ID + ": " + imprimir.nombre);

                for (int imprimir2 : imprimir.Canciones)
                {
                    System.out.println("\t " + Master.get(imprimir2).toString() );
                }
                System.out.println("");
            }
        } else {
            System.out.println("No hay playlists creados");
        }
    }
    static void borrarPlaylist()
    {
        if (!PlaylistList.isEmpty())
        {
            boolean error = true;
            do {

                System.out.println("Ingrese el indice del playlist que desea borrar");
                int opcion = validarEntero();

                try {
                    System.out.println(PlaylistList.get(opcion).nombre + " fue borrada exitosamente");
                    PlaylistList.remove(opcion);
                    error = false;

                } catch (Exception e) {
                    System.out.println("Entrada invalida de ID");
                }

            } while (error);

        } else
             {
               // System.out.println("No se han agregado playlists");
             }
    }
    static void imprimirPlayListIndividual(int indice)
    {
        System.out.println(PlaylistList.get(indice).nombre);

        for (int imprimir2 : PlaylistList.get(indice).Canciones)
        {
            System.out.println("\t " + Master.get(imprimir2).toString() );
        }
        System.out.println("");
    }

    static void muenuEdicionPlaylist(int indice)
    {

            System.out.println("Qué desea hacer con el playlist " + PlaylistList.get(indice).nombre + "?");
            System.out.println("1. Agregarle canciones");
            System.out.println("2. Borrarle canciones");
            System.out.println("3. Cambiarle el nombre");
            System.out.println("4. Volver al menu");


    }

    static void editarPlaylist()
    {
        if (!PlaylistList.isEmpty())
        {
            while (true)
            {
                imprimirPlaylistList();

                System.out.print("Si desea actuar sobre alguno de los playlist," +
                        " inserte su ID. Para volver al menu, escriba -1");

                int opcion = validarEntero();

                if (opcion == -1)
                {
                    break;
                }

                if (!PlaylistList.containsKey(opcion))
                {
                    System.out.println("Usted acaba de introducir un ID incorrecto");

                } else {
                    System.out.println("\n");

                    imprimirPlayListIndividual(opcion);
                    muenuEdicionPlaylist(opcion);

                    int opcion2 = validarEntero();
                    switch (opcion2)
                    {
                        case 1:
                            System.out.println("Lista de canciones----------");
                            imprimirMaster();

                            while (true)
                            {
                                System.out.print("Agregue una cancion escribiendo el id, o termine el proceso escribiendo -1 :");
                                int idcancion = validarEntero();

                                if (idcancion == -1){
                                    //Proceso terminado
                                    break;
                                }

                                if (Master.containsKey(idcancion))
                                {
                                    PlaylistList.get(opcion).Canciones.add(idcancion);
                                    System.out.println(Master.get(idcancion).titulo + " agregada.");
                                } else {
                                    System.out.println("Entrada invalida, introduzca de nuevo el ID");
                                }

                            }

                            break;

                        case 2:

                            while (true) {
                                System.out.print("Elimine una cancion del playlist escribiendo el id," +
                                        " o termine el proceso escribiendo -1 :");
                                int idcancion = validarEntero();

                                if (idcancion == -1) {
                                    //Proceso terminado
                                    break;
                                }

                                if (PlaylistList.get(opcion).Canciones.contains(idcancion)) {
                                    System.out.println(Master.get(idcancion).titulo + " eliminado del playlist.");
                                    PlaylistList.get(opcion).Canciones.remove(  PlaylistList.get(opcion).Canciones.indexOf(idcancion) );

                                } else {
                                    System.out.println("Entrada invalida, introduzca de nuevo el ID");
                                }
                            }

                            break;
                        case 3:
                            System.out.println("Introduzca el nuevo nombre: ");
                            PlaylistList.get(opcion).nombre = reader.nextLine();
                            break;
                        case 4:
                           pulseParaContinuar();
                            break;

                        default:
                            System.out.println("Su entrada es invalida para el menu");
                            break;
                    }

                    System.out.print("\n");


                }
            }
        } else
        {
            System.out.println("No se han creado playlists");
        }
    }

    static void actualizarArchivoCancion() throws IOException
    {
        if (!Master.isEmpty())
        {
            String destino = "Canciones.txt";
            WriteFile Canciones = new WriteFile(destino);
            Canciones.createFile();

            int i = 0;
            String[] infoCanciones = new String[Master.size()];

            for(Cancion imprimir : Master.values())
            {
                infoCanciones[i] = imprimir.paraElArchivo();
                i++;
            }

            Canciones.WriteFIle(infoCanciones);
        }
        else {
            String destino = "Canciones.txt";
            WriteFile Canciones = new WriteFile(destino);
            Canciones.createFile();

            String[] nulo = null;
            Canciones.WriteFIle(nulo);
        }

    }

    static void leerArchivoCancion() throws IOException
    {
        String fuente = "Canciones.txt";

        ReadFile Canciones = new ReadFile(fuente);
        String[] lecturaCanciones = Canciones.OpenFile();

        String[][] ArchivoCanciones = new String[ lecturaCanciones.length   ][];

        for (int i = 0; i < lecturaCanciones.length; i++)
        {
            ArchivoCanciones[i] = lecturaCanciones[i].split("\\|");

        }

        for (int i = 0; i < lecturaCanciones.length ; i++)
        {
            Cancion nueva = new Cancion();

            nueva.ID       =  Integer.valueOf(ArchivoCanciones[i][0]);
            nueva.artista  =  ArchivoCanciones[i][1];
            nueva.titulo   =  ArchivoCanciones[i][2];
            nueva.genero   =  ArchivoCanciones[i][3];
            nueva.duracion =  ArchivoCanciones[i][4];

            Master.put(nueva.ID, nueva);

        }
    }

    static void leerArchivoListas() throws IOException
    {
        String fuente = "Listas Canciones.txt";

        ReadFile ListaCanciones = new ReadFile(fuente);
        String[] lecturaListas = ListaCanciones.OpenFile();

        String[][] ArchivoListas = new String[ lecturaListas.length   ][];

        for (int i = 0; i < lecturaListas.length; i++)
        {
            ArchivoListas[i] = lecturaListas[i].split("\\|");

        }

        for (int i = 0; i < lecturaListas.length ; i++)
        {
            Playlist nueva = new Playlist();

            nueva.ID       =  Integer.valueOf(ArchivoListas[i][0]);
            nueva.nombre  =  ArchivoListas[i][1];


            PlaylistList.put(nueva.ID, nueva);

        }
    }
    static void actualizarArchivoListas() throws IOException
    {
        if (!PlaylistList.isEmpty())
        {
            String destino = "Listas Canciones.txt";
            WriteFile ListasCanciones = new WriteFile(destino);
            ListasCanciones.createFile();

            int i = 0;
            String[] infoListas = new String[PlaylistList.size()];

            for(Playlist imprimir : PlaylistList.values())
            {
                infoListas[i] = imprimir.paraElArchivo();
                i++;
            }

            ListasCanciones.WriteFIle(infoListas);
        }
        else{
            String destino = "Listas Canciones.txt";
            WriteFile ListaCanciones = new WriteFile(destino);
            ListaCanciones.createFile();

            String[] nulo = null;
            ListaCanciones.WriteFIle(nulo);
        }

    }
    static void crearArchivoListaCancion() throws IOException {
        if(!PlaylistList.isEmpty()) {
            String destino = "Detalle Lista Cancion.txt";

            boolean existe = false;

            WriteFile detalleListas = new WriteFile(destino);
            detalleListas.createFile();
            String dato;
            int i = 0;
            for (Playlist imprimir : PlaylistList.values()) {
                dato = imprimir.paraElOtroArchivo();

                    for(int id : imprimir.Canciones){
                        if(i>=1) existe = true;
                        detalleListas.WriteFIle(dato+Integer.toString(id),existe);
                        i++;
                    }



            }
        }
    }
    static void leerArchivoListaCancion() throws IOException {
        String fuente = "Detalle Lista Cancion.txt";
        ReadFile ListaCanciones = new ReadFile(fuente);
        String[] lecturaListas = ListaCanciones.OpenFile();
        String[][] ArchivoListas = new String[ lecturaListas.length   ][];

        for (int i = 0; i < lecturaListas.length; i++)
        {
            ArchivoListas[i] = lecturaListas[i].split("\\|");

        }
        int i = 0;
        for(Playlist playlist : PlaylistList.values()) {
            for (String[] a : ArchivoListas) {
                if (playlist.ID == Integer.parseInt(a[0])) {
                    playlist.Canciones.add(Integer.parseInt(a[1]));
                }
            }
        }
    }
    /////////
    static void crearArchivoListaCancionCSV() throws IOException {
        if(!PlaylistList.isEmpty()) {
            FileWriter Archivo = new FileWriter("Lista de Canciones.csv");
            Archivo.write("Lista Master:\n");
            Archivo.write("ID:,Artista,Nombre,Genero,Duracion\n");
            for(Cancion imprimir : Master.values())
            {
                Archivo.write(imprimir.paraElArchivoCSV() + "\n");
            }
            Archivo.write("\n\n\n");
            for (Playlist imprimir : PlaylistList.values())
            {
                Archivo.write("Playlist #" + imprimir.ID + ": " + imprimir.nombre + "\n");
                Archivo.write("ID:,Artista,Nombre,Genero,Duracion\n");
                for (int imprimir2 : imprimir.Canciones)
                {
                    Archivo.write("\t " + Master.get(imprimir2).paraElArchivoCSV() + "\n" );
                }
                Archivo.write("\n");
            }

            Archivo.close();

            }
        else{
            String destino = "Lista de Canciones.csv";
            WriteFile ListaCanciones = new WriteFile(destino);
            ListaCanciones.createFile();

            String[] nulo = null;
            ListaCanciones.WriteFIle(nulo);
        }

    }

    /////////
    public static void main(String[] args)
    {
        try
        {
            leerArchivoCancion();
            leerArchivoListas();
            leerArchivoListaCancion();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        boolean loop = true;

        while (loop)
        {
            Menu();

            int seleccion = validarEntero();

            switch (seleccion) {
                case 1:
                    espacios();
                    imprimirMaster();
                    pulseParaContinuar();
                    break;

                case 2:
                    espacios();
                    editarPlaylist();
                    pulseParaContinuar();
                    break;

                case 3:
                    espacios();
                    crearCancion();
                    pulseParaContinuar();
                    break;

                case 4:
                    espacios();
                    imprimirMaster();
                    borrarCancion();
                    pulseParaContinuar();
                    break;

                case 5:
                    espacios();
                    imprimirMaster();
                    editarCancion();
                    pulseParaContinuar();
                    break;

                case 6:
                    espacios();
                    crearPlaylist();
                    pulseParaContinuar();
                    break;

                case 7:
                    espacios();
                    imprimirPlaylistList();
                    borrarPlaylist();
                    pulseParaContinuar();
                    break;

                case 8:
                    loop = false;
                    break;

                default:
                    System.out.println("Entrada incorrecta");
                    break;

            }


        }
        try {
            actualizarArchivoCancion();
            actualizarArchivoListas();
            crearArchivoListaCancion();
            crearArchivoListaCancionCSV();
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }

        espacios();
    }

}
