package stringproject.datatest;

import org.junit.Test;
import stringproject.data.Letter;
import stringproject.data.Word;
import stringproject.dataexceptions.NotALetterException;
import stringproject.dataexceptions.NotAWordException;

import java.util.ArrayList;

public class WordTest {
    @Test(expected = NotAWordException.class)
    public void givesExceptionWhenTwoCapitalLetters() throws NotALetterException, NotAWordException {
        ArrayList<Letter>letters = new ArrayList<>();
        letters.add(new Letter('A'));
        letters.add(new Letter('A'));
        new Word(letters);
    }
}
