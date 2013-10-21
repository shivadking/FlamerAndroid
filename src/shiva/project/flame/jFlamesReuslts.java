package shiva.project.flame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class jFlamesReuslts extends Activity {
	TextView txtnames1,txtnames2,txteq,txtnoteq,txtMatchess;
	Button btnOk;
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xflameresults);
        
        txtnames1=(TextView)findViewById(R.id.txtNames1);
        txtnames2=(TextView)findViewById(R.id.txtNames2);
        txteq=(TextView)findViewById(R.id.txtEquals);
        txtnoteq=(TextView)findViewById(R.id.txtNotequals);
        txtMatchess=(TextView)findViewById(R.id.txtMatch);
        btnOk = (Button) findViewById(R.id.btnOk);
        
        
        txtnames1.setText(getIntent().getExtras().getString("name1"));
        txtnames2.setText(getIntent().getExtras().getString("name2"));
        txteq.setText(getIntent().getExtras().getString("equals"));
        txtnoteq.setText(getIntent().getExtras().getString("notequals"));
        txtMatchess.setText(getIntent().getExtras().getString("match"));
        
        btnOk.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View arg0) {
    			
    	        
    	        Intent intent = new Intent();
                intent.setClass(jFlamesReuslts.this, jFlamesPlay.class);
                startActivity(intent);
                finish();
    	        
    		}
    	});
    }
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if( keyCode == KeyEvent.KEYCODE_BACK) {
	    	Intent intent = new Intent();
            intent.setClass(jFlamesReuslts.this, jFlamesPlay.class);
            startActivity(intent);
            finish();
	        return true;
	    }else{
	        return super.onKeyDown(keyCode, event);
	    }
	}
}
