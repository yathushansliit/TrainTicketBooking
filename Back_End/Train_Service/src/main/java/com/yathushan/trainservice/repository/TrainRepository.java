package com.yathushan.trainservice.repository;

import com.yathushan.trainservice.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer>{
}
