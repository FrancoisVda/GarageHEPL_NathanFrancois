package MyVariousUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLog
{
    String _fileName;

    public FileLog(String fileName)
    {
        _fileName = fileName;
    }

    public void writeLine(String line)
    {
        try
        {
            FileWriter f = new FileWriter(_fileName, true);
            BufferedWriter bf = new BufferedWriter(f);
            bf.write("[" + new Date() + "] : " + line);
            bf.newLine();
            bf.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void writeLine(String header, String info)
    {
        writeLine(header + "> " + info);
    }
}