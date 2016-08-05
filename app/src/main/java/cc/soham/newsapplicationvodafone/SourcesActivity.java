package cc.soham.newsapplicationvodafone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import cc.soham.newsapplicationvodafone.networking.NewsAPI;
import cc.soham.newsapplicationvodafone.objects.NewsApiSourcesResponse;
import cc.soham.newsapplicationvodafone.objects.Source;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourcesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);

        recyclerView = (RecyclerView) findViewById(R.id.activity_source_sourceitems);
        progressBar = (ProgressBar) findViewById(R.id.activity_source_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar.setVisibility(View.VISIBLE);
        Call<NewsApiSourcesResponse> responseCall = NewsAPI.getNewsAPI().getSources();
        responseCall.enqueue(new Callback<NewsApiSourcesResponse>() {
            @Override
            public void onResponse(Call<NewsApiSourcesResponse> call, Response<NewsApiSourcesResponse> response) {
                progressBar.setVisibility(View.GONE);
                List<Source> source = response.body().getSources();
                CommonStuff.setSources(source);
                SourceAdapter sourceAdapter = new SourceAdapter(source);
                recyclerView.setAdapter(sourceAdapter);
                Toast.makeText(SourcesActivity.this, "response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiSourcesResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(SourcesActivity.this, "error received", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
