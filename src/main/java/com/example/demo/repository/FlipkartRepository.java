package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface FlipkartRepository extends MongoRepository<User,Integer>{

	List<User> findByName(int name);

	
	@Query("{'Address.city':? }")
	List<User> findByAddress(String city);

}
 