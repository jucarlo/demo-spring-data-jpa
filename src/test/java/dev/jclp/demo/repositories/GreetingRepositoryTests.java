package dev.jclp.demo.repositories;

import dev.jclp.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GreetingRepositoryTests {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    void testCrudOperations() {
        Greeting g = new Greeting();
        g.setGreeting("Hello");
        Greeting saved = greetingRepository.save(g);
        assertNotNull(saved.getId());

        var found = greetingRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Hello", found.get().getGreeting());

        saved.setGreeting("Hi");
        greetingRepository.save(saved);
        assertEquals("Hi", greetingRepository.findById(saved.getId()).get().getGreeting());

        greetingRepository.deleteById(saved.getId());
        assertTrue(greetingRepository.findById(saved.getId()).isEmpty());
    }
}