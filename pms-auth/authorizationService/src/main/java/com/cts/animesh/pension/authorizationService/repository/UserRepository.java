package com.cts.animesh.pension.authorizationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.animesh.pension.authorizationService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
