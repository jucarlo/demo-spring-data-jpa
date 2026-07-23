package dev.jclp.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jclp.demo.entities.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Integer> {

}