package cc.soham.newsapplicationvodafone;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.soham.newsapplicationvodafone.objects.NewsObjects;

/**
 * Created by sohammondal on 04/08/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<NewsObjects> newsObjectsList;

    public NewsAdapter(List<NewsObjects> newsObjectsList) {
        this.newsObjectsList = newsObjectsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        if (newsObjectsList == null)
            return;
        NewsObjects currentNewsObjects = newsObjectsList.get(position);
        holder.title.setText(currentNewsObjects.getTitle());
        holder.date.setText(currentNewsObjects.getDate());
        holder.description.setText(currentNewsObjects.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked position " + position, Toast.LENGTH_SHORT).show();
                DetailsActivity.start(view.getContext(), position);
            }
        });
        Glide.with(holder.newsImage.getContext()).load(currentNewsObjects.getImageUrl()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        if (newsObjectsList == null)
            return 0;
        return newsObjectsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_name_image)
        public ImageView newsImage;
        @BindView(R.id.item_name_title)
        public TextView title;
        @BindView(R.id.item_name_date)
        public TextView date;
        @BindView(R.id.item_name_description)
        public TextView description;
        @BindView(R.id.item_name_card)
        public CardView cardView;

        public NewsViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
