package ru.potelov.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StatisticsPK implements Serializable {
    @Column(name = "hospital_id")
    private int hospitalId;

    @Column(name = "disease_id")
    private int diseaseId;

    @Column(name = "date")
    private int date;

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
