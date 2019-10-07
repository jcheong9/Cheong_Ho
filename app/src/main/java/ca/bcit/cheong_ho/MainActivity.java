package ca.bcit.cheong_ho;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ca.bcit.cheong_ho.helpers.VolumeInfoJsonParserService;
import ca.bcit.cheong_ho.http.HttpHandler;
import ca.bcit.cheong_ho.http.VolumeInfosAdapter;
import ca.bcit.cheong_ho.models.VolumeInfo;

public class MainActivity extends AppCompatActivity {
    // URL to get contacts JSON
    private static final String SERVICE_URL =
            "https://www.googleapis.com/books/v1/volumes?q=harry+potter";

    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progressDialog;
    private ListView listView;
    private ArrayList<VolumeInfo> volumeInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volumeInfoList = new ArrayList<VolumeInfo>();
        listView = findViewById(R.id.toonList);
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
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
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
                        VolumeInfo volInfo = VolumeInfoJsonParserService.getVolumeInfoFromJson(objVolumeInfo);
                        volumeInfoList.add(volInfo);
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
            if (progressDialog.isShowing())
                progressDialog.dismiss();

            VolumeInfosAdapter adapter = new VolumeInfosAdapter(MainActivity.this, volumeInfoList);

            // Attach the adapter to a ListView
            listView.setAdapter(adapter);
        }
    }

}

