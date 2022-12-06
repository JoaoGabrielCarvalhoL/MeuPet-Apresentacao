package br.com.javapet.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		HibernateUtil.getFabricaDeSessoes();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) 
	{
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}
