package org.rctech.museum;

import android.os.Bundle;
import android.webkit.WebView;

public class WikiActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        WebView wv = new WebView(getApplicationContext());
        
        wv.loadUrl(getIntent().getExtras().getString("wiki_url"));
        wv.getSettings().setJavaScriptEnabled(true);
        setContentView(wv);
    }
}