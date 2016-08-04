package cc.soham.newsapplicationvodafone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.soham.newsapplicationvodafone.objects.NewsObjects;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main_newsitems)
    RecyclerView recyclerView;
    @BindView(R.id.activity_main_progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(NewsObjects.getNewsObjectsList());
        recyclerView.setAdapter(newsAdapter);
    }
}
