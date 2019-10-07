package ca.bcit.cheong_ho.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.cheong_ho.models.ImageLinks;
import ca.bcit.cheong_ho.models.VolumeInfo;

public class VolumeInfoJsonParserService {
    public static VolumeInfo getVolumeInfoFromJson(JSONObject objVolumeInfo) throws JSONException {
        // Get title
        String title = objVolumeInfo.getString("title");

        // Get image url
        String imageLinks = objVolumeInfo.getString("imageLinks");
        JSONObject objImageLinks = new JSONObject(imageLinks);
        String smallThumbnail = objImageLinks.getString("smallThumbnail");

        // Get authors
        JSONArray authors = objVolumeInfo.getJSONArray("authors");
        List<String> list = new ArrayList<String>();
        for (int k = 0; k < authors.length(); k++) {
            list.add(authors.getString(k));
        }

        // Get published date
        String publishedDate = objVolumeInfo.getString("publishedDate");

        // Get publisher
        String publisher = objVolumeInfo.optString("publisher", "(Publisher unavailable");

        // Initialize volume info object
        VolumeInfo volInfo = new VolumeInfo();
        volInfo.setPublisher(publisher);
        volInfo.setTitle(title);
        ImageLinks il = new ImageLinks();
        il.setSmallThumbnail(smallThumbnail);
        volInfo.setImageLinks(il);
        volInfo.setAuthors(list);
        volInfo.setPublishedDate(publishedDate);
        return volInfo;
    }
}
