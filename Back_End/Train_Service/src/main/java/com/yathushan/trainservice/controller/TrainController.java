package com.yathushan.trainservice.controller;

import com.yathushan.trainservice.model.Train;
import com.yathushan.trainservice.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class TrainController {
    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/createTrain", method = RequestMethod.POST)
    public Train createUser(@RequestBody Train train){
        return trainService.createTrain(train);
    }

    @RequestMapping(value = "findTrain/{id}")
    public Train findUser(@PathVariable int id) {
        return trainService.findTrain(id);
    }

    @RequestMapping(value = "/fetchAllUsers", method = RequestMethod.GET)
    public List<Train> fetchAllTrains(){
        return trainService.fetchAllTrains();
    }
}
