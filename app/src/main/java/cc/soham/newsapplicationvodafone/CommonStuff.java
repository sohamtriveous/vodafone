package cc.soham.newsapplicationvodafone;

import java.util.List;

import cc.soham.newsapplicationvodafone.objects.Article;

/**
 * Created by sohammondal on 05/08/16.
 */

public class CommonStuff {
    public static List<Article> articles;

    public static List<Article> getArticles() {
        return articles;
    }

    public static void setArticles(List<Article> articles) {
        CommonStuff.articles = articles;
    }
}
