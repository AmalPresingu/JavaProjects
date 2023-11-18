package edu.umsl;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Main {
    public static void main(String[] args) {
        try {
            Set<String> titles = new HashSet<>();
            Map<String, Integer> wordCount= new HashMap<>();

            //setting this to lower number to test program, but base case is 1000
            int numPages = 1000;
            crawlRandomPages(titles, wordCount, numPages);
            wordCount.forEach(Main::printWords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //printing every word and its count
    public static void printWords(String key, Integer value) {
        System.out.println(key + " " + value);
    }

    private static void crawlRandomPages(Set<String> titles, Map<String, Integer> wordCount, int numPages) throws IOException, InterruptedException {

        System.out.println("\nTitles:\n");

        for (int i = 0; i < numPages; i++) {
            //using Document to traverse HTML pages
            Document doc = getRandomPage();
            titles.add(doc.title());
            System.out.println(doc.title());

            Elements elements = doc.getAllElements();
            for (Element element : elements) {
                for (String s : element.text().split("\\s+")) {
                    wordCount.put(s, wordCount.getOrDefault(s, 0) + 1);
                }
            }
            //sleeping for 50 ms or 0.05 seconds
            Thread.sleep(50);
        }
        System.out.println("\nWords:\n");
    }

    //traversing random Wikipedia pages
    private static Document getRandomPage() throws IOException {
        return Jsoup.connect("https://en.wikipedia.org/wiki/Special:Random").get();
    }
}