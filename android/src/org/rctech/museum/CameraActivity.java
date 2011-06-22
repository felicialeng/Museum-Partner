package org.rctech.museum;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class CameraActivity extends MuseumActivity {
	private static final int CAMERA_PIC_REQUEST = 8080;  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST); 
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_PIC_REQUEST) {  
        	Bitmap thumbnail = (Bitmap) data.getExtras().get("data");   
        	ImageView image = new ImageView(getApplication());  
        	image.setImageBitmap(thumbnail);  
        	setContentView(image);
        }  
    }  
}