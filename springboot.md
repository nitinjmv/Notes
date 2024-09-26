**Benefits of Using Spring**

- Lightweight – There is a slight overhead of using the framework in development.
- Inversion of Control (IoC) – Spring container takes care of wiring dependencies of various objects instead of creating or looking for dependent objects.
- Aspect-Oriented Programming (AOP) – Spring supports AOP to separate business logic from system services.
- IoC container – manages Spring Bean life cycle and project-specific configurations
- MVC framework – used to create web applications or RESTful web services, capable of returning XML/JSON responses
- Transaction management – reduces the amount of boilerplate code in JDBC operations, file uploading, etc., either by using Java annotations or by Spring Bean XML configuration file
- Exception Handling – Spring provides a convenient API for translating technology-specific exceptions into unchecked exceptions.

**Spring Boot's Main Features**
- Starters – a set of dependency descriptors to include relevant dependencies at a go
- Auto-configuration – a way to automatically configure an application based on the dependencies present on the classpath
- Actuator – to get production-ready features such as monitoring
- Security
- Logging

**spring-boot-maven-plugin, to package a web application as an executable JAR.**
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```
With this plugin in place, we'll get a fat JAR after executing the package phase. This JAR contains all the necessary dependencies, including an embedded server. So, we no longer need to worry about configuring an external server.

We can then run the application just like we would an ordinary executable JAR.

Notice that the packaging element in the pom.xml file must be set to jar to build a JAR file:
```
<packaging>jar</packaging>
```
If we don't include this element, it also defaults to jar.

**Actuator**

This features allow us to monitor and manage applications when they're running in production.

Spring Boot Actuator can expose operational information using either HTTP or JMX endpoints. But most applications go for HTTP, where the identity of an endpoint and the /actuator prefix form a URL path.

Here are some of the most common built-in endpoints Actuator provides:

- env exposes environment properties
- health shows application health information
- httptrace displays HTTP trace information
- info displays arbitrary application information
- metrics shows metrics information
- loggers shows and modifies the configuration of loggers in the application
- mappings displays a list of all @RequestMapping paths

**Basic Annotations of SpingBoot**
- @EnableAutoConfiguration – to make Spring Boot look for auto-configuration beans on its classpath and automatically apply them
- @SpringBootApplication – to denote the main class of a Boot Application. This annotation combines @Configuration, @EnableAutoConfiguration and @ComponentScan annotations with their default attributes.

**Question:** How to Disable a Specific Auto-Configuration?

**Answer** If we want to disable a specific auto-configuration, we can indicate it using the exclude attribute of the @EnableAutoConfiguration annotation.

For instance, this code snippet neutralizes DataSourceAutoConfiguration:
```
// other annotations
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
If we enabled auto-configuration with the @SpringBootApplication annotation — which has @EnableAutoConfiguration as a meta-annotation — we could disable auto-configuration with an attribute of the same name:
```
// other annotations
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
We can also disable an auto-configuration with the spring.autoconfigure.exclude environment property. This setting in the application.properties file does the same thing as before:
```
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```

**Question:** How to Register a Custom Auto-Configuration?

**Answer:** To register an auto-configuration class, we must have its fully qualified name listed under the EnableAutoConfiguration key in the META-INF/spring.factories file:
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.baeldung.autoconfigure.CustomAutoConfiguration
```
If we build a project with Maven, that file should be placed in the resources/META-INF directory, which will end up in the mentioned location during the package phase.

**Question:** How to Tell an Auto-Configuration to Back Away When a Bean Exists?

**Answer:** To instruct an auto-configuration class to back off when a bean already exists, we can use the @ConditionalOnMissingBean annotation.

The most noticeable attributes of this annotation are:

- value – the types of beans to be checked
- name – the names of beans to be checked

When placed on a method adorned with @Bean, the target type defaults to the method's return type:
```
@Configuration
public class CustomConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public CustomService service() { ... }
}
```

**Question:** How to Write Integration Tests?

**Answer:** When running integration tests for a Spring application, we must have an ApplicationContext.

To make our life easier, Spring Boot provides a special annotation for testing — @SpringBootTest. This annotation creates an ApplicationContext from configuration classes indicated by its classes attribute.

In case the classes attribute isn't set, Spring Boot searches for the primary configuration class. The search starts from the package containing the test until it finds a class annotated with @SpringBootApplication or @SpringBootConfiguration.

**Question:** Why Do We Need Spring Profiles?

**Answer:** When developing applications for the enterprise, we typically deal with multiple environments such as Dev, QA and Prod. The configuration properties for these environments are different.

For example, we might be using an embedded H2 database for Dev, but Prod could have the proprietary Oracle or DB2. Even if the DBMS is the same across environments, the URLs would definitely be different.

To make this easy and clean, Spring has the provision of profiles to help separate the configuration for each environment. So, instead of maintaining this programmatically, the properties can be kept in separate files such as application-dev.properties and application-prod.properties. The default application.properties points to the currently active profile using spring.profiles.active so that the correct configuration is picked up.

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**
