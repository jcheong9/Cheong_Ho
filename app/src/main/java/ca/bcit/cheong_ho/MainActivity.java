package ca.bcit.cheong_ho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    // URL to get contacts JSON
    private static String SERVICE_URL = "https://www.googleapis.com/books/v1/volumes?q=harry+potter";
    private ArrayList<VolumeInfo> toonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toonList = new ArrayList<VolumeInfo>();
        lv = findViewById(R.id.toonList);
        new GetContacts().execute();
    }
    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    String items = jsonObj.getString("items");
                    JSONObject item;
                    JSONObject objVolumeInfo;
                    JSONArray volInfoJsonArray = new JSONArray(items);
                    for (int i = 0; i < volInfoJsonArray.length(); i++) {
                        item = volInfoJsonArray.getJSONObject(i);
                        String volumeInfo = item.getString("volumeInfo");
                        objVolumeInfo = new JSONObject(volumeInfo);
                        String title = objVolumeInfo.getString("title");
                        String imageLinks = objVolumeInfo.getString("imageLinks");
                        JSONObject objImageLinks = new JSONObject(imageLinks);
                        String smallThumbnail = objImageLinks.getString("smallThumbnail");
                        //get jsonarray and put values into list<String>
                        JSONArray authors = objVolumeInfo.getJSONArray("authors");
                        List<String> list = new ArrayList<String>();
                        for(int k = 0; k < authors.length(); k++){
                            list.add(authors.getString(k));
                        }
                        String publishedDate = objVolumeInfo.getString("publishedDate");
                        VolumeInfo volInfo = new VolumeInfo();
//                        if(objVolumeInfo.getString("publisher")!=null) {
//                            String publisher = objVolumeInfo.getString("publisher");
//                            volInfo.setPublisher(publisher);
//                        }
                        volInfo.setTitle(title);
                        ImageLinks il = new ImageLinks();
                        il.setSmallThumbnail(smallThumbnail);
                        volInfo.setImageLinks(il);
                        volInfo.setAuthors(list);
                        volInfo.setPublishedDate(publishedDate);
                        toonList.add(volInfo);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            //Toon[] toonArray = toonList.toArray(new Toon[toonList.size()]);

            VolumeInfosAdapter adapter = new VolumeInfosAdapter(MainActivity.this, toonList);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }

}

