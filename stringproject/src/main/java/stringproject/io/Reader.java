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
            String[] words = line.split(" ");
            for(String word : words){
                word = word.trim();
                ArrayList<Letter>letters= new ArrayList<Letter>();
                for(int i=0;i<word.length();i++){
                    try{
                        letters.add(new Letter(word.charAt(i)));
                    } catch (NotALetterException e) {
                        e.printStackTrace();
                    }
                }
                Word newWord=null;
                try {

                    newWord = new Word(letters);
                } catch (NotAWordException e) {
                    e.printStackTrace();
                }
                assert newWord!=null;
                newWord = Processor.processor(newWord);
                if(newWord!=null) {
                    sb.append(newWord.toString()).append(" ");
                }
            }
        }
        return sb.toString();
    }
}
