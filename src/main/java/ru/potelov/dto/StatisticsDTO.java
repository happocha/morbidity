package ru.potelov.dto;

public class StatisticsDTO {

    private String territory;
    private String hospital;
    private String disease;
    private int patients;
    private int issued;
    private int trend;

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
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

    public int getTrend() {
        return patients - issued;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }
}
