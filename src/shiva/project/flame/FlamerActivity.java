package shiva.project.flame;

import shiva.project.flame.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class FlamerActivity extends Activity {
	Button btnFlam,btnAbout,btnExt;
	
	private static final int DIALOG_EXIT=1;

	protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DIALOG_EXIT:
            return new AlertDialog.Builder(FlamerActivity.this)
                //.setIcon(R.drawable.ic_contact_picture)
                //.setTitle(R.string.Exit_title)
                .setMessage("Do u Want To Exit!!!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    	                        
                        finish();

                    }
                })
                
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    	dialog.dismiss();
                        /* User clicked Cancel so do some stuff */
                    }
                })
                .create();
        
        }
        return null;
    } 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnFlam = (Button) findViewById(R.id.btnFlames);
        btnAbout = (Button) findViewById(R.id.btnAboutus);
        btnExt = (Button) findViewById(R.id.btnExit);
        
 btnExt.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View arg0) {
    			showDialog(DIALOG_EXIT);
    	        
    		}
    	});
 
 btnFlam.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
	        
	        Intent intent = new Intent();
         intent.setClass(FlamerActivity.this, jFlamesPlay.class);
         startActivity(intent);
         finish();
	        
		}
	});
 
 btnAbout.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
	        
	        Intent intent = new Intent();
         intent.setClass(FlamerActivity.this, jAboutUs.class);
         startActivity(intent);
         finish();
	        
		}
	});
    }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if( keyCode == KeyEvent.KEYCODE_BACK) {
	    	showDialog(DIALOG_EXIT);
	        return true;
	    }else{
	        return super.onKeyDown(keyCode, event);
	    }
	}
}