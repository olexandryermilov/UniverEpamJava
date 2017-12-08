package crawler.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Data {
    private HashMap<String, TreeMap<String, Integer>> wordFrequency;
    private ArrayList<String> urls;
    public Data(){
        wordFrequency=new HashMap<>();
        urls = new ArrayList<>();
    }

    public HashMap<String, TreeMap<String, Integer>> getWordFrequency() {
        return wordFrequency;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }
}
