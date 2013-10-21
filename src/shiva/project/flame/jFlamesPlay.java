package shiva.project.flame;


import shiva.project.flame.R;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class jFlamesPlay extends Activity {
	EditText txtName1,txtName2;
	Button btnCheck;
	TextView txt1,txt2,txtMatches;
	int countequals=0,countnotequals=0;
	private static final int DIALOG_RESULT=1;
	
	protected Dialog onCreateDialog(int id) {
        switch (id) {
        /*case DIALOG_RESULT:
            LayoutInflater factory = LayoutInflater.from(this);
            final View txView = factory.inflate(R.layout.xflameplay, null);
            txt1 = (TextView) txView.findViewById(R.id.textView1);
            txt2 = (TextView) txView.findViewById(R.id.textView2);
            //txt1.setText(txtName1.getText().toString());
            //txt2.setText(txtName2.getText().toString());
            //textView = (TextView) textEntryView.findViewById(R.id.username_view);
            return new AlertDialog.Builder(jFlamesPlay.this)
               // .setIconAttribute(android.R.attr.accountType)
                .setTitle("Your Matches")
                .setView(txView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                          dialog.dismiss();
                        /* User clicked OK so do some stuff */
                   /* }
                })
                
                .create();*/
        
        case DIALOG_RESULT:
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	builder.setTitle("Title");
        	builder.setMessage("No. of Equals  "  + countequals + "No. of Not Equals  "  + countnotequals);
        	
        	builder.setPositiveButton("OK", null);
        	AlertDialog dialog = builder.show();

        	// Must call show() prior to fetching text view
        	TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        	messageView.setGravity(Gravity.CENTER);
        
        }
        return null;
    } 
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xflameplay);
        
        txtName1=(EditText)findViewById(R.id.txtName1);
        txtName2=(EditText)findViewById(R.id.txtName2);
        txtMatches=(TextView)findViewById(R.id.txtMatches);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        
    btnCheck.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Matchings();
			//Toast.makeText(jFlamesPlay.this, "No of Equals = "+ countequals + " No of Not Equals = " +countnotequals,Toast.LENGTH_SHORT).show();
	        flames2();
	      //showDialog(DIALOG_RESULT);
	        String cc1,cc2;
	        cc1 = String.valueOf(countequals);
	        cc2 = String.valueOf(countnotequals);
	        Intent intent = new Intent();
            intent.setClass(jFlamesPlay.this, jFlamesReuslts.class);
            intent.putExtra("name1",txtName1.getText().toString());
            intent.putExtra("name2",txtName2.getText().toString());
            intent.putExtra("equals",cc1.toString());
			intent.putExtra("notequals",cc2.toString());
			intent.putExtra("match",txtMatches.getText().toString());
            startActivity(intent);
            finish();
	        
		}
	});
    
    
    }
    public void Matchings()
    {
    	countequals=0;
    	countnotequals=0;
		String test = txtName1.getText().toString(),test2 = txtName2.getText().toString();  
        char[] a=test.toCharArray();
        char[] b=test2.toCharArray();
        
        for(int i=0;i<test.length();++i)
        {
        	for(int j=0;j<test2.length();++j)
        	{
        		String tempa, tempb;
        		tempa = String.valueOf(a[i]);
        		tempb = String.valueOf(b[j]);
        		if(tempa.equals(tempb))
        		{
        			//Toast.makeText(jFlamePlay.this, "a["+i+"]= "+ a[i] + "  b["+j+"]= " + b[j],Toast.LENGTH_SHORT).show();
        			a[i]='0';
        			b[j]='0';
        		}
        	}
        }
        
        for(int i=0;i<test.length();++i)
        {
        	String tempa, tempb;
        	int aa=0;
    		tempa = String.valueOf(a[i]);
    		tempb = String.valueOf(aa);
    		//Toast.makeText(jFlamePlay.this, "a["+i+"]= "+ a[i],Toast.LENGTH_SHORT).show();
        	if(tempa.equals(tempb))
        	{
        		countequals=countequals+1;
        	}
        	else
        	{
        		
        		countnotequals=countnotequals+1;
        	}
        }
       // Toast.makeText(jFlamePlay.this, "Equals "+ countequals + " Not Equals " +countnotequals,Toast.LENGTH_SHORT).show();
        
        for(int i=0;i<test2.length();++i)
        {
        	String tempa, tempb;
        	int bb=0;
    		tempb = String.valueOf(b[i]);
    		tempa = String.valueOf(bb);
    		//Toast.makeText(jFlamePlay.this, "b["+i+"]= "+ b[i],Toast.LENGTH_SHORT).show();
        	if(tempb.equals(tempa))
        	{
        		//countequals=countequals+1;
        	}
        	else
        	{
        		
        		countnotequals=countnotequals+1;
        	}
        }
        

    }
    public void flames2()
    {
    	String name1 = txtName1.getText().toString(),name2 = txtName2.getText().toString(); 
    	name1 = name1.trim();
    	name2 = name2.trim();
    	//System.out.printf(name1.toUpperCase()+" and "+name2.toUpperCase());
    	//Toast.makeText(jFlamesPlay.this, "Name1 Upper "+ name1.toUpperCase() + "Name2 Upper = " +name2.toUpperCase(),Toast.LENGTH_SHORT).show();
    	name1 = name1.toLowerCase();
    	name2 = name2.toLowerCase();
    	String name1_split[] = name1.split(" ");
    	String name2_split[] = name2.split(" ");
    	name1="";
    	name2="";
    	for(int i=0;i<name1_split.length;i++)
    	{
    	name1 = name1+name1_split[i];
    	}
    	for(int i=0;i<name2_split.length;i++)
    	{
    	name2 = name2+name2_split[i];
    	}
    	int length = name1.length()+name2.length();
    	boolean name_check[] = new boolean[name2.length()];
    	for(int i=0;i<name2.length();i++)
    	{
    	name_check[i]=false;
    	}
    	for(int i=0;i<name1.length();i++)
    	{
    	for(int j=0;j<name2.length();j++)
    	{
    	if((name_check[j]==false) && (name1.charAt(i) == name2.charAt(j)))
    	{
    	name_check[j]=true;
    	length = length-2;
    	break;
    	}
    	}
    	}
    	boolean flames_check[] = new boolean[6];
    	for(int i=0;i<6;i++)
    	{
    	flames_check[i] = true;
    	}
    	int count = 6;
    	int k=1,deleted_letters=0;
    	int j;
    	for(j=0;j<=count;j++)
    	{
    	if(k <= length)
    	{
    	if(j == count)
    	{
    	j=0;
    	}
    	if(flames_check[j] == true)
    	{
    	k = k+1;
    	}
    	}
    	if((k-1)==length)
    	{
    	deleted_letters = deleted_letters+1;
    	flames_check[j] = false;
    	k = 1;
    	}
    	if(deleted_letters==6)
    	{
    	if(j==0)
    	{
    	//System.out.println(" are good FRIENDS");
    	//Toast.makeText(jFlamesPlay.this, " are good FRIENDS",Toast.LENGTH_SHORT).show();
    	txtMatches.setText(" are good FRIENDS");
    	}
    	else if(j==1)
    	{
    	//System.out.println(" are LOVERS");
    	//Toast.makeText(jFlamesPlay.this, " are LOVERS",Toast.LENGTH_SHORT).show();
    	txtMatches.setText(" are LOVERS");
    	}
    	else if(j==2)
    	{
    	//System.out.println(" have alot of AFFECTION");
    	//Toast.makeText(jFlamesPlay.this, "have alot of AFFECTION",Toast.LENGTH_SHORT).show();
    	txtMatches.setText("have alot of AFFECTION");
    	}
    	else if(j==3)
    	{
    	//System.out.println(" are MARRIED");
    	//Toast.makeText(jFlamesPlay.this, "  are MARRIED",Toast.LENGTH_SHORT).show();
    	txtMatches.setText("  are MARRIED");
    	}
    	else if(j==4)
    	{
    	//System.out.println(" are ENEMIES");
    	//Toast.makeText(jFlamesPlay.this, " are ENEMIES",Toast.LENGTH_SHORT).show();
    	txtMatches.setText(" are ENEMIES");
    	}
    	else if(j==5)
    	{
    	//System.out.println(" are SIBLINGS");
    	//Toast.makeText(jFlamesPlay.this, " are SIBLINGS",Toast.LENGTH_SHORT).show();
    	txtMatches.setText(" are SIBLINGS");
    	}
    	break;
    	}
    	}
    }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if( keyCode == KeyEvent.KEYCODE_BACK) {
	    	Intent intent = new Intent();
            intent.setClass(jFlamesPlay.this, FlamerActivity.class);
            startActivity(intent);
            finish();
	        return true;
	    }else{
	        return super.onKeyDown(keyCode, event);
	    }
	}
}
