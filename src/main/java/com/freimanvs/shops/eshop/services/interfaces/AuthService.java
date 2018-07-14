package com.freimanvs.shops.eshop.services.interfaces;

public interface AuthService {
    boolean isAuthorized(String login, String password);
}
