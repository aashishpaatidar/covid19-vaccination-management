package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "centre_inventory")
public class VaccinationInventory extends BaseEntity {

    @Column(name = "inventory")
    private int centreInventory;

    @Column(name = "capacity")
    private int centreCapacity;

    @JsonIgnoreProperties("inventory")
    @OneToOne
    @JoinColumn(name = "centre_id")
    private VaccinationCentre centre;

    public VaccinationInventory() {
    }

    public int getCentreInventory() {
        return centreInventory;
    }

    public void setCentreInventory(int centreInventory) {
        this.centreInventory = centreInventory;
    }

    public int getCentreCapacity() {
        return centreCapacity;
    }

    public void setCentreCapacity(int centreCapacity) {
        this.centreCapacity = centreCapacity;
    }

    public VaccinationCentre getCentre() {
        return centre;
    }

    public void setCentre(VaccinationCentre centre) {
        this.centre = centre;
    }
}
