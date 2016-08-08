package cc.soham.newsapplicationvodafone;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sohammondal on 07/08/16.
 */

public class DateTimeUtils {
    public static String correctInputDate1 = "2016-07-25T09:56:27Z";
    public static String correctOutputDate1 = "Mon, 25 Jul 2016 09:56";

    public static String incorrectInputDate1 = "2016-07-25T09";

    public static String formatNewsApiDate(String inputDate) {
        if(inputDate == null)
            return null;
        try {
            String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            String outputDateFormat = "EEE, d MMM yyyy KK:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inputDate;
    }
}
