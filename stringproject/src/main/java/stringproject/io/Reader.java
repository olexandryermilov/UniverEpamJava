package stringproject.io;

import stringproject.data.Letter;
import stringproject.data.Word;
import stringproject.dataexceptions.NotALetterException;
import stringproject.dataexceptions.NotAWordException;
import stringproject.processor.Processor;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    private BufferedReader reader;
    public Reader(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }
    public String readAll() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            sb.append(line+"\n");
        }
        return sb.toString();
    }
}
