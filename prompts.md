# Session 1 target: Creating a JPA Entity and Spring Data JPA Repository
1. In the directory dev.jclp.demo create a new package called entities. Add a new JPA entity called Greeting. Add an ID property with the type of Integer and create a String property called greeting. Add getters and setters.
2. In the directory dev.jclp.demo create a new package called repositories. Add a new Spring Data JPA repository for Greeting called GreetingRepository.
3. Create a @DataJpaTest and test CRUD operations using the GreetingRepository.

# Session 2 target: Creating a Service Layer and DTOs
1. In the directory `dev.jclp.demo` create a new package called `model`. Create a new Java POJO called GreetingDto, with properties matching the Greeting JPA Entity.
2. In the directory `dev.jclp.demo` create a new package called `services`. Create an interface called GreetingService with one method called getGreeting that returns a GreetingDto value and has no input parameters.
3. In the directory `dev.jclp.demo.services` create a new class which implements GreetingService. The getGreeting method will use the GreetingRepository to findAll greetings, use the first element of the list, Convert the JPA entity to the Dto and return it. If no records are found, return a new Greeting object with the greeting property set to not found.
4. Create a unit test for the Greeting Service using Mockito Mocks. Test where a list is returned from the repository with entities, and a test case for when an empty list is returned.

# Session 3 target: Create a RESTful Controller with Spring MVC
1. In the directory `dev.jclp.demo` create a new package called `controller`. Create a new class called GreetingController. Annotate the class with the Spring annotation @RestController. Add a private final property for the GreetingService and provide a constructor, do not annotate the constructor, Spring will automatically  perform dependency injection using the constructor. Create a method called getGreeting to return the GreetingDto provided by the getGreeting method of the greetingService. Annotate the method for a HTTP GET operation on the path `api/v1/greeting`.
2. Create a test for the controller using Spring MockMVC and Mockito Mocks to verify the HTTP GET operation is working properly. Just use Mockito, do not use the Spring context for the test.