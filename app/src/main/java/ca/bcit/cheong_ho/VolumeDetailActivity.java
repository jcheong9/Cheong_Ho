package ca.bcit.cheong_ho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.cheong_ho.adapters.AuthorInfoAdapter;
import ca.bcit.cheong_ho.http.ImageDownloaderTask;

public class VolumeDetailActivity extends AppCompatActivity {
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_detail);
        extras = getIntent().getExtras();
        setVolumeDetailView();
    }

    private void setVolumeDetailView() {
        setTextViewFromExtra("title", R.id.titleView);
        setTextViewFromExtra("description", R.id.description);
        setTextViewFromExtra("isbn_10", R.id.isbnView);
        setTextViewFromExtra("publisher", R.id.publisher);
        setTextViewFromExtra("publishedDate", R.id.publishedDate);

        // Set image view
        String imageUrl = extras.getString("smallThumbnail");
        if (imageUrl != null) {
            ImageView imgOnePhoto = findViewById(R.id.thumbnailImage);
            ImageDownloaderTask img = new ImageDownloaderTask(imgOnePhoto);
            img.execute(imageUrl);
        }

        // Set authors
        List<String> authorsList = extras.getStringArrayList("authors");
        ListView authorView = findViewById(R.id.authors);
        ArrayAdapter<String> arrayAdapter = new AuthorInfoAdapter(
                VolumeDetailActivity.this,
                authorsList
        );
        authorView.setAdapter(arrayAdapter);
    }

    private void setTextViewFromExtra(String key, int viewId) {
        String content = extras.getString(key);
        TextView tv = findViewById(viewId);
        tv.setText(content);
    }
}
