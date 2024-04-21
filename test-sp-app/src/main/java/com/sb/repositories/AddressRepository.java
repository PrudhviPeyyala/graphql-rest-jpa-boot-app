package com.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
