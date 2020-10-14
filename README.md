### Mongodb:

#### java mongodb:

https://sandysanthosh.github.io/Mongodb-Atlas/

Check mongodb Atlas

#### Mongo java driver

->go to github ->release

-download the jar file

mongo-java-driver.jar


#### eclipse:    
    new java file
    librarires->mongo java driver
    new class->mongodb class

```
            main(){
            MongoClient mongoClient = new MongoClient("localhost", 27010);
            DB db = mongoClient.getDB("test");    // select the database name
            System.out.println("connected to database");
            }
            catch(Exception e)
            {
            System.out.println(e);
            }
```

# ProductMicroService

#### Product Microservices:

### Eclipse:

![image](https://user-images.githubusercontent.com/11579239/90340965-48e51b80-e019-11ea-92ca-ba88361e865b.png)

### Postman:

![image](https://user-images.githubusercontent.com/11579239/90341016-9b263c80-e019-11ea-9ae4-c324731782c6.png)


### Mongo-DB:

![image](https://user-images.githubusercontent.com/11579239/90341034-bf821900-e019-11ea-81a3-d3628b001fee.png)


CODE:

### Application.properties:

```  

spring.data.mongodb.database=flipkart
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017

server.port = 8081
spring.application.name = Product-Catalog-Service


```

### ProductController:

```
package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ReviewRepository;


@RestController
@RequestMapping("/api")
public class productController{
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ReviewRepository review;
	
	
	@GetMapping("/products")
	public List<Product> getAllUser() {
		return repo.findAll();
	}
	

	@GetMapping("/products/{id}") 
    public Optional<Product> getByIdUser(@PathVariable int id) 
	 { 
		return repo.findById(id); 
	  }

	@PostMapping("/productsall")
	public String addAllUser(@RequestBody Product Product) {
		repo.save(Product);
		return "User id";
	}


	 @DeleteMapping("/products/{id}") 
     public String deleteUser(@PathVariable int id) 
	 { 
		 repo.deleteById(id); 
	    return "User id";
	 }
	 
	 @RequestMapping("/products/{id}")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("product", repo.findById(id).get());
	        return "edit";
	    }
	    
	 @PostMapping("/products/all")
	    public String update(@RequestBody Product product, @RequestParam int id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice) {
	        product.setId(id);
	        product.setName(prodName);
	        product.setDescription(prodDesc);
	        product.setPrice(prodPrice);
	        repo.save(product);
	       return "successlly updated";
	    }
	 
	 
	 @GetMapping("/products/{id}/reviews") 
      public Optional<Product> getByProductIdUser(@PathVariable int id) 
	 {   
		 return repo.findById(id); 
		  }
}
```

### Product.java:

```
package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="productsApi")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

```
### Review.java:

```

package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="review")
public class Review {
	
	@Id
	@GeneratedValue
	private int reviewId;
	private int stars;
	private String author;
	private String body;
	@ManyToOne
	@JoinColumn(name = "id")
	private Product product;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}

```

### ProductRepository.java:

```


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{

	public void delete(Product product);
	
    }
 ```
 ### ReviewRepository.java:
 
 ```
 
 import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Integer>{

		public void delete(Review Review);
}

```
 
 









