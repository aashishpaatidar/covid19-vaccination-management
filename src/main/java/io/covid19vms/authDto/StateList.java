package io.covid19vms.authDto;

import java.util.Set;

public class StateList {
    private Set<String> stateList;

    public StateList(Set<String> stateList) {
        this.stateList = stateList;
    }

    public Set<String> getStateList() {
        return stateList;
    }

    public void setStateList(Set<String> stateList) {
        this.stateList = stateList;
    }
}
