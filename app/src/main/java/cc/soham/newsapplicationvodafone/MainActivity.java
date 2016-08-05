package cc.soham.newsapplicationvodafone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import cc.soham.newsapplicationvodafone.networking.NewsAPI;
import cc.soham.newsapplicationvodafone.objects.NewsApiArticleResponse;
import cc.soham.newsapplicationvodafone.objects.NewsApiSourcesResponse;
import cc.soham.newsapplicationvodafone.objects.NewsObjects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<NewsApiArticleResponse> responseCall = NewsAPI.getNewsAPI().getArticles("bbcnews", "top");
        responseCall.enqueue(new Callback<NewsApiArticleResponse>() {
            @Override
            public void onResponse(Call<NewsApiArticleResponse> call, Response<NewsApiArticleResponse> response) {
                NewsApiArticleResponse newsApiArticleResponse = response.body();
                Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiArticleResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error received", Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newsitems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(NewsObjects.getNewsObjectsList());
        recyclerView.setAdapter(newsAdapter);
    }
}
