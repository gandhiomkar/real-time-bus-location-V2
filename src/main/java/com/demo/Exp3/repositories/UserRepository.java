package com.demo.Exp3.repositories;

import com.demo.Exp3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String Username);
    User findById(long Id);
}
