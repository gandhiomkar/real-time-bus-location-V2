package com.demo.Exp3.repositories;

import com.demo.Exp3.entities.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RouteStopRepository extends JpaRepository<RouteStop,Long> {

    @Query("SELECT rs FROM RouteStop rs WHERE rs.route.id = :routeId AND rs.stop.id = :stopId")
    Optional<RouteStop> findByRouteIdAndStopId(@Param("routeId") Long routeId, @Param("stopId") Long stopId);

    @Query("SELECT rs FROM RouteStop rs WHERE rs.route.id = :routeId AND rs.stopOrder > :currentStopOrder ORDER BY rs.stopOrder ASC")
    List<RouteStop> findNextStopOrder(@Param("routeId") Long routeId, @Param("currentStopOrder") Integer currentStopOrder);

    @Query("SELECT MAX(rs.stopOrder) FROM RouteStop rs WHERE rs.route.id = :routeId")
    Integer findMaxStopOrderByRouteId(@Param("routeId") Long routeId);

    @Query("SELECT rs FROM RouteStop rs WHERE rs.route.id = :routeId ORDER BY rs.stopOrder")
    List<RouteStop> findAllByRouteIdOrderByStopOrder(@Param("routeId") Long routeId);
}
