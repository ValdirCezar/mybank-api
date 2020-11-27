package com.valdir.mybank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.mybank.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
