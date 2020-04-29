package com.yathushan.trainservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String start_from;
    private String end_to;
    private String train_class;
    private String train;
    private String date;
    private String seat_no;

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getStart_from() {
        return start_from;
    }

    public void setStart_from(String start_from) {
        this.start_from = start_from;
    }

    public String getEnd_to() {
        return end_to;
    }

    public void setEnd_to(String end_to) {
        this.end_to = end_to;
    }

    public String getTrain_class() {
        return train_class;
    }

    public void setTrain_class(String train_class) {
        this.train_class = train_class;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }
}
