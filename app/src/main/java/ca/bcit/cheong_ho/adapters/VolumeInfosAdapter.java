package ca.bcit.cheong_ho.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ca.bcit.cheong_ho.R;
import ca.bcit.cheong_ho.http.ImageDownloaderTask;
import ca.bcit.cheong_ho.models.VolumeInfo;

public class VolumeInfosAdapter extends ArrayAdapter<VolumeInfo> {
    Context _context;
    public VolumeInfosAdapter(Context context, ArrayList<VolumeInfo> volumeInfos) {
        super(context, 0, volumeInfos);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        VolumeInfo volumeInfo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = convertView.findViewById(R.id.title);
        tvTitle.setText(volumeInfo.getTitle());

        // Return the completed view to render on screen
        return convertView;
    }

}
