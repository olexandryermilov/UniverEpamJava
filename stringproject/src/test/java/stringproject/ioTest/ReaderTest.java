package stringproject.ioTest;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void readerTest() throws IOException {
        File file = new File("testFile.txt");
        final String text="abc abc abc";
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter os = new BufferedWriter(new FileWriter(file));
            os.write(text);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringproject.io.Reader r = new stringproject.io.Reader(file);
        String content = r.readAll();
        assertEquals(text+"\n",content);
    }
}
