package cc.soham.newsapplicationvodafone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cc.soham.newsapplicationvodafone.objects.Source;

/**
 * Created by sohammondal on 04/08/16.
 */

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.SourcesViewHolder> {
    List<Source> sources;

    public SourceAdapter(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public SourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sources, parent, false);
        return new SourcesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourcesViewHolder holder, final int position) {
        if (sources == null)
            return;
        Source source = sources.get(position);
        Glide.with(holder.sourceImage.getContext()).load(source.getUrlsToLogos().getLarge()).into(holder.sourceImage);
        holder.sourceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.start(view.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (sources == null)
            return 0;
        return sources.size();
    }

    public static class SourcesViewHolder extends RecyclerView.ViewHolder {
        public ImageView sourceImage;

        public SourcesViewHolder(View itemView) {
            super(itemView);
            sourceImage = (ImageView) itemView.findViewById(R.id.item_sources_image);
        }
    }
}
