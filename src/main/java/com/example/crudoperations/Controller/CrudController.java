package com.example.crudoperations.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.Repository.CrudRepository;
import com.example.crudoperations.model.crud;


@RestController
@RequestMapping("/crud")
public class CrudController {
	
	@Autowired
	CrudRepository crudrepository;
	
	@PostMapping("/adduser")
	public crud adduser(@RequestBody crud c) {
		return crudrepository.save(c);
	}
	
	@GetMapping("/users")
	public Iterable<crud>allusers(){
		return crudrepository.findAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public Optional<crud> getById(@PathVariable("id")int id){
		return crudrepository.findById(id);
	}
	
	@GetMapping("/getbyemail/{email}")
	public crud getbyemail(@PathVariable("email")String email) {
		return crudrepository.findByEmail(email);
	}
	
	@PutMapping("/updateuser")
	public crud updateuser(@RequestBody crud c) {
		return crudrepository.save(c);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteuser(@PathVariable("id")int id) {
		crudrepository.deleteById(id);
	}
}
