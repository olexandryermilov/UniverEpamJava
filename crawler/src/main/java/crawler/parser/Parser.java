package crawler.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final static Pattern URLpattern = Pattern.
            compile("(http[s]?:\\u002F{2}[a-z]{2,}\\.)(([a-z]{2,}\\.)*)([a-z]{2,})(\\u002F[a-zA-z\\(\\)]{1,})*(.html)?");
    public Parser(String urlContent){
        if(urlContent!=null)this.URLContent=urlContent;
        else this.URLContent="";
        //System.out.println(urlContent);
    }
    private String URLContent;
    public ArrayList<String> getAllUrls(){
        ArrayList<String> result  = new ArrayList<>();
        Matcher matcher = URLpattern.matcher(URLContent);
        while(matcher.find()){
            String nextUrl = matcher.group();
            if(!result.contains(nextUrl))result.add(nextUrl);
        }
        return result;
    }
    public String[] getAllWords(){
        return URLContent.split(" ");
    }

}
