package com.franco.Capstone.models.data;


import com.franco.Capstone.models.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}
