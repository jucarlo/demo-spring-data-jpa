package dev.jclp.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.jclp.demo.entities.Greeting;
import dev.jclp.demo.model.GreetingDto;
import dev.jclp.demo.repositories.GreetingRepository;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public GreetingDto getGreeting() {
        List<Greeting> greetings = greetingRepository.findAll();
        
        if (greetings.isEmpty()) {
            GreetingDto notFound = new GreetingDto();
            notFound.setGreeting("not found");
            return notFound;
        }

        Greeting greeting = greetings.get(0);
        return new GreetingDto(greeting.getId(), greeting.getGreeting());
    }
}
