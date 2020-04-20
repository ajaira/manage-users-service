package com.aja.apis;

import com.aja.entities.AppUser;
import com.aja.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {


    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegistrationForm data) {
        return accountService.saveUser(data.getUsername(), data.getPassword(), data.getConfirmPassword());
    }
}
