package com.aja.services;

import com.aja.entities.AppRole;
import com.aja.entities.AppUser;

public interface AccountService {
    AppUser saveUser(String username, String password, String passwordConfirm);
    AppRole saveRole(AppRole r);
    AppUser findUserByUserName(String username);
    void addRoleToUser(String username, String role);
}
