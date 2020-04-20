package com.aja;

import com.aja.entities.AppRole;
import com.aja.entities.AppUser;
import com.aja.repositories.AppRoleRepository;
import com.aja.repositories.AppUserRepository;
import com.aja.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ManageUsersApplication {

	@Autowired
	private AppRoleRepository appRoleRepository;

	@Autowired
	private AppUserRepository appUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManageUsersApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args ->{

			appUserRepository.deleteAll();
			appRoleRepository.deleteAll();

			accountService.saveRole(new AppRole(null, "USER"));
			accountService.saveRole(new AppRole(null, "ADMIN"));
			Stream.of("user1","user2","user3","admin").forEach( user -> {
				accountService.saveUser(user,"1234","1234");
			});

			accountService.addRoleToUser("admin","ADMIN");
		};
	}
}
