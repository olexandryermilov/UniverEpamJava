package stringproject.datatest;

import org.junit.Test;
import stringproject.data.Letter;
import stringproject.dataexceptions.NotALetterException;

public class LetterTest {
    @Test(expected = NotALetterException.class)
    public void givesExceptionWhenNotALetter() throws NotALetterException {
        new Letter('#');
    }
}
