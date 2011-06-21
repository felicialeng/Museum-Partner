package org.rctech.museum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SearchActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String qr = "Peranakan01";
        Intent i = new Intent(getApplicationContext(),ExhibitActivity.class);
        i.putExtra("json", ScannerActivity.getJSON(qr));
        startActivity(i);
        finish();
    }
}