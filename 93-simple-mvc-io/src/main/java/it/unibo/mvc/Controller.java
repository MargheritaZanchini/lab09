package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final String defaultFile = "output.txt";
    
    private File f = new File(System.getProperty("user.home")+System.getProperty(File.separator)+defaultFile);

    public void setFile(final String fileName){
        f = new File(fileName);
    }

    public File getFile(){
        return f;
    }

    public String getPath(){
        return f.getPath();
    }

    public void writeOnFile(final String s) throws IOException{
        PrintStream ps = new PrintStream(f, StandardCharsets.UTF_8);
        ps.println(s);
    }

}
