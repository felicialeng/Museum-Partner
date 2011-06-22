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
        setContentView(R.layout.main);
        Button btnScan = (Button)findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),ScannerActivity.class));
			}
		});
        Button btnLoad = (Button)findViewById(R.id.btn_load);
        btnLoad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),CollectionActivity.class));
			}
		});
        Button btnHelp = (Button)findViewById(R.id.btn_help);
        btnHelp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),HelpActivity.class));
			}
		});
        Button btnSearch = (Button)findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),SearchActivity.class));
			}
		});
        Button btnAbout = (Button)findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),AboutActivity.class));
			}
		});
        Button btnCamera = (Button)findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),CameraActivity.class));
			}
		});
        
        Button btnDemo = (Button)findViewById(R.id.btn_demo);
        btnDemo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
		        String qr = "Peranakan01";
		        Intent i = new Intent(getApplicationContext(),ExhibitActivity.class);
		        i.putExtra("json", ScannerActivity.getJSON(qr));
		        startActivity(i);
		        finish();
			}
		});
    }
    
    
}