package com.freimanvs.shops.eshop.utils;

import javax.enterprise.context.RequestScoped;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@RequestScoped
public class MessageSource {

    private ResourceBundle defaultBundle = ResourceBundle.getBundle("MessageResources");
    private ResourceBundle ruruBundle = ResourceBundle.getBundle("MessageResources_ruru");

    private Locale ruRULocale = new Locale("ru", "RU");

    public String getMessage(String key, Locale locale) {
        if (locale.equals(ruRULocale))
            return ruruBundle.getString(key);
        else
            return defaultBundle.getString(key);
    }

    public Enumeration<String> getKeys(Locale locale) {
        if (locale.equals(ruRULocale))
            return ruruBundle.getKeys();
        else
            return defaultBundle.getKeys();
    }
}
