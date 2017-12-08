package crawler.data;

import crawler.parser.Parser;
import crawler.parser.URLReader;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataMiner {
    private Data data;
    private final int sitesNumber = 30;
    URLReader urlReader;
    public DataMiner(Data data){
        this.data=data;
        this.urlReader=new URLReader();
    }
    public void mineData(String startUrl) {
        ArrayList<String> urls = data.getUrls();
        urls.add(startUrl);
        for (int i = 0; i < Math.min(urls.size(),sitesNumber); i++) {
            String url = urls.get(i);
            Parser parser = new Parser(urlReader.readURL(url));
            ArrayList<String> urlsAtUrlPage = parser.getAllUrls();
            for (String urlAtPage : urlsAtUrlPage) {
                if (!urls.contains(urlAtPage)) {
                    urls.add(urlAtPage);
                }
            }
            String[] wordsAtUrlPage = parser.getAllWords();
            for (int j = 0; j < wordsAtUrlPage.length; j++) {
                if(!checkIsStringIsWord(wordsAtUrlPage[j]))continue;
                System.out.println(wordsAtUrlPage[j]);
                if (!data.getWordFrequency().containsKey(wordsAtUrlPage[j])) {
                    data.getWordFrequency().put(wordsAtUrlPage[j], new TreeMap<>());
                }
                data.getWordFrequency().get(wordsAtUrlPage[j]).put(url, data.getWordFrequency().
                        get(wordsAtUrlPage[j]).getOrDefault(url, 0) + 1);
            }
        }
    }
    public boolean checkIsStringIsWord(String word){
        Pattern pattern =Pattern.compile("[A-Z]?[a-z]+");
        Matcher matcher = pattern.matcher(word);
        return (matcher.find()&&matcher.group().equals(word));
    }
}
