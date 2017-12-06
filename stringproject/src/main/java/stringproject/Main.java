package stringproject;

import stringproject.io.Reader;
import stringproject.io.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            Writer.write(new Reader(new File("text.txt")).readAll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
