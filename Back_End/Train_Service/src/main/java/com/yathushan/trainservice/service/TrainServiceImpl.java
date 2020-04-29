package com.yathushan.trainservice.service;

import com.yathushan.trainservice.model.Train;
import com.yathushan.trainservice.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TrainRepository trainRepository;


    @Override
    public Train createTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train findTrain(int id) {
        Optional<Train> train = trainRepository.findById(id);

        if(train.isPresent()) {
            return train.get();
        }
        return null;
    }

    @Override
    public List<Train> fetchAllTrains() {
        List<Train> trains = trainRepository.findAll();

        if(trains.isEmpty()){
            return null;
        }
        return  trains;
    }
}
