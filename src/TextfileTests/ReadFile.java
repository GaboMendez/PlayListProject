package TextfileTests;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * Created by Eduardo on 17/06/15.
 */
public class ReadFile {

    public String path;

    public ReadFile(String file_path)
    {
        this.path = file_path;
    }

    public int readLines() throws  IOException
    {
        FileReader fileToRead = new FileReader(path);
        BufferedReader bf = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;

        while ( ( aLine = bf.readLine() ) != null)
        {
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;

    }

    public String[] OpenFile() throws  IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader textreader = new BufferedReader(fr);
        int numberOfLines = readLines();

        String[] textData = new String[numberOfLines];

        for (int i = 0; i < numberOfLines ; i++)
        {
            textData[i] = textreader.readLine();
        }

        textreader.close();
        return textData;
    }



}
