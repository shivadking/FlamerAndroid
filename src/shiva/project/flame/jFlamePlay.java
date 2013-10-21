package shiva.project.flame;


import  shiva.project.flame.R;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class jFlamePlay extends Activity {

	EditText txtName1,txtName2;
	Button btnCheck;
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtName1=(EditText)findViewById(R.id.txtName1);
        txtName2=(EditText)findViewById(R.id.txtName2);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        
        
      /*  if(s1.equals(s2))
        {
        	Toast.makeText(jFlamePlay.this, "Hai da",Toast.LENGTH_SHORT).show();
        }
        else
        {
        	Toast.makeText(jFlamePlay.this, "Bye da",Toast.LENGTH_SHORT).show();
        }*/
        
        
        
       /* String ip1 = "inputseerru"; // input1
        String ip2 = "utputs"; // input2
        int count = 0; // difference in string
        String ipx2 = ip2;
        for (int j = 0; j <= ip2.length(); j++) {
            int value = ip1.indexOf(ipx2);
            if (value != -1) {
                if (("").equals(ipx2)) { // if the second string is blank after continous reducing
                    count = ip1.length() + ip2.length();
                } else {
                    count = ip1.length() + ip2.length() - 2 * ipx2.length();
                }
                break;
            } else {
                count = ip1.length() + ip2.length(); // if there is no match at all
            }
            ipx2 = ip2.substring(j);
        }
       // System.out.println("" + count);
        Toast.makeText(jFlamePlay.this, "  " + count,Toast.LENGTH_SHORT).show();*/
        
        btnCheck.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int countequals=0,countnotequals=0;
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
		        Toast.makeText(jFlamePlay.this, "No of Equals = "+ countequals + " No of Not Equals = " +countnotequals,Toast.LENGTH_SHORT).show();
		       // flames(countnotequals);
		        flames2();
		        
		     
			}
		});
        
    }
    public void flames2()
    {
    	String name1 = txtName1.getText().toString(),name2 = txtName2.getText().toString(); 
    	name1 = name1.trim();
    	name2 = name2.trim();
    	//System.out.printf(name1.toUpperCase()+" and "+name2.toUpperCase());
    	Toast.makeText(jFlamePlay.this, "Name1 Upper "+ name1.toUpperCase() + "Name2 Upper = " +name2.toUpperCase(),Toast.LENGTH_SHORT).show();
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
    	Toast.makeText(jFlamePlay.this, " are good FRIENDS",Toast.LENGTH_SHORT).show();
    	}
    	else if(j==1)
    	{
    	//System.out.println(" are LOVERS");
    	Toast.makeText(jFlamePlay.this, " are LOVERS",Toast.LENGTH_SHORT).show();
    	}
    	else if(j==2)
    	{
    	//System.out.println(" have alot of AFFECTION");
    	Toast.makeText(jFlamePlay.this, "have alot of AFFECTION",Toast.LENGTH_SHORT).show();
    	}
    	else if(j==3)
    	{
    	//System.out.println(" are MARRIED");
    	Toast.makeText(jFlamePlay.this, "  are MARRIED",Toast.LENGTH_SHORT).show();
    	}
    	else if(j==4)
    	{
    	//System.out.println(" are ENEMIES");
    	Toast.makeText(jFlamePlay.this, " are ENEMIES",Toast.LENGTH_SHORT).show();
    	}
    	else if(j==5)
    	{
    	//System.out.println(" are SIBLINGS");
    	Toast.makeText(jFlamePlay.this, " are SIBLINGS",Toast.LENGTH_SHORT).show();
    	}
    	break;
    	}
    	}
    }
    public void flames(int totalcounts)
    {
    	String f1 = "FLAMES";
    	String f2 = "FLAMES";
    	int flag=0,k=0,counts=0;
    	char[] fc1=f1.toCharArray();
    	char[] fc2=f2.toCharArray();
    	String tempa, tempb;
    	int bb=0;
    	
    	//int a[]={1,2,3,4,5};
		
    	tempb = String.valueOf(fc1[k]);
		Toast.makeText(jFlamePlay.this, "tempb = " +tempb,Toast.LENGTH_SHORT).show();	
		tempa = String.valueOf(bb);
    	while(counts<3)
    	{
    		/*for(int i=1;i<=totalcounts;i++)
    		{
    			String tempa, tempb;
	        	int aa=0;
        		tempa = String.valueOf(fc1[i]);
        		tempb = String.valueOf(aa);
        		if(tempa.equals(tempb))
	        	{
	        		i--;
	        	}
        		else
        		{
        			k++;
        		}
    		}
    		fc1[--k]='0';
    		flag=1;
    		Toast.makeText(jFlamePlay.this, "k = " +k,Toast.LENGTH_SHORT).show();
    		Toast.makeText(jFlamePlay.this, "fc1["+k+"] = " +fc1[k],Toast.LENGTH_SHORT).show();
    		
    		 for(int i=0;i<f1.length();++i)
		        {
    			 Toast.makeText(jFlamePlay.this, "fc1["+i+"] = " +fc1[i],Toast.LENGTH_SHORT).show();
		        }*/  
    		//k=3;
    		for(int i=1;i<=totalcounts;i++)
    		{
    			
    			//tempb = String.valueOf(fc1[3]);
    			while(tempb.equals(tempa))
    			{
    				Toast.makeText(jFlamePlay.this, "Hai-->" +k,Toast.LENGTH_SHORT).show();
    				k++;
    				tempb = String.valueOf(fc1[k]);
    			}
    			Toast.makeText(jFlamePlay.this, "k = " +k,Toast.LENGTH_SHORT).show();	
    			k++;
    			if(k>5)
    			{
    				k=0;
    			}
    			
    			
    		}
    		Toast.makeText(jFlamePlay.this, "k === " +k,Toast.LENGTH_SHORT).show();
    		fc1[--k]='0';
    		k++;
			if(k>5)
			{
				k=0;
			}
    		Toast.makeText(jFlamePlay.this, "k === " +k,Toast.LENGTH_SHORT).show();
    		for(int j=0;j<f1.length();j++)
    		{
    			Toast.makeText(jFlamePlay.this, "fc1["+j+"] = " +fc1[j],Toast.LENGTH_SHORT).show();
    		}
    		
    		counts++;
    		tempb = String.valueOf(fc1[k]);
    		Toast.makeText(jFlamePlay.this, "tempb = " +tempb,Toast.LENGTH_SHORT).show();
    		Toast.makeText(jFlamePlay.this, "k = " +k,Toast.LENGTH_SHORT).show();
    		/*if(counts>=2)
    		{
    			flag=1;
    		}*/
    		
    			
    		
    	}
    }
   
}


/*for ( int i = 0; i < test.length(); ++i ) {  
char c = test.charAt( i );  
int charCode = c;  
// System.out.println("ASCII value of " + c +" is: " + charCode);  
Toast.makeText(jFlamePlay.this, "Char  "+ c + "is :  "+ charCode,Toast.LENGTH_SHORT).show();
}*/


