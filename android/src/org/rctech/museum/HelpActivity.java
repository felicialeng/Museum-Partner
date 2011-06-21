package org.rctech.museum;

import android.os.Bundle;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

public class HelpActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }
}