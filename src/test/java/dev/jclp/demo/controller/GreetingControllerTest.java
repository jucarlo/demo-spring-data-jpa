package dev.jclp.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.jclp.demo.model.GreetingDto;
import dev.jclp.demo.services.GreetingService;

public class GreetingControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GreetingService greetingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        GreetingController controller = new GreetingController(greetingService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetGreeting_Success() throws Exception {
        // Arrange
        GreetingDto expectedGreeting = new GreetingDto(1, "Hello World");
        when(greetingService.getGreeting()).thenReturn(expectedGreeting);

        // Act & Assert
        mockMvc.perform(get("/api/v1/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.greeting").value("Hello World"));
    }

    @Test
    public void testGetGreeting_NotFound() throws Exception {
        // Arrange
        GreetingDto notFoundGreeting = new GreetingDto();
        notFoundGreeting.setGreeting("not found");
        when(greetingService.getGreeting()).thenReturn(notFoundGreeting);

        // Act & Assert
        mockMvc.perform(get("/api/v1/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting").value("not found"));
    }
}
