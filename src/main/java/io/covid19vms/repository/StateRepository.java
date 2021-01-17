package io.covid19vms.repository;

import io.covid19vms.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
