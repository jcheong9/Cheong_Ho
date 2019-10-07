package ca.bcit.cheong_ho.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import ca.bcit.cheong_ho.VolumeDetailActivity;
import ca.bcit.cheong_ho.enums.ISBNType;
import ca.bcit.cheong_ho.models.ISBN;
import ca.bcit.cheong_ho.models.IndustryIdentifier;
import ca.bcit.cheong_ho.models.VolumeInfo;

public class VolumeItemListener implements AdapterView.OnItemClickListener {
    private Context originalContext;
    public VolumeItemListener(Context context) {
        this.originalContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        Intent intent = new Intent(originalContext, VolumeDetailActivity.class);
        VolumeInfo volume = (VolumeInfo) adapterView.getItemAtPosition((int) id);

        intent.putExtra("title", volume.getTitle());
        intent.putExtra("smallThumbnail", volume.getImageLinkInfo().getSmallThumbnail());
        intent.putExtra("authors", volume.getAuthors().toArray());
        intent.putExtra("publisher", volume.getPublisher());
        intent.putExtra("publishedDate", volume.getPublishedDate());
        intent.putExtra("description", volume.getDescription());
        intent.putExtra("isbn_10", getISBN10FromVolume(volume).getIdentifier());
        
        originalContext.startActivity(intent);
    }

    private ISBN getISBN10FromVolume(VolumeInfo vol) {
        IndustryIdentifier identifiers = vol.getIndustryIdentifier();
        for (ISBN elem : identifiers.getIsbnList()) {
            if (elem.getType() == ISBNType.ISBN_10) {
                return elem;
            }
        }
        return null;
    }
}
