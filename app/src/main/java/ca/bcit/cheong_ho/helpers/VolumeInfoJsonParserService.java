package ca.bcit.cheong_ho.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.cheong_ho.enums.ISBNType;
import ca.bcit.cheong_ho.models.ISBN;
import ca.bcit.cheong_ho.models.ImageLinkInfo;
import ca.bcit.cheong_ho.models.IndustryIdentifier;
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
        String publisher = objVolumeInfo.optString("publisher", "Publisher unavailable");

        // Get industry identifier
        JSONArray identifiers = objVolumeInfo.getJSONArray("industryIdentifiers");
        IndustryIdentifier industryIdentifier = new IndustryIdentifier();
        for (int i = 0; i < identifiers.length(); i++) {
            JSONObject identifier = identifiers.getJSONObject(i);
            ISBNType type;
            switch(identifier.getString("type")) {
                case "ISBN_10": type = ISBNType.ISBN_10;
                break;
                default: type = ISBNType.ISBN_13;
                break;
            }
            String identifierId = identifier.getString("identifier");
            industryIdentifier.addISBN(new ISBN(type, identifierId));
        }

        // Set image link info
        ImageLinkInfo il = new ImageLinkInfo();
        il.setSmallThumbnail(smallThumbnail);

        // Initialize volume info object
        VolumeInfo volInfo = new VolumeInfo();
        volInfo.setIndustryIdentifier(industryIdentifier);
        volInfo.setPublisher(publisher);
        volInfo.setTitle(title);
        volInfo.setImageLinkInfo(il);
        volInfo.setAuthors(list);
        volInfo.setPublishedDate(publishedDate);
        return volInfo;
    }
}
