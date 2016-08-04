package cc.soham.newsapplicationvodafone.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sohammondal on 04/08/16.
 */

public class NewsObjects {
    private String imageUrl;
    private String title;
    private String date;
    private String description;
    private String detailsUrl;

    public NewsObjects(String imageUrl, String title, String date, String description, String detailsUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.date = date;
        this.description = description;
        this.detailsUrl = detailsUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    private static List<NewsObjects> newsObjectsList = new ArrayList<>();

    public static List<NewsObjects> getNewsObjectsList() {
        return newsObjectsList;
    }

    static {
        newsObjectsList.add(new NewsObjects("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "2016-08-04T04:20:46Z",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));

        newsObjectsList.add(new NewsObjects("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "2016-08-04T04:20:46Z",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));

        newsObjectsList.add(new NewsObjects("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "2016-08-04T04:20:46Z",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));

        newsObjectsList.add(new NewsObjects("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "2016-08-04T04:20:46Z",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));

        newsObjectsList.add(new NewsObjects("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "2016-08-04T04:20:46Z",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));
    }
}
