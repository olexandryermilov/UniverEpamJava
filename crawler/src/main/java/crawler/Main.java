package crawler;

import crawler.data.Data;
import crawler.data.DataMiner;

public class Main {
    private final static String firstUrl = "https://en.wikipedia.org/wiki/Java_(programming_language)";
    public static void main(String[] args){
        Data data = new Data();
        DataMiner crawler = new DataMiner(data);
        crawler.mineData(firstUrl);

    }
}
