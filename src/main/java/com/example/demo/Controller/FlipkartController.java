package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.FlipkartRepository;

@RestController
@RequestMapping("/order-service")
public class FlipkartController {

	@Autowired
	private FlipkartRepository FlipkartRepository;

	@GetMapping("/findAllUser")
	public List<User> getAllUser() {
		return FlipkartRepository.findAll();
	}

	@PostMapping("/addUser")
	public String addAllUser(@RequestBody User user) {
		FlipkartRepository.save(user);
		return "User id";
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		FlipkartRepository.deleteById(id);
		return "User id";
	}

	@GetMapping("/findUser/{id}")
	public String getAllUserById(@PathVariable int id) {
		FlipkartRepository.findById(id);
		return "User id";
	}

	@GetMapping("/findUser/{name}")
	public List<User> getAllUserByName(@PathVariable int name) {
		return FlipkartRepository.findByName(name);
	}
	 
	
	
	 @GetMapping("/findUser/{Address}") public List<User>
	 getAllUserByAddress(@PathVariable String city) { return
	 FlipkartRepository.findByAddress(city); }
	 

}
