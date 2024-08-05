package com.demo.Exp3.repositories;

import com.demo.Exp3.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {
    @Query("SELECT r FROM Route r JOIN r.routeStops rs1 JOIN r.routeStops rs2 " +
            "WHERE rs1.stop.name = :fromStop AND rs2.stop.name = :toStop " +
            "AND rs1.stopOrder < rs2.stopOrder")
    public List<Route> findRoutesBetweenStops(@Param("fromStop") String fromStop, @Param("toStop") String toString);

    public Route findByName(String name);
}
