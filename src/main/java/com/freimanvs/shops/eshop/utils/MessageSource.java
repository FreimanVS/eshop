package com.freimanvs.shops.eshop.utils;

import javax.enterprise.context.RequestScoped;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@RequestScoped
public class MessageSource {

    private Locale ruLocale = new Locale("ru", "RU");
    private ResourceBundle defaultBundle = ResourceBundle.getBundle("MessageResources", Locale.getDefault());
    private ResourceBundle ruBundle = ResourceBundle.getBundle("MessageResources_ru", ruLocale);

    public MessageSource() {
        Locale.setDefault(Locale.ENGLISH);
    }

    public String getMessage(String key, Locale locale) {
        if (locale.equals(ruLocale))
            return ruBundle.getString(key);
        else
            return defaultBundle.getString(key);
    }

    public Enumeration<String> getKeys(Locale locale) {
        if (locale.equals(ruLocale))
            return ruBundle.getKeys();
        else
            return defaultBundle.getKeys();
    }
}
