package ru.potelov.model;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @EmbeddedId StatisticsPK statisticsPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    private Disease disease;

    @Basic
    @Column(name = "patients")
    private int patients;

    @Basic
    @Column(name = "issued")
    private int issued;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getPatients() {
        return patients;
    }

    public void setPatients(int patients) {
        this.patients = patients;
    }


    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public StatisticsPK getStatisticsPK() {
        return statisticsPK;
    }

    public void setStatisticsPK(StatisticsPK statisticsPK) {
        this.statisticsPK = statisticsPK;
    }


}
