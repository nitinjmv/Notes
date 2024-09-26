## SOLID Principals 
1. Single Responsibility Principle - this means you should design your classes in such a way that each class should have a single purpose. 
2. Open/Closed Principle - This principle states that software entities like classes, modules, functions should be open for extension but closed for modification. 
3. Liscov Substitution Principle - this principle states that functions that use pointers or references to base classes must be able to use objects of derived classes. 
4. Interface Segregation Principle - This means the number of members in the interface that is visible to the dependent class should be minimised. 
5. Dependency Inversion Principle - High-level modules, which provide complex logic, should be easily reusable and unaffected by changes in low-level modules

### Single Responsibility

Let's begin with the single responsibility principle. As we might expect, this principle states that a class should only have one responsibility. Furthermore, it should only have one reason to change.

How does this principle help us to build better software? Let's see a few of its benefits:

- Testing – A class with one responsibility will have far fewer test cases.
- Lower coupling – Less functionality in a single class will have fewer dependencies.
Organization – Smaller, well-organized classes are easier to search than monolithic ones.
For example, let's look at a class to represent a simple book:
```
public class Book {

    private String name;
    private String author;
    private String text;

    //constructor, getters and setters
}
```
In this code, we store the name, author and text associated with an instance of a Book.

Let's now add a couple of methods to query the text:
```
public class Book {

    private String name;
    private String author;
    private String text;

    //constructor, getters and setters

    // methods that directly relate to the book properties
    public String replaceWordInText(String word){
        return text.replaceAll(word, text);
    }

    public boolean isWordInText(String word){
        return text.contains(word);
    }
}
```
Now our Book class works well, and we can store as many books as we like in our application.

But what good is storing the information if we can't output the text to our console and read it?

Let's throw caution to the wind and add a print method:
```
public class Book {
    //...

    void printTextToConsole(){
        // our code for formatting and printing the text
    }
}
```
However, this code violates the single responsibility principle we outlined earlier.

To fix our mess, we should implement a separate class that deals only with printing our texts:
```
public class BookPrinter {

    // methods for outputting text
    void printTextToConsole(String text){
        //our code for formatting and printing the text
    }

    void printTextToAnotherMedium(String text){
        // code for writing to any other location..
    }
}
```
Awesome. Not only have we developed a class that relieves the Book of its printing duties, but we can also leverage our BookPrinter class to send our text to other media.

Whether it's email, logging, or anything else, we have a separate class dedicated to this one concern.


### Open for Extension, Closed for Modification

It's now time for the O in SOLID, known as the open-closed principle. Simply put, classes should be open for extension but closed for modification. In doing so, we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application.

Of course, the one exception to the rule is when fixing bugs in existing code.

Let's explore the concept with a quick code example. As part of a new project, imagine we've implemented a Guitar class.

It's fully fledged and even has a volume knob:
```
public class Guitar {

    private String make;
    private String model;
    private int volume;

    //Constructors, getters & setters
}
```
We launch the application, and everyone loves it. But after a few months, we decide the Guitar is a little boring and could use a cool flame pattern to make it look more rock and roll.

At this point, it might be tempting to just open up the Guitar class and add a flame pattern — but who knows what errors that might throw up in our application.

Instead, let's stick to the open-closed principle and simply extend our Guitar class:
```
public class SuperCoolGuitarWithFlames extends Guitar {

    private String flameColor;

    //constructor, getters + setters
}
```
By extending the Guitar class, we can be sure that our existing application won't be affected.

### Liskov Substitution
Next on our list is Liskov substitution, which is arguably the most complex of the five principles. Simply put, if class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.

Let's jump straight to the code to help us understand this concept:
```
public interface Car {

    void turnOnEngine();
    void accelerate();
}
```
Above, we define a simple Car interface with a couple of methods that all cars should be able to fulfill: turning on the engine and accelerating forward.

Let's implement our interface and provide some code for the methods:
```
public class MotorCar implements Car {

    private Engine engine;

    //Constructors, getters + setters

    public void turnOnEngine() {
        //turn on the engine!
        engine.on();
    }

    public void accelerate() {
        //move forward!
        engine.powerOn(1000);
    }
}
```
As our code describes, we have an engine that we can turn on, and we can increase the power.

But wait — we are now living in the era of electric cars:
```
public class ElectricCar implements Car {

    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
        //this acceleration is crazy!
    }
}
```
By throwing a car without an engine into the mix, we are inherently changing the behavior of our program. This is a blatant violation of Liskov substitution and is a bit harder to fix than our previous two principles.

One possible solution would be to rework our model into interfaces that take into account the engine-less state of our Car.

### Interface Segregation
The I  in SOLID stands for interface segregation, and it simply means that larger interfaces should be split into smaller ones. By doing so, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.

For this example, we're going to try our hands as zookeepers. And more specifically, we'll be working in the bear enclosure.

Let's start with an interface that outlines our roles as a bear keeper:
```
public interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    void petTheBear();
}
```
As avid zookeepers, we're more than happy to wash and feed our beloved bears. But we're all too aware of the dangers of petting them. Unfortunately, our interface is rather large, and we have no choice but to implement the code to pet the bear.

Let's fix this by splitting our large interface into three separate ones:
```
public interface BearCleaner {
    void washTheBear();
}

public interface BearFeeder {
    void feedTheBear();
}

public interface BearPetter {
    void petTheBear();
}
```
Now, thanks to interface segregation, we're free to implement only the methods that matter to us:
```
public class BearCarer implements BearCleaner, BearFeeder {

    public void washTheBear() {
        //I think we missed a spot...
    }

    public void feedTheBear() {
        //Tuna Tuesdays...
    }
}
```
And finally, we can leave the dangerous stuff to the reckless people:
```
public class CrazyPerson implements BearPetter {

    public void petTheBear() {
        //Good luck with that!
    }
}
```
Going further, we could even split our BookPrinter class from our example earlier to use interface segregation in the same way. By implementing a Printer interface with a single print method, we could instantiate separate ConsoleBookPrinter and OtherMediaBookPrinter classes.

