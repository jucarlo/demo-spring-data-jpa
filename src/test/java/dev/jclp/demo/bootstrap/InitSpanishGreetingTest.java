package dev.jclp.demo.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import dev.jclp.demo.repositories.GreetingRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("spanish")
public class InitSpanishGreetingTest {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void testSpanishGreetingInitialized() {
        boolean greetingExists = greetingRepository.findAll().stream()
                .anyMatch(g -> "Hola Mundo".equals(g.getGreeting()));
        
        assertTrue(greetingExists, "Spanish greeting 'Hola Mundo' should be saved to database");
    }
}
