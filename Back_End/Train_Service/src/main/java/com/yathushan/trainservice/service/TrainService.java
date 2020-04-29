package com.yathushan.trainservice.service;

import com.yathushan.trainservice.model.Train;


import java.util.List;

public interface TrainService {
    Train createTrain(Train train);

    Train findTrain(int id);

    List<Train> fetchAllTrains();
}
