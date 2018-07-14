package com.freimanvs.shops.eshop.utils.interfaces;

import javax.ejb.Remote;

@Remote
public interface InitDBBean {
    void init();
}
