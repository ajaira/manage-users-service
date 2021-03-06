package com.aja.repositories;

import com.aja.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRole(String role);
}
