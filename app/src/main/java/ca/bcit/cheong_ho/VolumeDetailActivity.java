package ca.bcit.cheong_ho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
        StringBuilder authors = new StringBuilder();
        for(int i = 0; i < authorsList.size() - 1; i++) {
            authors.append(authorsList.get(i) + ", \n");
        }
        authors.append(authorsList.get(authorsList.size() - 1));
        TextView authorView = findViewById(R.id.authors);
        authorView.setText(authors.toString());
    }

    private void setTextViewFromExtra(String key, int viewId) {
        String content = extras.getString(key);
        TextView tv = findViewById(viewId);
        tv.setText(content);
    }
}
