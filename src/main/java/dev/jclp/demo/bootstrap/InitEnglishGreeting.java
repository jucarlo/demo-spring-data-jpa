package dev.jclp.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import dev.jclp.demo.entities.Greeting;
import dev.jclp.demo.repositories.GreetingRepository;

@Component
@Profile("!spanish")
public class InitEnglishGreeting implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    public InitEnglishGreeting(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello World");
        greetingRepository.save(greeting);
    }
}
