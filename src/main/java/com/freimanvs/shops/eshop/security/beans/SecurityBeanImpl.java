package com.freimanvs.shops.eshop.security.beans;

import com.freimanvs.shops.eshop.security.beans.interfaces.SecurityBean;
import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

//@Stateless
@Dependent
public class SecurityBeanImpl implements SecurityBean {

    @Override
    public String encodeSha(String str) {
        return DigestUtils.sha256Hex(str);
    }
}
