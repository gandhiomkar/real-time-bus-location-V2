package com.demo.Exp3.repositories;

import com.demo.Exp3.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop,Long> {
    public Stop findByName(String name);
}
