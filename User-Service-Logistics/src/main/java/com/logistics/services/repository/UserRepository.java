package com.logistics.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.services.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
