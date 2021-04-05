package io.covid19vms.covidApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistrictData implements Serializable {
    private int active;
    private int confirmed;
    private int deceased;
    private int recovered;

    public DistrictData() {
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return "DistrictData{" +
                "active=" + active +
                ", confirmed=" + confirmed +
                ", deceased=" + deceased +
                ", recovered=" + recovered +
                '}';
    }
}
