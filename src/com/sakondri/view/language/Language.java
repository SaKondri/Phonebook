package com.sakondri.view.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	private String lang = "en";

	public String getValue(String key) {
		ResourceBundle rb = ResourceBundle.getBundle(
				"com.sakondri.view.language.main", new Locale(lang));
		return rb.getString(key);
	}
}
