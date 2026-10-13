package com.rosake.mydb.repositories;

import com.rosake.mydb.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}