import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {
    static String url = "https://stackoverflow.com/search?q=";
    static String query = "IOException";
    public static void main(String[] args){
        try{
            Document doc = Jsoup.connect(url+query).get();

            Elements elements = doc.select(".question-summary .summary");
            for(Element e : elements){
                Elements title = e.select(".result-link h3 a");
                System.out.println("title: " + title.get(0).attr("title"));
                System.out.println("url: " + title.get(0).absUrl("href"));
                Elements excerpt = e.select(".excerpt");
                System.out.println("Excerpt: " + excerpt.text() + "\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
