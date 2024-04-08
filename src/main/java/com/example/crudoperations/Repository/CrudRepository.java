package com.example.crudoperations.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudoperations.model.crud;

public interface CrudRepository extends JpaRepository<crud,Integer>{
	
	
	@Query("select c from crud c where email=?1")
	crud findByEmail(String email);

}
