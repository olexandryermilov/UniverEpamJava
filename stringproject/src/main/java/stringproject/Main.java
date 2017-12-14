package stringproject;

import stringproject.io.Reader;
import stringproject.io.Writer;
import stringproject.processor.Processor;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            Writer.write(Processor.processString(new Reader(new File("text.txt")).readAll()));
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
