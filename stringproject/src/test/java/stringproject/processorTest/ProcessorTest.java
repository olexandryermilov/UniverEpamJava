package stringproject.processorTest;

import org.junit.Test;
import stringproject.data.Letter;
import stringproject.data.Word;
import stringproject.dataexceptions.NotALetterException;
import stringproject.dataexceptions.NotAWordException;
import stringproject.processor.Processor;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProcessorTest {
    @Test
    public void processProcessedWord() throws NotALetterException {
        ArrayList<Letter> wordLetter = new ArrayList<>();
        wordLetter.add(new Letter('a'));
        wordLetter.add(new Letter('b'));
        wordLetter.add(new Letter('c'));
        wordLetter.add(new Letter('d'));
        Word word = null;
        try {
            word = new Word(wordLetter);
        } catch (NotAWordException e) {
            e.printStackTrace();
        }
        assertEquals(word, Processor.processWord(word));
    }
    @Test
    public void processWord() throws NotALetterException, NotAWordException {
        ArrayList<Letter> wordLetter = new ArrayList<>();
        wordLetter.add(new Letter('a'));
        wordLetter.add(new Letter('b'));
        wordLetter.add(new Letter('c'));
        wordLetter.add(new Letter('a'));
        Word word = new Word(wordLetter);
        ArrayList<Letter> rightAnswer = new ArrayList<>();
        rightAnswer.add(new Letter('a'));
        rightAnswer.add(new Letter('b'));
        rightAnswer.add(new Letter('c'));
        assertEquals(new Word(rightAnswer), Processor.processWord(word));
    }

    @Test
    public void processString(){
        final String text = "Heh I can rwe4324errrrrw write text and processp it\n" +
                "I can even dodd mistakes but my program wwwwwiwwwllwwww helhhhhhp me!";
        final String RIGHT_ANSWER="Heh I can rweew write tex and process can evn do mistakes but my program will help me ";
        String answer = Processor.processString(text);
        assertEquals(RIGHT_ANSWER,answer);
    }
}
