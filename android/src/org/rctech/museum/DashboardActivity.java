package org.rctech.museum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DashboardActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Button btnScan = (Button)findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),ScannerActivity.class));
			}
		});
        
        Button btnDemo = (Button)findViewById(R.id.btn_demo);
        btnDemo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),SearchActivity.class));
			}
		});
    }
    
    
}