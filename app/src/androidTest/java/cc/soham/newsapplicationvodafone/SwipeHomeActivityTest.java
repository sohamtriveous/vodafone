package cc.soham.newsapplicationvodafone;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SwipeHomeActivityTest {

    @Rule
    public ActivityTestRule<SwipeHomeActivity> mActivityTestRule = new ActivityTestRule<>(SwipeHomeActivity.class);

    @Test
    public void swipeHomeActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.activity_main_newsitems),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(allOf(withId(R.id.activity_swipe_home_viewpager),
                                        withParent(allOf(withId(R.id.activity_swipe_home),
                                                withParent(allOf(withId(android.R.id.content),
                                                        withParent(withId(R.id.decor_content_parent)))))))))),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.activity_main_newsitems),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.activity_swipe_home_viewpager)))),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction webView = onView(
                allOf(withId(R.id.activity_details_webview), isDisplayed()));
        webView.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.activity_main_newsitems),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.activity_swipe_home_viewpager)))),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction webView2 = onView(
                allOf(withId(R.id.activity_details_webview), isDisplayed()));
        webView2.check(matches(isDisplayed()));

        pressBack();

    }

}
