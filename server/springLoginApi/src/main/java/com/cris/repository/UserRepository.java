package com.cris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cris.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}

