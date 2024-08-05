package com.demo.Exp3.repositories;

import com.demo.Exp3.entities.Bus;
import com.demo.Exp3.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {
    List<Bus> findByRoute(Route route);
}
