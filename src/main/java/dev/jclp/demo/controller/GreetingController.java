package dev.jclp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.jclp.demo.model.GreetingDto;
import dev.jclp.demo.services.GreetingService;

@RestController
@RequestMapping("api/v1")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public GreetingDto getGreeting() {
        return greetingService.getGreeting();
    }
}
