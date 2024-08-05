package com.demo.Exp3.services;

import com.demo.Exp3.entities.Stop;
import com.demo.Exp3.repositories.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopService {

    @Autowired
    private StopRepository stopRepository;

    public Stop getStop(String name){
        return stopRepository.findByName(name);
    }

    public Stop createStop(String name){
        Stop stop = new Stop();
        stop.setName(name);
        return stopRepository.save(stop);
    }
}
