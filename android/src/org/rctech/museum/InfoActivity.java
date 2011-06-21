package org.rctech.museum;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class InfoActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv = new WebView(getApplicationContext());
        wv.loadData(getIntent().getExtras().getString("info"),"text/html","utf-8");
        setContentView(wv);
    }
}