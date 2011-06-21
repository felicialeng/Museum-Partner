package org.rctech.museum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class ScannerActivity extends MuseumActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNetworkAvailable()){       
        	startBarcodeScanner();
        }else{
        	Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_SHORT).show();
        	finish();
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager 
              = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    private void startBarcodeScanner(){
    	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String qr = intent.getStringExtra("SCAN_RESULT");
                Intent i = new Intent(getApplicationContext(),ExhibitActivity.class);
                i.putExtra("json", getJSON(qr));
                startActivity(i);
            }// else if (resultCode == RESULT_CANCELED) {
        }
        finish();
    }
	public static String getJSON(String qr) {
		String str  = null;
		String url = "http://museum-partner.appspot.com/json?qr="+qr;
		try {
			str = convertStreamToString(new URL(url).openStream());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return str;
	}
	
	private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}