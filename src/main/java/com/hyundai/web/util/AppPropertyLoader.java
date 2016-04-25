package com.hyundai.web.util;

import java.util.Properties;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;



public class AppPropertyLoader extends PropertyPlaceholderConfigurer {
	@Override
	  protected void processProperties(ConfigurableListableBeanFactory arg0, Properties properties) {
		 super.processProperties(arg0, properties);
		 System.out.println("The processed property file is" +properties);
	}

}
