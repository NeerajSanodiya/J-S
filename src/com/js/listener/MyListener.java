package com.js.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	public MyListener() {
        super();        
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	try{
    		Class.forName("com.mysql.jdbc.Driver");    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

	public void contextDestroyed(ServletContextEvent arg0) {
		
    }	
}
