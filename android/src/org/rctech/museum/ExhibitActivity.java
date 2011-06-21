package org.rctech.museum;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class ExhibitActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibit);
        Resources res = getResources();
        TabHost tabHost = getTabHost(); 
        TabHost.TabSpec spec;
        Intent intent;
        JSONObject json = null;
        try {
			json = new JSONObject(getIntent().getExtras().getString("json"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
		
        // Tab 1: Information Page
        intent = new Intent().setClass(this, InfoActivity.class);
        try {
			intent.putExtra("info", json.getString("info"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        spec = tabHost.newTabSpec("info").setIndicator("Info",
                          res.getDrawable(R.drawable.info))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        
        // Tab 2: Wiki Page
        intent = new Intent().setClass(this, WikiActivity.class);
        try {
			intent.putExtra("wiki_url", json.getString("wiki_url"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        spec = tabHost.newTabSpec("wiki").setIndicator("Wiki",
                          res.getDrawable(R.drawable.wiki))
                      .setContent(intent);
        tabHost.addTab(spec);

        
        // Tab 3: Audio Page
        intent = new Intent().setClass(this, AudioActivity.class);
        try {
			intent.putExtra("audio_url", json.getString("audio_url"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        spec = tabHost.newTabSpec("audio").setIndicator("Audio",
                          res.getDrawable(R.drawable.audio))
                      .setContent(intent);
        tabHost.addTab(spec);

        
        // Tab 4: Video Page
        intent = new Intent().setClass(this, VideoActivity.class);
        try {
			intent.putExtra("video_url", json.getString("video_url"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        spec = tabHost.newTabSpec("video").setIndicator("Video",
                          res.getDrawable(R.drawable.video))
                      .setContent(intent);
        tabHost.addTab(spec);


        
        tabHost.setCurrentTab(0);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exhibit, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.scan:
            finish();
            startActivity(new Intent(getApplicationContext(),ScannerActivity.class));
            return true;
        case R.id.help:
        	startActivity(new Intent(getApplicationContext(),HelpActivity.class));
            return true;
        case R.id.about:
        	startActivity(new Intent(getApplicationContext(),AboutActivity.class));
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}