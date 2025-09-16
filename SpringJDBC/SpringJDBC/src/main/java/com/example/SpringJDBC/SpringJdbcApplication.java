package com.example.SpringJDBC;

import com.example.SpringJDBC.model.Person;
import com.example.SpringJDBC.repo.PersonRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringJdbcApplication.class, args);

		Person alien1 = context.getBean(Person.class);
		alien1.setId(111);
		alien1.setName("Kenric");
		alien1.setTech("Java");

		PersonRepo repo = context.getBean(PersonRepo.class);
		repo.save(alien1);

		System.out.println(repo.findAll());
	}

}
