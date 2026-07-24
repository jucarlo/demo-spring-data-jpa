package dev.jclp.demo.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import dev.jclp.demo.repositories.GreetingRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=")
public class InitEnglishGreetingTest {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void testEnglishGreetingInitialized() {
        boolean greetingExists = greetingRepository.findAll().stream()
                .anyMatch(g -> "Hello World".equals(g.getGreeting()));
        
        assertTrue(greetingExists, "English greeting 'Hello World' should be saved to database");
    }
}
