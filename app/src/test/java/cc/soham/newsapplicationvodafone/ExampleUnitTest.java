package cc.soham.newsapplicationvodafone;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void formatNewsApiDate_correctInputs_correctOutputs() {
        String outputDate = DateTimeUtils.formatNewsApiDate(DateTimeUtils.correctInputDate1);
        assertEquals(outputDate, DateTimeUtils.correctOutputDate1);
    }

    @Test
    public void formatNewsApiDate_nullInput_givesNullOutput() {
        String outputDate = DateTimeUtils.formatNewsApiDate(null);
        assertNull(outputDate);
    }
}