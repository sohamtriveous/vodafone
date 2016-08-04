package cc.soham.newsapplicationvodafone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sohammondal on 04/08/16.
 */

public class DetailsActivity extends AppCompatActivity {
    private static final String KEY_POSITION = "position";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public static void start(Context context, int position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_POSITION, position);
        context.startActivity(intent);
    }
}
