package io.covid19vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.covid19vms.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
