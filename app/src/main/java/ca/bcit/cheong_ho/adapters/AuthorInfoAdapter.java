package ca.bcit.cheong_ho.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.cheong_ho.R;

public class AuthorInfoAdapter extends ArrayAdapter<String> {
    Context _context;
    public AuthorInfoAdapter(Context context, List<String> authorList) {
        super(context, 0, authorList);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        String author = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.author_layout, parent, false);
        }
        // Lookup view for data population
        TextView authorView = convertView.findViewById(R.id.authorDetailView);
        // Populate the data into the template view using the data object
        authorView.setText(author);

        // Return the completed view to render on screen
        return convertView;
    }
}
