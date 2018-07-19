package com.freimanvs.shops.eshop.utils;

import com.freimanvs.shops.eshop.utils.interfaces.I18n;

import javax.enterprise.context.Dependent;

@Dependent
public class I18nImpl implements I18n {
    public String unicodeString(String input) {
        return input.chars().mapToObj(x -> "\\u" + Integer.toHexString(x | 0x10000).substring(1)).
                reduce((s1, s2) -> s1 + s2).orElse("");
    }
}
