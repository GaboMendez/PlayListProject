package TextfileTests;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by Eduardo on 17/06/15.
 */
public class WriteFile {

    String path;
    private boolean append_to_file = false;
    public WriteFile(String file_path)
    {
        this.path = file_path;
    }

    public WriteFile(String path, boolean append_to_file) {
        this.path = path;
        this.append_to_file = append_to_file;
    }

    public void createFile() throws IOException
    {
        File newfile = new File(path);
        newfile.createNewFile();

    }

    public void WriteFIle(String[] datos) throws IOException
    {
        FileWriter fw = new FileWriter(path,append_to_file);
        BufferedWriter textWriter = new BufferedWriter(fw);

        for (int i = 0; i < datos.length; i++)
        {
            textWriter.write(datos[i] + "\r\n");
        }
        textWriter.close();

    }
    public void WriteFIle(String dato,boolean append_to_file) throws IOException
    {
        FileWriter fw = new FileWriter(path,append_to_file);
        BufferedWriter textWriter = new BufferedWriter(fw);
        textWriter.write(dato + "\r\n");
        textWriter.close();
    }
}
