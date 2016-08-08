package cc.soham.newsapplicationvodafone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

import cc.soham.newsapplicationvodafone.networking.NewsAPI;
import cc.soham.newsapplicationvodafone.objects.NewsApiArticleResponse;
import cc.soham.newsapplicationvodafone.objects.Source;
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

        int position = getIntent().getIntExtra(KEY_POSITION, DEFAULT_POSITION);
        Source source = CommonStuff.getSources().get(position);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newsitems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar.setVisibility(View.VISIBLE);

        Call<NewsApiArticleResponse> responseCall = NewsAPI.getNewsAPI().getArticles(source.getId(), source.getSortBysAvailable().get(0));
        responseCall.enqueue(new Callback<NewsApiArticleResponse>() {
            @Override
            public void onResponse(Call<NewsApiArticleResponse> call, Response<NewsApiArticleResponse> response) {
                progressBar.setVisibility(View.GONE);
                NewsApiArticleResponse newsApiArticleResponse = response.body();
                CommonStuff.setArticles(newsApiArticleResponse.getArticles());
                NewsAdapter newsAdapter = new NewsAdapter(newsApiArticleResponse.getArticles());
                recyclerView.setAdapter(newsAdapter);
                Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiArticleResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "error received", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToast(int position) {
        Toast.makeText(this, "Clicked position inside MainActivity " + position, Toast.LENGTH_SHORT).show();
    }

    private static final String KEY_POSITION = "position";
    private static final int DEFAULT_POSITION = 0;

    public static void start(Context context, int position) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_POSITION, position);
        context.startActivity(intent);
    }

}
