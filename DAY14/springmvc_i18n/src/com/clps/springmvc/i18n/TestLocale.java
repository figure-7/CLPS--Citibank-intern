package com.clps.springmvc.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestLocale {

	public static void main(String[] args) {
		//Locale locale = Locale.JAPAN;
		//Locale locale = Locale.getDefault();
		
		//System.out.println(locale.getCountry() + " - " + locale.getDisplayCountry());
		//System.out.println(locale.getLanguage() + " - " + locale.getDisplayLanguage());
		
//		Locale[] availableLocales = Locale.getAvailableLocales();
//		
//		for (Locale locale : availableLocales) {
//			System.out.println(locale.getCountry() + " - " + locale.getDisplayCountry());
//			System.out.println(locale.getLanguage() + " - " + locale.getDisplayLanguage());
//			System.out.println("-----------------");
//		}
		
	
		Locale locale = Locale.CHINA;
//		Locale locale = Locale.US;
		ResourceBundle rb = ResourceBundle.getBundle("i18n", locale);
		String str = rb.getString("i18n.username");
		System.out.println(str);
	}

}
