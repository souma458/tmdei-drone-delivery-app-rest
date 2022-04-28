package pt.isep.tmdei.dronemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import pt.isep.tmdei.dronemanagement.model.Drone;

public interface DroneRepository extends CrudRepository<Drone, Long> {

}