### Dependency Inversion

The principle of dependency inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.

To demonstrate this, let's go old-school and bring to life a Windows 98 computer with code:
```
public class Windows98Machine {}
```
But what good is a computer without a monitor and keyboard? Let's add one of each to our constructor so that every Windows98Computer we instantiate comes prepacked with a Monitor and a StandardKeyboard:
```
public class Windows98Machine {

    private final StandardKeyboard keyboard;
    private final Monitor monitor;

    public Windows98Machine() {
        monitor = new Monitor();
        keyboard = new StandardKeyboard();
    }

}
```
This code will work, and we'll be able to use the StandardKeyboard and Monitor freely within our Windows98Computer class.

Problem solved? Not quite. By declaring the StandardKeyboard and Monitor with the new keyword, we've tightly coupled these three classes together.

Not only does this make our Windows98Computer hard to test, but we've also lost the ability to switch out our StandardKeyboard class with a different one should the need arise. And we're stuck with our Monitor class too.

Let's decouple our machine from the StandardKeyboard by adding a more general Keyboard interface and using this in our class:
```
public interface Keyboard { }
public class Windows98Machine{

    private final Keyboard keyboard;
    private final Monitor monitor;

    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
```
Here, we're using the dependency injection pattern to facilitate adding the Keyboard dependency into the Windows98Machine class.

Let's also modify our StandardKeyboard class to implement the Keyboard interface so that it's suitable for injecting into the Windows98Machine class:
```
public class StandardKeyboard implements Keyboard { }
```
Now our classes are decoupled and communicate through the Keyboard abstraction. If we want, we can easily switch out the type of keyboard in our machine with a different implementation of the interface. We can follow the same principle for the Monitor class.

Excellent! We've decoupled the dependencies and are free to test our Windows98Machine with whichever testing framework we choose.

## CAP Theorem

CAP is an abbreviation of Consistency, Availability, and Partition tolerance. Let’s discuss these three concepts in simple words:

- Consistency means that every read operation will result in getting the latest record. All the information is guaranteed to be up to date.

- Availability is a property that indicates a distributed system will always be available. One or more nodes of such a system might turn off; however, the system will still be accessible through other nodes.

- Partition tolerance represents the ability of the system to be partitioned. Thus it means that every node can work independently from the other ones.

The CAP Theorem states that a distributed system can only meet 2 of 3 properties. So there might only be CA, AP, or CP systems. We can’t guarantee the third property will be achieved while the other two properties are already guaranteed. Consequently, no CAP distributed systems exist. We’ll have a look at the examples of different types of systems in the next section.


CA systems guarantee consistency and availability. Most relational databases are examples of CA systems. For instance, in PostgreSQL, the consistency is reached with the master-slave replication, and the two-phase transaction commit approach. The synchronization of replicas with the master is either synchronous or asynchronous, and the system is strongly available. The problem starts when partitioning. We’ll never guarantee consistency if we try to use partitioning in PostgreSQL.

AP systems are about availability and partition tolerance. Consequently, they might not be consistent all the time. An example of an AP system is the NoSQL database is Cassandra. It uses master-master replication, which in fact conforms to the AP system definition. We can easily perform partitioning to Cassandra. All nodes will be independent units. Thus, the system will be available if at least one of the nodes work. However, the synchronization between partitioned nodes may lead to poor consistency.

CP systems are consistent and partition tolerant. For example, MongoDB is a NoSQL database and a CP system. Strong consistency is reached by using the single master node for the write operation. MongoDB can be partitioned without losing consistency. However, when partitioning, it may become unavailable. The system won’t accept write requests until it makes sure that all operations will be saved safely.

### Security

**Injection** SQL Injection - when query is altered by user's input such as login is directly making query to check valid user. 
Prevention:
- PrepareStatement - first define all the SQL code then pass in each parameter to query later.
- Stored procedures - requires developers to build sql statements that are parameterized.
- Sanitize user's input & Escape the input.

**Broken Authentication** User's Session at risk. Don't keep the session alive for long time.

**Sensitive Data Exposure** Encrypting the personal and sensetive data.

**XML External Entities** commands can be passed as XML data and XML parser can run those commands on server.

**Broken Access Control** Define proper role and access so that not everyone can access everything.

**Security Misconfiguration** Don't use the default configuration.

**Cross-site scripting (XSS)** execute the external script on any browser.
Encode and escape and melacious character in the output data which is being sent to client.

**Insecure Deserialization** instead of data some code/command is wrapped in data..and server deserialize and execute it. 

**Known Vulnerabilities** hide the server details from users so that users don't know which product/version you are using.

**Insufficient Logging & Monitoring** log the data properly & monitor it so that you know what is happening on server.

Owasp dependency check.
Secure database access


## DRY & KISS

DRY stands for “Don's Repeat Yourself”. This principle states that a piece of code should not be repeated across the software. The rationale behind this principle is to reduce duplication and increase reusability. However, please note that we should be careful in adopting this rather too literally. Some duplication can actually improve code readability and maintainability.

KISS stands for “Keep It Simple, Stupid”. This principle states that we should try to keep the code as simple as possible. This makes it easy to understand and maintain over time. Following some of the principles mentioned earlier, if we keep our classes and methods focussed and small, this will lead to simpler code.