package crawlerTest.dataTest;

import crawler.data.Data;
import crawler.data.DataMiner;
import crawler.parser.URLReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataMinerTest {
    private static DataMiner dataMiner;
    @BeforeClass
    public static void initDataMiner(){
        dataMiner = new DataMiner(new Data());
    }
    @Test
    public void checkIfStringIsWord_noncapitalWord(){
        final String word = "helo";
        assertTrue(dataMiner.checkIfStringIsWord(word));
    }
    @Test
    public void checkIfStringIsWord_capitalWord(){
        final String word = "Helo";
        assertTrue(dataMiner.checkIfStringIsWord(word));
    }
    @Test
    public void checkIsStringIsWord_symbolsAndWord(){
        final String word = "<helo";
        assertTrue(!dataMiner.checkIfStringIsWord(word));
    }
    @Test
    public void checkIsStringIsWord_nonWord(){
        final String word = "<?>";
        assertTrue(!dataMiner.checkIfStringIsWord(word));
    }
    @Test
    public void mockURLReader_getsAllStrings(){
        final String URLReaderAnswer = "abc bac5 BCA <>";
        URLReader mockreader = mock(URLReader.class);
        when(mockreader.readURL("mock")).thenReturn(URLReaderAnswer);
        dataMiner.setUrlReader(mockreader);
        dataMiner.mineData("mock");
        assertTrue(dataMiner.getData().getWordFrequency().size()==1&&dataMiner.getData().getWordFrequency().containsKey("abc"));//assertTrue(dataMiner.getData().getUrls().size()>0&&dataMiner.getData().getUrls().get(0).equals("abc"));
    }
}
