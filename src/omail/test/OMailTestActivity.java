package omail.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class OMailTestActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private boolean acount_state=false;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(acount_state){
        	finish();
        	Intent i=new Intent(this, MainInterface.class);
        	startActivity(i);
        }
        setContentView(R.layout.main);
        
        //Button
        View login_button = this.findViewById(R.id.login_button);
        login_button.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.login_button:
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