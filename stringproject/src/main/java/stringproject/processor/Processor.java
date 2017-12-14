package stringproject.processor;

import stringproject.data.Letter;
import stringproject.data.Word;
import stringproject.dataexceptions.NotALetterException;
import stringproject.dataexceptions.NotAWordException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Processor {
    public static Word processWord(Word toProcess){
        ArrayList<Integer>toRemove = new ArrayList<>();
        Letter firstLetter = toProcess.getLetters().get(0);
        for(int i=1;i<toProcess.getLetters().size();i++){
            if(toProcess.getLetters().get(i).equals(firstLetter)){
                toRemove.add(i);
            }
        }
        for(int i=toRemove.size()-1;i>=0;i--){
            toProcess.getLetters().remove(toRemove.get(i).intValue());
        }
        return toProcess;
    }

    public static String processString(String text){
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            word = word.trim();
            ArrayList<Letter> letters = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                try {
                    letters.add(new Letter(word.charAt(i)));
                } catch (NotALetterException e) {
                    //sb.append(word.charAt(i));
                }
            }
            Word newWord = null;
            try {
                newWord = processWord(new Word(letters));
            } catch (NotAWordException e) {
                System.out.println("Not A Word exception caught");
            }
            if(newWord!=null){
                sb.append(newWord);
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
