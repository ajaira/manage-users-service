package com.aja.services;

import com.aja.entities.AppRole;
import com.aja.entities.AppUser;
import com.aja.repositories.AppRoleRepository;
import com.aja.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private static final String USER_ROLE = "USER";

    @Autowired
    private AppRoleRepository roleRepository;
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl() {

    }


    @Override
    public AppUser saveUser(String username, String password, String passwordConfirm) {
        AppUser user = findUserByUserName(username);
        if (user != null) {
            throw new RuntimeException("this user is already exists. try with another username");
        }

        if(!password.equals(passwordConfirm)) {
            throw new RuntimeException("the password and the confirmation, does not a same.");
        }

        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setPassword(bCryptPasswordEncoder.encode(password));
        newUser.setActived(true);


        newUser = userRepository.save(newUser);
        addRoleToUser(username, USER_ROLE);
        return  newUser;
    }

    @Override
    public AppRole saveRole(AppRole r) {
        return roleRepository.save(r);
    }

    @Override
    public AppUser findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepository.findByUsername(username);
        AppRole role = roleRepository.findByRole(roleName);
        user.getRoles().add(role);

    }
}
