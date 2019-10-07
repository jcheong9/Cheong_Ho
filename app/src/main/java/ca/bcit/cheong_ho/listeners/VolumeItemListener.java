package ca.bcit.cheong_ho.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import ca.bcit.cheong_ho.VolumeDetailActivity;

public class VolumeItemListener implements AdapterView.OnItemClickListener {
    private Context originalContext;
    public VolumeItemListener(Context context) {
        this.originalContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(originalContext, VolumeDetailActivity.class);
        originalContext.startActivity(intent);
    }
}
