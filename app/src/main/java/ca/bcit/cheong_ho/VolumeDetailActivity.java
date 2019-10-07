package ca.bcit.cheong_ho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VolumeDetailActivity extends AppCompatActivity {
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_detail);
        Bundle extras = getIntent().getExtras();

        title = extras.getString("title");
        TextView titleView = findViewById(R.id.titleView);
        titleView.setText(title);
    }
}
