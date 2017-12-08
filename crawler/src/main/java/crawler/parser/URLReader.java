package crawler.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader{
    public String readURL(String url){
        try{
            return readURL(new URL(url));
        }
        catch (IOException e){
            return null;
        }
    }
    public String readURL(URL url) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
       StringBuilder sb = new StringBuilder();
       String line;
       while((line=reader.readLine())!=null){
           sb.append(line);
       }
       return sb.toString();
    }
}
