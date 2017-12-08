package crawlerTest.dataTest;

import crawler.data.Data;
import crawler.data.DataMiner;
import crawler.parser.Parser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DataMinerTest {
    private static DataMiner dataMiner;
    @BeforeClass
    public static void initDataMiner(){
        dataMiner = new DataMiner(new Data());
    }
    @Test
    public void checkIsStringIsWord_noncapitalWord(){
        final String word = "helo";
        assertTrue(dataMiner.checkIsStringIsWord(word));
    }
    @Test
    public void checkIsStringIsWord_capitalWord(){
        final String word = "Helo";
        assertTrue(dataMiner.checkIsStringIsWord(word));
    }
    @Test
    public void checkIsStringIsWord_nonWord(){
        final String word = "<helo";
        assertTrue(!dataMiner.checkIsStringIsWord(word));
    }
}
