package omail.test;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import omail.test.SendMail;
import omail.test.MailBox;
import omail.test.Dustbin;
import omail.test.R;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainInterface extends TabActivity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
		
		Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec; 
	    Intent intent; 

	    
	    intent = new Intent().setClass(this, SendMail.class);
	    spec = tabHost.newTabSpec("sendmail").setIndicator("SendMail",
	                      res.getDrawable(R.drawable.send_mail_tab))
	                  .setContent(intent);
	    
	    tabHost.addTab(spec);
	    intent = new Intent().setClass(this, MailBox.class);
	    spec = tabHost.newTabSpec("mailbox").setIndicator("MailBox",
	                      res.getDrawable(R.drawable.mail_box_tab))
	                  .setContent(intent);
	    
	    tabHost.addTab(spec);
	    intent = new Intent().setClass(this, Dustbin.class);
	    spec = tabHost.newTabSpec("dustbin").setIndicator("Dustbin",
	                      res.getDrawable(R.drawable.dustbin_tab))
	                  .setContent(intent);

	    tabHost.addTab(spec);
	   
	    tabHost.setCurrentTab(1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menu_search:
			//startActivity(new Intent(this, Setting_1.class));
			return true;
		case R.id.menu_logout:
			//startActivity(new Intent(this, Help.class));
			return true;
		case R.id.menu_exit:
			finish();
			return true;
		}
		return false;
	}
	
}
