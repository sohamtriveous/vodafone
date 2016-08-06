package cc.soham.newsapplicationvodafone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cc.soham.newsapplicationvodafone.networking.NewsAPI;
import cc.soham.newsapplicationvodafone.objects.NewsApiSourcesResponse;
import cc.soham.newsapplicationvodafone.objects.Source;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwipeHomeActivity extends AppCompatActivity {
    ViewPager viewPager;

    private static final String TAG = "SwipeHomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_home);

        viewPager = (ViewPager) findViewById(R.id.activity_swipe_home_viewpager);

        Call<NewsApiSourcesResponse> responseCall = NewsAPI.getNewsAPI().getSources();
        responseCall.enqueue(new Callback<NewsApiSourcesResponse>() {
            @Override
            public void onResponse(Call<NewsApiSourcesResponse> call, Response<NewsApiSourcesResponse> response) {
                List<Source> sourceList = response.body().getSources();
                CommonStuff.setSources(sourceList);

                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        Log.i(TAG, "onPageScrolled" + position);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        saveInPreferences(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        Log.i(TAG, "onPageScrollStateChanged" + state);
                    }
                });

                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), sourceList);
                viewPager.setAdapter(viewPagerAdapter);

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SwipeHomeActivity.this);
                int position = sharedPreferences.getInt(KEY_POSITION, DEFAULT_POSITION);
                if (position != 0) {
                    viewPager.setCurrentItem(position);
                }
            }

            @Override
            public void onFailure(Call<NewsApiSourcesResponse> call, Throwable t) {
                Toast.makeText(SwipeHomeActivity.this, "Error in loading sources", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static final String KEY_POSITION = "storedposition";
    public static final int DEFAULT_POSITION = 0;

    public void saveInPreferences(int position) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_POSITION, position);
        editor.commit();
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        List<Source> sources;

        public ViewPagerAdapter(FragmentManager fm, List<Source> sources) {
            super(fm);
            this.sources = sources;
        }

        @Override
        public Fragment getItem(int position) {
            return ListOfArticlesFragment.generateFragment(position);
        }

        @Override
        public int getCount() {
            return sources.size();
        }
    }

    public void showToast(int position) {
        Toast.makeText(this, "Clicked position inside MainActivity " + position, Toast.LENGTH_SHORT).show();
    }

}
