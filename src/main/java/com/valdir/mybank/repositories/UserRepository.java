package com.valdir.mybank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valdir.mybank.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
