package ru.potelov.model;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "adress")
    private String adress;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "terr_id", insertable = false, updatable = false)
    private Territory territory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospital hospital = (Hospital) o;

        if (id != hospital.id) return false;
        if (adress != null ? !adress.equals(hospital.adress) : hospital.adress != null) return false;
        if (phone != null ? !phone.equals(hospital.phone) : hospital.phone != null) return false;
        if (name != null ? !name.equals(hospital.name) : hospital.name != null) return false;
        return territory != null ? territory.equals(hospital.territory) : hospital.territory == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (territory != null ? territory.hashCode() : 0);
        return result;
    }
}
