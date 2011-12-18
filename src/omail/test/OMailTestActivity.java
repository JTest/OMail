package omail.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class OMailTestActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	public	SharedPreferences preferences;
	public SharedPreferences.Editor editor;
	//private boolean acount_state=false;
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       
       //Button
       View login_button = this.findViewById(R.id.login_button);
       login_button.setOnClickListener(this);
       
       //preference
       preferences=getSharedPreferences("account", MODE_WORLD_READABLE);
	  	String address=preferences.getString("address", null);
	  	String passwd=preferences.getString("passwd", null);
    	if(null!=address||null!=passwd){
        	finish();
        	Intent i=new Intent(this, MainInterface.class);
        	startActivity(i);
        }   	
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText addr_text=(EditText)findViewById(R.id.acount_entry);
		String addr_str=addr_text.getText().toString();
		EditText passwd_text=(EditText)findViewById(R.id.passwd_entry);
		String passwd_str=passwd_text.getText().toString();
		switch(v.getId())
		{
		case R.id.login_button:
	    	preferences=getSharedPreferences("account", MODE_WORLD_READABLE);
	    	editor=preferences.edit();
			editor.putString("address", addr_str);
	    	editor.putString("passwd", passwd_str);
	    	editor.commit();
			finish();
        	startActivity(new Intent(this, MainInterface.class));
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.login_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menu_setting:
			startActivity(new Intent(this, Setting_1.class));
			return true;
		case R.id.menu_help:
			startActivity(new Intent(this, Help.class));
			return true;
		case R.id.menu_about:
			startActivity(new Intent(this, About.class));
			return true;
		}
		return false;
	}
}