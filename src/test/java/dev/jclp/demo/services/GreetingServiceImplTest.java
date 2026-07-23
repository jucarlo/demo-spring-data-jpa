package dev.jclp.demo.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dev.jclp.demo.entities.Greeting;
import dev.jclp.demo.model.GreetingDto;
import dev.jclp.demo.repositories.GreetingRepository;

public class GreetingServiceImplTest {

    @Mock
    private GreetingRepository greetingRepository;

    @InjectMocks
    private GreetingServiceImpl greetingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetGreeting_WithExistingGreetings() {
        // Arrange
        Greeting greeting1 = new Greeting();
        greeting1.setId(1);
        greeting1.setGreeting("Hello World");

        Greeting greeting2 = new Greeting();
        greeting2.setId(2);
        greeting2.setGreeting("Goodbye World");

        List<Greeting> greetings = Arrays.asList(greeting1, greeting2);
        when(greetingRepository.findAll()).thenReturn(greetings);

        // Act
        GreetingDto result = greetingService.getGreeting();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Hello World", result.getGreeting());
    }

    @Test
    public void testGetGreeting_WithEmptyList() {
        // Arrange
        List<Greeting> emptyList = new ArrayList<>();
        when(greetingRepository.findAll()).thenReturn(emptyList);

        // Act
        GreetingDto result = greetingService.getGreeting();

        // Assert
        assertNotNull(result);
        assertNull(result.getId());
        assertEquals("not found", result.getGreeting());
    }
}
