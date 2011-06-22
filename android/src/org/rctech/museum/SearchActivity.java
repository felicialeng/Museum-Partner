package org.rctech.museum;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class SearchActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(getApplication());
        tv.setGravity(Gravity.CENTER);
        tv.setText("Under Construction");
        setContentView(tv);
    }
}