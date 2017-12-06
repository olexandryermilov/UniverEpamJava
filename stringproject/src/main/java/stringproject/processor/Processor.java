package stringproject.processor;

import stringproject.data.Letter;
import stringproject.data.Word;

import java.util.ArrayList;

public class Processor {
    public static Word processor(Word toProcess){
        ArrayList<Integer>toRemove = new ArrayList<Integer>();
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
}
