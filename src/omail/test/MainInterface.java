package omail.test;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import omail.test.SendMail;
import omail.test.MailBox;
import omail.test.Dustbin;
import omail.test.R;
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
	    spec = tabHost.newTabSpec("sendmail").setIndicator("发邮件",
	                      res.getDrawable(R.drawable.send_mail_tab))
	                  .setContent(intent);
	    
	    tabHost.addTab(spec);
	    intent = new Intent().setClass(this, MailBox.class);
	    spec = tabHost.newTabSpec("mailbox").setIndicator("收件箱",
	                      res.getDrawable(R.drawable.mail_box_tab))
	                  .setContent(intent);
	    
	    tabHost.addTab(spec);
	    intent = new Intent().setClass(this, Dustbin.class);
	    spec = tabHost.newTabSpec("dustbin").setIndicator("垃圾箱",
	                      res.getDrawable(R.drawable.dustbin_tab))
	                  .setContent(intent);

	    tabHost.addTab(spec);
	   
	    tabHost.setCurrentTab(1);
	}	
	
}
