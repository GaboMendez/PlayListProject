package TextfileTests;
import java.io.IOException;

/**
 * Created by Eduardo on 17/06/15.
 */
public class FileData {

    public static void main(String[] args) throws IOException
    {

        String file_name  = "ArchivoCread.txt";
        String file_name2 = "ArchivoCread.txt";

        try
        {
            ReadFile file = new ReadFile(file_name);
            String[] lectura = file.OpenFile();

            for (int i = 0; i < lectura.length ; i++)
            {
                System.out.println(lectura[i]);
            }


            WriteFile escritura = new WriteFile(file_name2);
            escritura.createFile();

            String[] aver = new String[3];
            aver[0] = "Primera linea";
            aver[1] = "segunda linea";
            aver[2] = "Tercera linea";

            escritura.WriteFIle(aver);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
