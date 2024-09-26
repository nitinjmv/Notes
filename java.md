<span id="top"></span>

[Basics](#Basics)

[Collections](#Collections)

[Threading/Concurrency](#Concurrency)

Basics <span id="Basics"></span>
--------------------------------

[Back](#top)

**Oops Concepts**

Main principals

- Encapsulation - binding code & data together.

    e.g. Java bean is the fully encapsulated class because all the data members are private here and can only be access via getter & setter.

- Abstraction - hides internal implementation details.
e.g.
  - abstract class - partial abstration
  - Interface - complete abstraction

- Polymorphism - One name multiple form
    - method overloading (compile time): happens in same class when multiple methods are defined with same name but different parameters.
    - method overriding (runtime): happens in subclass when parent class's method is defined in subclass as well.

- Inheritance - reusability e.g. class can extend to another class.

Secondary principals

- association
  - Act of establishig a relationship between two unrelated classes.

  - Can be a one-to-one, one-to-many, many-to-one, or many-to-many relationship

- aggregation
  - One-directional association
  - Represents a HAS-A relationship between two classes
  - Only one class is dependent on the other

- composition
  - A restricted form of aggregation
  - Represents a PART-OF relationship between two classes
  - Both classes are dependent on each other
  - If one class ceases to exist, the other can’t survive alone


======================


    
    Non-static members of a class are called instance members.
    Static members of a class are called class members.

    









=======================

<mark>**Question:** Final Keyword?

**Answer:** final keyword has different meanings at different places:

- A final class is a class that cannot be subclassed.
- A final method is a method that cannot be overridden in subclasses.
- A final variable is a variable that can be assigned only once and is never modified after that.

<mark>**Question:** What Is a Default Method?

**Answer:** It's implementation can be provided in Interface.

One of the use cases, it ensures backward compatibility when added to an existing interface.

e.g. Iterator interface. In Java 8 it received two additional methods, forEach, and spliterator.

<mark>**Question:** What Are Static Class Members?

**Answer:** Static fields and methods are bound to class & not bound to instance.

Static members (method & field) are resolved at compile time.

Static methods can not be overridden in child as they are part of parent class only. However they are accessible in child class.

<mark>**Question:** May a Class Be Declared Abstract If It Does Not Have Any Abstract Members? What Could Be the Purpose of Such Class?

**Answer:** Yes, a class can be declared abstract even if it does not contain any abstract members. As an abstract class, it cannot be instantiated, but it can serve as a root object of some hierarchy, providing methods that can be useful to its implementations.

<mark>**Question:** What Is Overriding and Overloading of Methods? How Are They Different?

**Answer:**

- Overriding of a method is done in a subclass when a  method is defined with the same signature as in superclass.
- Overriding is Runtime polymorphism.

- Overloading of a method happens in the same class.

- Overloading occurs when you create a method with the same name but with different types or number of arguments.

<mark>**Question:** Can You Override a Static Method?

**Answer:** No.

- you can only override a method if its implementation is determined at runtime (a process known as the dynamic method lookup).
- The static method implementation is determined at compile time.
- Although you can add to subclass a static method with the exact same signature as in superclass, this is not technically overriding.

<mark>**Question:** What Is an Immutable Class, and How Can You Create One?

**Answer:** An instance of an immutable class cannot be changed after it's created. By changing we mean mutating the state by modifying the values of the fields of the instance. Immutable classes have many advantages: they are thread-safe.

To make a class immutable, you should ensure the following:

- All fields should be declared private and final; this infers that they should be initialized in the constructor and not changed ever since;

- The class should have no setters or other methods that mutate the values of the fields;

- All fields of the class that were passed via constructor should either be also immutable, or their values should be copied before field initialization (or else we could change the state of this class by holding on to these values and modifying them);

- The methods of the class should not be overridable; either all methods should be final, or the constructor should be private and only invoked via static factory method.

<mark>**Question:** What Is an Initializer Block? What Is a Static Initializer Block?

**Answer:**

- An initializer block is a curly-braced block of code in the class scope with static modifier in front of it.
- It is executed during the instance creation/class loading and can be used for initializing static fields etc.

<mark>**Question:** What Is a Marker Interface? What Are the Notable Examples of Marker Interfaces in Java?

**Answer:**

- A marker interface is an interface without any methods.

e.g.

- Serializable: to explicitly express that the class is serialized.

- Cloneable: allows cloning objects using the clone method (without Cloneable interface in place, this method throws a CloneNotSupportedException)

- Remote: is used in RMI to specify an interface which methods could be called remotely.

<mark>**Question:** What Is a Singleton and How Can It Be Implemented in Java?

**Answer:**

- Singleton comes under creational design patterns of object-oriented programming.
- A singleton class may only have one instance, usually globally visible and accessible.

e.g. there are multiple ways of creating singleton, one of is as following:

- Static field that is initialized in-place. The initialization is thread-safe because static fields are guaranteed to be initialized in a thread-safe manner.
- The constructor is private, so there is no way for outer code to create more than one instance of the class.

```
public class SingletonExample {

    private static SingletonExample instance = new SingletonExample();

    private SingletonExample() {}

    public static SingletonExample getInstance() {
        return instance;
    }
}
```

<mark>**Question:** What Is a Var-Arg? What Are the Restrictions on a Var-Arg? How Can You Use It Inside the Method Body?</mark>

**Answer:**

- Var-arg is a variable-length argument for a method.
- A method may have only one var-arg, and it has to come last in the list of arguments.
- Inside the method body, a var-arg is used as an array of specified type.

e.g.

```
 public static void main(String[] args) {
        new VarArg().printMeVarArg("HR", "aaa","bbb", "ccc");
    }

    public void printMeVarArg(String dept, String... names){
        Arrays.stream(names).forEach(System.out::println);
    }
```

<mark>**Question:** Can You Access an Overridden Method of a Superclass? Can You Access an Overridden Method of a Super-Superclass in a Similar Way?</mark>

**Answer:** yes, with super keyword. But you don't have a similar way of accessing the overridden method of a super-superclass.

<mark>**Question:** What New Features Were Added in Java 8?</mark>

**Answer:**

- Lambda Expressions − a new language feature allowing us to treat actions as objects

- Method References − enable us to define Lambda Expressions by referring to methods directly using their names

- Optional − special wrapper class used for expressing optionality

- Functional Interface – an interface with maximum one abstract method; implementation can be provided using a Lambda Expression

- Default methods − give us the ability to add full implementations in interfaces besides abstract methods

- Nashorn, JavaScript Engine − Java-based engine for executing and evaluating JavaScript code

- Stream API − a special iterator class that allows us to process collections of objects in a functional manner

- Date API − an improved, immutable JodaTime-inspired Date API
Along with these new features, lots of feature enhancements are done under the hood at both the compiler and JVM level.

<mark>**Question:** What Is a Method Reference?</mark>

**Answer:**

- Used for referencing a method without invoking it.
- It's used for treating methods as Lambda Expressions.
- They are only used to reduce the verbosity of some lambdas.

e.g.

- class/object name::method

    ```
    (o) -> o.toString();
    ```

    Can become:

    ```
    Object::toString();
    ```

Different variations,

- Constructor reference:

    ```
    String::new;
    ```

- Static method reference:

    ```
    String::valueOf;
    ```

- Bound instance method reference:

    ```
    str::toString;
    ```

- Unbound instance method reference:

    ```
    String::toString;
    ```

<mark>**Question:** What Is Optional? How Can It Be Used?</mark>
  
**Answer:** 
- It's a wrapper around an object which encapsulates an optional value, i.e. a value that is either there or not.
- Avoids NullPointerException in many cases.
- Reduces boilerplate code for null check.

<mark>**Question:** Describe Some of the Functional Interfaces in the Standard Library?</mark>

**Answer:** Some common functional interfaces in the java.util.function package are following:

- Function – it takes one argument and returns a result

- Consumer – it takes one argument and returns no result

- Supplier – it takes no arguments and returns a result

- Predicate – it takes one argument and returns a boolean

- BiFunction – it takes two arguments and returns a result

- BinaryOperator – it is similar to a BiFunction, taking two arguments and returning a result. The two arguments and the result are all of the same types.

- UnaryOperator – it is similar to a Function, taking a single argument and returning a result of the same type

<mark>**Question:** What Is a Functional Interface? What Are the Rules of Defining a Functional Interface??</mark>

**Answer:** An interface with only one single abstract method (SAM).

e.g.

```
public static void main(String[] args) {
    HelloSAM s = () -> System.out.println("hello");
    s.hello();
}

@FunctionalInterface
interface HelloSAM{
    void hello();
}

```

<mark>**Question:** What Is Type Erasure?</mark>

**Answer:** 
- Generic type information is only available to the compiler, not the JVM. 
- In other words, type erasure means that generic type information is not available to the JVM at runtime, only compile time.

The reasoning behind major implementation choice is simple – preserving backward compatibility with older versions of Java. When a generic code is compiled into bytecode, it will be as if the generic type never existed. This means that the compilation will:

- Replace generic types with objects
- Replace bounded types (More on these in a later question) with the first bound class
- Insert the equivalent of casts when retrieving generic objects.
It's important to understand type erasure. Otherwise, a developer might get confused and think they'd be able to get the type at runtime:

```
public foo(Consumer<T> consumer) {
   Type type = consumer.getGenericTypeParameter()
}
```

The above example is a pseudo code equivalent of what things might look like without type erasure, but unfortunately, it is impossible. Once again, the generic type information is not available at runtime.

<mark>**Question:** If a Generic Type Is Omitted When Instantiating an Object, Will the Code Still Compile?

**Answer:** As generics did not exist before Java 5, it is possible not to use them at all. For example, generics were retrofitted to most of the standard Java classes such as collections. If we look at our list from question one, then we will see that we already have an example of omitting the generic type:

```
List list = new ArrayList();
```

Despite being able to compile, it's still likely that there will be a warning from the compiler. This is because we are losing the extra compile-time check that we get from using generics.

The point to remember is that while backward compatibility and type erasure make it possible to omit generic types, it is bad practice.

<mark>**Question:** How Does a Generic Method Differ from a Generic Type?

**Answer:** A generic method is where a type parameter is introduced to a method, living within the scope of that method. Let's try this with an example:

```
public static <T> T returnType(T argument) { 
    return argument; 
}
```

We've used a static method but could have also used a non-static one if we wished. By leveraging type inference (covered in the next question), we can invoke this like any ordinary method, without having to specify any type arguments when we do so.

<mark>**Question:** What Is Type Inference?

**Answer:** Type inference is when the compiler can look at the type of a method argument to infer a generic type. For example, if we passed in T to a method which returns T, then the compiler can figure out the return type. Let's try this out by invoking our generic method from the previous question:

```
Integer inferredInteger = returnType(1);
String inferredString = returnType("String");
```

As we can see, there's no need for a cast, and no need to pass in any generic type argument. The argument type only infers the return type.

<mark>**Question:** What Is a Bounded Type Parameter?

**Answer:** So far all our questions have covered generic types arguments which are unbounded. This means that our generic type arguments could be any type that we want.

When we use bounded parameters, we are restricting the types that can be used as generic type arguments.

As an example, let's say we want to force our generic type always to be a subclass of animal:

```
public abstract class Cage<T extends Animal> {
    abstract void addAnimal(T animal)
}
```

By using extends, we are forcing T to be a subclass of animal. We could then have a cage of cats:

```
Cage<Cat> catCage;
```

But we could not have a cage of objects, as an object is not a subclass of an animal:

```
Cage<Object> objectCage; // Compilation error
```

One advantage of this is that all the methods of animal are available to the compiler. We know our type extends it, so we could write a generic algorithm which operates on any animal. This means we don't have to reproduce our method for different animal subclasses:

```
public void firstAnimalJump() {
    T animal = animals.get(0);
    animal.jump();
}
```

<mark>**Question:** Is It Possible to Declared a Multiple Bounded Type Parameter?

**Answer:** Declaring multiple bounds for our generic types is possible. In our previous example, we specified a single bound, but we could also specify more if we wish:

```
public abstract class Cage<T extends Animal & Comparable>
```

In our example, the animal is a class and comparable is an interface. Now, our type must respect both of these upper bounds. If our type were a subclass of animal but did not implement comparable, then the code would not compile. It's also worth remembering that if one of the upper bounds is a class, it must be the first argument.

<mark>**Question:** What Is a Wildcard Type?

**Answer:** A wildcard type represents an unknown type. It's detonated with a question mark as follows:

```
public static void consumeListOfWildcardType(List<?> list)
```

Here, we are specifying a list which could be of any type. We could pass a list of anything into this method.

<mark>**Question:** What Is an Upper Bounded Wildcard?

**Answer:** An upper bounded wildcard is when a wildcard type inherits from a concrete type. This is particularly useful when working with collections and inheritance.

Let's try demonstrating this with a farm class which will store animals, first without the wildcard type:

```
public class Farm {
  private List<Animal> animals;

  public void addAnimals(Collection<Animal> newAnimals) {
    animals.addAll(newAnimals);
  }
}
```

If we had multiple subclasses of animal, such as cat and dog, we might make the incorrect assumption that we can add them all to our farm:

```
farm.addAnimals(cats); // Compilation error
farm.addAnimals(dogs); // Compilation error
```

This is because the compiler expects a collection of the concrete type animal, not one it subclasses.

Now, let's introduce an upper bounded wildcard to our add animals method:
`
public void addAnimals(Collection<? extends Animal> newAnimals)
Now if we try again, our code will compile. This is because we are now telling the compiler to accept a collection of any subtype of animal.

<mark>**Question:** What Is the Purpose of the Throw and Throws Keywords?

**Answer:** The throws keyword is used to specify that a method may raise an exception during its execution. It enforces explicit exception handling when calling a method:

```
public void simpleMethod() throws Exception {
    // ...
}
```

The throw keyword allows us to throw an exception object to interrupt the normal flow of the program. This is most commonly used when a program fails to satisfy a given condition:

```
if (task.isTooComplicated()) {
    throw new TooComplicatedException("The task is too complicated");
}
```

<mark>**Question:** What Is the Difference Between a Checked and an Unchecked Exception?

**Answer:** A checked exception must be handled within a try-catch block or declared in a throws clause; whereas an unchecked exception is not required to be handled nor declared.

Checked and unchecked exceptions are also known as compile-time and runtime exceptions respectively.

All exceptions are checked exceptions, except those indicated by Error, RuntimeException, and their subclasses.

<mark>**Question:** What Is the Difference Between an Exception and Error?

**Answer:** An exception is an event that represents a condition from which is possible to recover, whereas error represents an external situation usually impossible to recover from.

All errors thrown by the JVM are instances of Error or one of its subclasses, the more common ones include but are not limited to:

- OutOfMemoryError – thrown when the JVM cannot allocate more objects because it is out memory, and the garbage collector was unable to make more available

- StackOverflowError – occurs when the stack space for a thread has run out, typically because an application recurses too deeply

- ExceptionInInitializerError – signals that an unexpected exception occurred during the evaluation of a static initializer
- NoClassDefFoundError – is thrown when the classloader tries to load the definition of a class and couldn't find it, usually because the required class files were not found in the classpath

- UnsupportedClassVersionError – occurs when the JVM attempts to read a class file and determines that the version in the file is not supported, normally because the file was generated with a newer version of Java

Although an error can be handled with a try statement, this is not a recommended practice since there is no guarantee that the program will be able to do anything reliably after the error was thrown.

<mark>**Question:** What Is a Stacktrace and How Does It Relate to an Exception?

**Answer:** A stack trace provides the names of the classes and methods that were called, from the start of the application to the point an exception occurred.

It's a very useful debugging tool since it enables us to determine exactly where the exception was thrown in the application and the original causes that led to it.

<mark>**Question:** Why Would You Want to Subclass an Exception?

**Answer:** If the exception type isn't represented by those that already exist in the Java platform, or if you need to provide more information to client code to treat it in a more precise manner, then you should create a custom exception.

Deciding whether a custom exception should be checked or unchecked depends entirely on the business case. However, as a rule of thumb; if the code using your exception can be expected to recover from it, then create a checked exception otherwise make it unchecked.

Also, you should inherit from the most specific Exception subclass that closely relates to the one you want to throw. If there is no such class, then choose Exception as the parent.

<mark>**Question:** What Are Annotations? What Are Their Typical Use Cases?

**Answer:** Annotations are metadata bound to elements of the source code of a program and have no effect on the operation of the code they operate.

Their typical uses cases are:

- Information for the compiler – with annotations, the compiler can detect errors or suppress warnings

- Compile-time and deployment-time processing – software tools can process annotations and generate code, configuration files, etc.

- Runtime processing – annotations can be examined at runtime to customize the behavior of a program

<mark>**Question:** How Can You Create an Annotation?

**Answer:** Annotations are a form of an interface where the keyword interface is preceded by @, and whose body contains annotation type element declarations that look very similar to methods:

```
public @interface SimpleAnnotation {
    String value();

    int[] types();
}
```

After the annotation is defined, yon can start using it in through your code:

```
@SimpleAnnotation(value = "an element", types = 1)
public class Element {
    @SimpleAnnotation(value = "an attribute", types = { 1, 2 })
    public Element nextElement;
}
```

Note that, when providing multiple values for array elements, you must enclose them in brackets.

Optionally, default values can be provided as long as they are constant expressions to the compiler:

```
public @interface SimpleAnnotation {
    String value() default "This is an element";

    int[] types() default { 1, 2, 3 };
}
```

Now, you can use the annotation without those elements:

```
@SimpleAnnotation
public class Element {
    // ...
}
```

Or only some of them:

```
@SimpleAnnotation(value = "an attribute")
public Element nextElement;
```

<mark>**Question:** Q6. Is There a Way to Limit the Elements in Which an Annotation Can Be Applied?

**Answer:** Yes, the @Target annotation can be used for this purpose. If we try to use an annotation in a context where it is not applicable, the compiler will issue an error.

Here's an example to limit the usage of the @SimpleAnnotation annotation to field declarations only:

```
@Target(ElementType.FIELD)
public @interface SimpleAnnotation {
    // ...
}
```

We can pass multiple constants if we want to make it applicable in more contexts:

```
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE })
```

We can even make an annotation so it cannot be used to annotate anything. This may come in handy when the declared types are intended solely for use as a member type in complex annotations:

```
@Target({})
public @interface NoTargetAnnotation {
    // ...
}
```

<mark>**Question:** What Are Meta-Annotations?

**Answer:** Are annotations that apply to other annotations.

All annotations that aren't marked with @Target, or are marked with it but include ANNOTATION_TYPE constant are also meta-annotations:

```
@Target(ElementType.ANNOTATION_TYPE)
public @interface SimpleAnnotation {
    // ...
}
```

<mark>**Question:** Q9. How Can You Retrieve Annotations? How Does This Relate to Its Retention Policy?

**Answer:** You can use the Reflection API or an annotation processor to retrieve annotations.

The @Retention annotation and its RetentionPolicy parameter affect how you can retrieve them. There are three constants in RetentionPolicy enum:

RetentionPolicy.SOURCE – makes the annotation to be discarded by the compiler but annotation processors can read them
RetentionPolicy.CLASS – indicates that the annotation is added to the class file but not accessible through reflection
RetentionPolicy.RUNTIME –Annotations are recorded in the class file by the compiler and retained by the JVM at runtime so that they can be read reflectively
Here's an example code to create an annotation that can be read at runtime:

```
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    String value();
}
```

Now, annotations can be retrieved through reflection:

```
Description description
  = AnnotatedClass.class.getAnnotation(Description.class);
System.out.println(description.value());
```

An annotation processor can work with RetentionPolicy.SOURCE, this is described in the article Java Annotation Processing and Creating a Builder.

RetentionPolicy.CLASS is usable when you're writing a Java bytecode parser.

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

Collections <span id="Collections"></span>
------------------------------------------

[Back](#top)

**List vs Set**

List

- allows duplicates.
- maintains the insertion order.
- allows any number of null values.
- not thread safe (copyOnWriteArrayList another variant of List which is Thread safe).
- Any List can be made synchronized with method Collections.synchronizedList()

Set

- doesn't allow duplicate.
- order is not guaranteed. 
- allows only one null.

**Queue vs PriorityQueue**

**Iterator vs ListIterator**

**HashMap vs LinkedHashMap vs ConcurrentHashMap**

**LinkedList vs ArrayList**

**HashSet vs TreeSet**

HashSet

- Implemented using HashTable.
- Elements are not ordered.
- The add, remove, and contains methods have constant time complexity O(1).

TreeSet 

- Implemented using tree structure (red-black tree algo).
- Elements are ordered.
- add, remove, and contains methods has time complexity O(log (n)).

Other differences

1) First major difference between HashSet and TreeSet is performance. HashSet is faster than TreeSet and should be preferred choice if sorting of element is not required.

2) Second difference between HashSet and TreeSet is that HashSet allows null object but TreeSet doesn't allow null Object and throw NullPointerException, Why, because TreeSet uses compareTo() method to compare keys and compareTo() will throw java.lang.NullPointerException.

3) Another significant difference between HashSet and TreeSet is that , HashSet is backed by HashMap while TreeSet is backed by NavigableMap in Java.

4) One more difference between HashSet and TreeSet which is worth remembering is that HashSet uses equals() method to compare two object in Set and for detecting duplicates while TreeSet uses compareTo() method for same purpose. if equals() and compareTo() are not consistent, i.e. for two equal object equals should return true while compareTo() should return zero, than it will break contract of Set interface and will allow duplicates in Set implementations like TreeSet

5) Now most important difference between HashSet and TreeSet is ordering. HashSet doesn't guaranteed any order while TreeSet maintains objects in Sorted order defined by either Comparable or Comparator method in Java.

6) TreeSet does not allow to insert Heterogeneous objects. It will throw classCastException at Runtime if trying to add hetrogeneous objects, whereas HashSet allows hetrogeneous objects.

<mark>**Question:** How Is Hashmap Implemented in Java? How Does Its Implementation Use Hashcode and Equals Methods of Objects? What Is the Time Complexity of Putting and Getting an Element from Such Structure?

**Answer:** The HashMap class represents a typical hash map data structure with certain design choices.

The HashMap is backed by a resizable array that has a size of power-of-two. When the element is added to a HashMap, first its hashCode is calculated (an int value). Then a certain number of lower bits of this value are used as an array index. This index directly points to the cell of the array (called a bucket) where this key-value pair should be placed. Accessing an element by its index in an array is a very fast O(1) operation, which is the main feature of a hash map structure.

A hashCode is not unique, however, and even for different hashCodes, we may receive the same array position. This is called a collision. There is more than one way of resolving collisions in the hash map data structures. In Java's HashMap, each bucket actually refers not to a single object, but to a red-black tree of all objects that landed in this bucket (prior to Java 8, this was a linked list).

So when the HashMap has determined the bucket for a key, it has to traverse this tree to put the key-value pair in its place. If a pair with such key already exists in the bucket, it is replaced with a new one.

To retrieve the object by its key, the HashMap again has to calculate the hashCode for the key, find the corresponding bucket, traverse the tree, call equals on keys in the tree and find the matching one.

HashMap has O(1) complexity, or constant-time complexity, of putting and getting the elements. Of course, lots of collisions could degrade the performance to O(log(n)) time complexity in the worst case, when all elements land in a single bucket. This is usually solved by providing a good hash function with a uniform distribution.

When the HashMap internal array is filled (more on that in the next question), it is automatically resized to be twice as large. This operation infers rehashing (rebuilding of internal data structures), which is costly, so you should plan the size of your HashMap beforehand.

<mark>**Question:** What Is the Purpose of the Initial Capacity and Load Factor Parameters of a Hashmap? What Are Their Default Values?

**Answer:** The initialCapacity argument of the HashMap constructor affects the size of the internal data structure of the HashMap, but reasoning about the actual size of a map is a bit tricky. The HashMap‘s internal data structure is an array with the power-of-two size. So the initialCapacity argument value is increased to the next power-of-two (for instance, if you set it to 10, the actual size of the internal array will be 16).

The load factor of a HashMap is the ratio of the element count divided by the bucket count (i.e. internal array size). For instance, if a 16-bucket HashMap contains 12 elements, its load factor is 12/16 = 0.75. A high load factor means a lot of collisions, which in turn means that the map should be resized to the next power of two. So the loadFactor argument is a maximum value of the load factor of a map. When the map achieves this load factor, it resizes its internal array to the next power-of-two value.

The initialCapacity is 16 by default, and the loadFactor is 0.75 by default, so you could put 12 elements in a HashMap that was instantiated with the default constructor, and it would not resize. The same goes for the HashSet, which is backed by a HashMap instance internally.

Consequently, it is not trivial to come up with initialCapacity that satisfies your needs. This is why the Guava library has Maps.newHashMapWithExpectedSize() and Sets.newHashSetWithExpectedSize() methods that allow you to build a HashMap or a HashSet that can hold the expected number of elements without resizing.

<mark>**Question:** Describe Special Collections for Enums. What Are the Benefits of Their Implementation Compared to Regular Collections?

**Answer:** EnumSet and EnumMap are special implementations of Set and Map interfaces correspondingly. You should always use these implementations when you're dealing with enums because they are very efficient.

An EnumSet is just a bit vector with “ones” in the positions corresponding to ordinal values of enums present in the set. To check if an enum value is in the set, the implementation simply has to check if the corresponding bit in the vector is a “one”, which is a very easy operation. Similarly, an EnumMap is an array accessed with enum's ordinal value as an index. In the case of EnumMap, there is no need to calculate hash codes or resolve collisions.

<mark>**Question:** What Is the Difference Between Fail-Fast and Fail-Safe Iterators?

**Answer:** Iterators for different collections are either fail-fast or fail-safe, depending on how they react to concurrent modifications. The concurrent modification is not only a modification of collection from another thread but also modification from the same thread but using another iterator or modifying the collection directly.

Fail-fast iterators (those returned by HashMap, ArrayList, and other non-thread-safe collections) iterate over the collection's internal data structure, and they throw ConcurrentModificationException as soon as they detect a concurrent modification.

Fail-safe iterators (returned by thread-safe collections such as ConcurrentHashMap, CopyOnWriteArrayList) create a copy of the structure they iterate upon. They guarantee safety from concurrent modifications. Their drawbacks include excessive memory consumption and iteration over possibly out-of-date data in case the collection was modified.

<mark>**Question:** How Can You Use Comparable and Comparator Interfaces to Sort Collections?

**Answer:** The Comparable interface is an interface for objects that can be compared according to some order. Its single method is compareTo, which operates on two values: the object itself and the argument object of the same type. For instance, Integer, Long, and other numeric types implement this interface. String also implements this interface, and its compareTo method compares strings in lexicographical order.

The Comparable interface allows to sort lists of corresponding objects with the Collections.sort() method and uphold the iteration order in collections that implement SortedSet and SortedMap. If your objects can be sorted using some logic, they should implement the Comparable interface.

The Comparable interface usually is implemented using natural ordering of the elements. For instance, all Integer numbers are ordered from lesser to greater values. But sometimes you may want to implement another kind of ordering, for instance, to sort the numbers in descending order. The Comparator interface can help here.

The class of the objects you want to sort does not need to implement this interface. You simply create an implementing class and define the compare method which receives two objects and decides how to order them. You may then use the instance of this class to override the natural ordering of the Collections.sort() method or SortedSet and SortedMap instances.

As the Comparator interface is a functional interface, you may replace it with a lambda expression, as in the following example. It shows ordering a list using a natural ordering (Integer‘s Comparable interface) and using a custom iterator (Comparator<Integer> interface).

```
List<Integer> list1 = Arrays.asList(5, 2, 3, 4, 1);
Collections.sort(list1);
assertEquals(new Integer(1), list1.get(0));

List<Integer> list1 = Arrays.asList(5, 2, 3, 4, 1);
Collections.sort(list1, (a, b) -> b - a);
assertEquals(new Integer(5), list1.get(0));
```

<mark>**Question:** Explain the Difference Between Primitive and Reference Types.

**Answer:** Reference types inherit from the top java.lang.Object class and are themselves inheritable (except final classes). Primitive types do not inherit and cannot be subclassed.

Primitively typed argument values are always passed via the stack, which means they are passed by value, not by reference. This has the following implication: changes made to a primitive argument value inside the method do not propagate to the actual argument value.

Primitive types are usually stored using the underlying hardware value types.

For instance, to store an int value, a 32-bit memory cell can be used. Reference types introduce the overhead of object header which is present in every instance of a reference type.

The size of an object header can be quite significant in relation to a simple numeric value size. This is why the primitive types were introduced in the first place — to save space on object overhead. The downside is that not everything in Java technically is an object — primitive values do not inherit from Object class.

<mark>**Question:** Describe the Different Primitive Types and the Amount of Memory They Occupy.

**Answer:** Java has 8 primitive types:

- boolean — logical true/false value. The size of boolean is not defined by the JVM specification and can vary in different implementations.
- byte — signed 8-bit value,
- short — signed 16-bit value,
- char — unsigned 16-bit value,
- int — signed 32-bit value,
- long — signed 64-bit value,
- float — 32-bit single precision floating point value corresponding to the IEEE 754 standard,
- double — 64-bit double precision floating point value corresponding to the IEEE 754 standard.

<mark>**Question:** What Is the Difference Between an Abstract Class and an Interface? What Are the Use Cases of One and the Other?

**Answer:** An abstract class is a class with the abstract modifier in its definition. It can't be instantiated, but it can be subclassed. The interface is a type described with interface keyword. It also cannot be instantiated, but it can be implemented.

The main difference between an abstract class and an interface is that a class can implement multiple interfaces, but extend only one abstract class.

An abstract class is usually used as a base type in some class hierarchy, and it signifies the main intention of all classes that inherit from it.

An abstract class could also implement some basic methods needed in all subclasses. For instance, most map collections in JDK inherit from the AbstractMap class which implements many methods used by subclasses (such as the equals method).

An interface specifies some contract that the class agrees to. An implemented interface may signify not only the main intention of the class but also some additional contracts.

For instance, if a class implements the Comparable interface, this means that instances of this class may be compared, whatever the main purpose of this class is.

<mark>**Question:** What Are the Restrictions on the Members (Fields and Methods) of an Interface Type?

**Answer:** An interface can declare fields, but they are implicitly declared as public, static and final, even if you don't specify those modifiers. Consequently, you can't explicitly define an interface field as private. In essence, an interface may only have constant fields, not instance fields.

All methods of an interface are also implicitly public. They also can be either (implicitly) abstract, or default.

<mark>**Question:** What Is the Difference Between an Inner Class and a Static Nested Class?

**Answer:** Simply put – a nested class is basically a class defined inside another class.

Nested classes fall into two categories with very different properties. An inner class is a class that can't be instantiated without instantiating the enclosing class first, i.e. any instance of an inner class is implicitly bound to some instance of the enclosing class.

Here's an example of an inner class – you can see that it can access the reference to the outer class instance in the form of OuterClass1.this construct:

```
public class OuterClass1 {

    public class InnerClass {

        public OuterClass1 getOuterInstance() {
            return OuterClass1.this;
        }

    }

}
```

To instantiate such inner class, you need to have an instance of an outer class:

```
OuterClass1 outerClass1 = new OuterClass1();
OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
```

Static nested class is quite different. Syntactically it is just a nested class with the static modifier in its definition.

In practice, it means that this class may be instantiated as any other class, without binding it to any instance of the enclosing class:

```
public class OuterClass2 {

    public static class StaticNestedClass {
    }

}
```

To instantiate such class, you don't need an instance of outer class:

```
OuterClass2.StaticNestedClass staticNestedClass = new OuterClass2.StaticNestedClass();

```

<mark>**Question:** Does Java Have Multiple Inheritance?

**Answer:** Java does not support the multiple inheritance for classes, which means that a class can only inherit from a single superclass.

But you can implement multiple interfaces with a single class, and some of the methods of those interfaces may be defined as default and have an implementation. This allows you to have a safer way of mixing different functionality in a single class.

<mark>**Question:** What Are the Wrapper Classes? What Is Autoboxing?

**Answer:** For each of the eight primitive types in Java, there is a wrapper class that can be used to wrap a primitive value and use it like an object. Those classes are, correspondingly, Boolean, Byte, Short, Character, Integer, Float, Long, and Double. These wrappers can be useful, for instance, when you need to put a primitive value into a generic collection, which only accepts reference objects.

```
List<Integer> list = new ArrayList<>();
list.add(new Integer(5));
```

To save the trouble of manually converting primitives back and forth, an automatic conversion known as autoboxing/auto unboxing is provided by the Java compiler.

```
List<Integer> list = new ArrayList<>();
list.add(5);
int value = list.get(0);

```

<mark>**Question:** Describe the Difference Between equals() and ==

**Answer:**

==

- Reference (memory address of the object) comparison.
- Allows to compare primitive values.

equals()

- Content (object value) comparison (in string class).
- The equals() method is defined in the java.lang.Object class. By default, it does the reference comparison with == operator. So it is usually overridden in subclasses to provide the specific implementation.

<mark>**Question:** What Is Nashorn in Java8?

**Answer:** Nashorn is the new Javascript processing engine for the Java platform that shipped with Java 8. Until JDK 7, the Java platform used Mozilla Rhino for the same purpose, as a Javascript processing engine.

Nashorn provides better compliance with the ECMA normalized JavaScript specification and better runtime performance than its predecessor.

<mark>**Question:** Q2. What Is JJS?

**Answer:** In Java 8, jjs is the new executable or command line tool we use to execute Javascript code at the console.

<mark>**Question:** What Is a Stream? How Does It Differ From a Collection?

**Answer:** In simple terms, a stream is an iterator whose role is to accept a set of actions to apply on each of the elements it contains.

The stream represents a sequence of objects from a source such as a collection, which supports aggregate operations. They were designed to make collection processing simple and concise. Contrary to the collections, the logic of iteration is implemented inside the stream, so we can use methods like map and flatMap for performing a declarative processing.

Additionally, the Stream API is fluent and allows pipelining:

```
int sum = Arrays.stream(new int[]{1, 2, 3})
  .filter(i -> i >= 2)
  .map(i -> i * 3)
  .sum();
```

Another important distinction from collections is that streams are inherently lazily loaded and processed.

<mark>**Question:** What Is the Difference Between Intermediate and Terminal Operations?

**Answer:** We combine stream operations into pipelines to process streams. All operations are either intermediate or terminal.

Intermediate operations are those operations that return Stream itself, allowing for further operations on a stream.

These operations are always lazy, i.e. they do not process the stream at the call site. An intermediate operation can only process data when there is a terminal operation. Some of the intermediate operations are filter, map and flatMap.

In contrast, terminal operations terminate the pipeline and initiate stream processing. The stream is passed through all intermediate operations during terminal operation call. Terminal operations include forEach, reduce, Collect and sum.

To drive this point home, let's look at an example with side effects:

```
public static void main(String[] args) {
    System.out.println("Stream without terminal operation");
    
    Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
        System.out.println("doubling " + i);
        return i * 2;
    });
 
    System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
    }).sum();
}
```

The output will be as follows:

```
Stream without terminal operation
Stream with terminal operation
doubling 1
doubling 2
doubling 3
```

As we can see, the intermediate operations are only triggered when a terminal operation exists.

<mark>**Question:** What Is the Difference Between Map and flatMap Stream Operation?

**Answer:** There is a difference in signature between map and flatMap. Generally speaking, a map operation wraps its return value inside its ordinal type, while flatMap does not.

For example, in Optional, a map operation would return Optional<String> type, while flatMap would return String type.

So after mapping, we need to unwrap (read “flatten”) the object to retrieve the value, whereas after flat mapping, there is no such need as the object is already flattened. We apply the same concept to mapping and flat mapping in Stream.

Both map and flatMap are intermediate stream operations that receive a function and apply this function to all the elements of a stream.

The difference is that for the map, this function returns a value, but for flatMap, this function returns a stream. The flatMap operation “flattens” the streams into one.

Here's an example where we take a map of users' names and lists of phones and “flatten” it down to a list of phones of all the users using flatMap:

```
Map<String, List<String>> people = new HashMap<>();
people.put("John", Arrays.asList("555-1123", "555-3389"));
people.put("Mary", Arrays.asList("555-2243", "555-5264"));
people.put("Steve", Arrays.asList("555-6654", "555-3242"));

List<String> phones = people.values().stream()
  .flatMap(Collection::stream)
    .collect(Collectors.toList());
```

<mark>**Question:** What Is Stream Pipelining in Java 8?

**Answer:** Stream pipelining is the concept of chaining operations together. We do this by splitting the operations that can happen on a stream into two categories: intermediate operations and terminal operations.

Each intermediate operation returns an instance of Stream itself when it runs. Therefore, we can set up an arbitrary number of intermediate operations to process data, forming a processing pipeline.

There must then be a terminal operation which returns a final value and terminates the pipeline.

<mark>**Question:** Tell Us About the New Date and Time API in Java 8

**Answer:** The existing classes such as java.util.Date and SimpleDateFormatter aren’t thread-safe, leading to potential concurrency issues for users.

Poor API design is also a reality in the old Java Data API. Here's just a quick example: years in java.util.Date start at 1900, months start at 1, and days start at 0, which is not very intuitive.

These issues and several others have led to the popularity of third-party date and time libraries, such as Joda-Time.

In order to address these problems and provide better support in JDK, a new date and time API, which is free of these problems, has been designed for Java SE 8 under the package java.time.

<mark>**Question:** What Is Garbage Collection and What Are Its Advantages?

**Answer:** Garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects.

<mark>**Question:** Are There Any Disadvantages of Garbage Collection?

**Answer:** Yes. Whenever the garbage collector runs, it has an effect on the application's performance. This is because all other threads in the application have to be stopped to allow the garbage collector thread to effectively do its work.

However, this problem can be greatly reduced or even eliminated through skillful optimization and garbage collector tuning and using different GC algorithms.

<mark>**Question:** What Are Stack and Heap? What Is Stored in Each of These Memory Structures, and How Are They Interrelated?

**Answer:** The stack is a part of memory that contains information about nested method calls down to the current position in the program. It also contains all local variables and references to objects on the heap defined in currently executing methods.

This structure allows the runtime to return from the method knowing the address whence it was called, and also clear all local variables after exiting the method. Every thread has its own stack.

The heap is a large bulk of memory intended for allocation of objects. When you create an object with the new keyword, it gets allocated on the heap. However, the reference to this object lives on the stack.

<mark>**Question:** What Is Generational Garbage Collection and What Makes It a Popular Garbage Collection Approach?

**Answer:** Generational garbage collection can be loosely defined as the strategy used by the garbage collector where the heap is divided into a number of sections called generations, each of which will hold objects according to their “age” on the heap.

Whenever the garbage collector is running, the first step in the process is called marking. This is where the garbage collector identifies which pieces of memory are in use and which are not. This can be a very time-consuming process if all objects in a system must be scanned.

As more and more objects are allocated, the list of objects grows and grows leading to longer and longer garbage collection time. However, empirical analysis of applications has shown that most objects are short-lived.

With generational garbage collection, objects are grouped according to their “age” in terms of how many garbage collection cycles they have survived. This way, the bulk of the work spread across various minor and major collection cycles.

Today, almost all garbage collectors are generational. This strategy is so popular because, over time, it has proven to be the optimal solution.

<mark>**Question:** Describe in Detail How Generational Garbage Collection Works

**Answer:** To properly understand how generational garbage collection works, it is important to first remember how Java heap is structured to facilitate generational garbage collection.

The heap is divided up into smaller spaces or generations. These spaces are Young Generation, Old or Tenured Generation, and Permanent Generation.

The young generation hosts most of the newly created objects. An empirical study of most applications shows that majority of objects are quickly short lived and therefore, soon become eligible for collection. Therefore, new objects start their journey here and are only “promoted” to the old generation space after they have attained a certain “age”.

The term “age” in generational garbage collection refers to the number of collection cycles the object has survived.

The young generation space is further divided into three spaces: an Eden space and two survivor spaces such as Survivor 1 (s1) and Survivor 2 (s2).

The old generation hosts objects that have lived in memory longer than a certain “age”. The objects that survived garbage collection from the young generation are promoted to this space. It is generally larger than the young generation. As it is bigger in size, the garbage collection is more expensive and occurs less frequently than in the young generation.

The permanent generation or more commonly called, PermGen, contains metadata required by the JVM to describe the classes and methods used in the application. It also contains the string pool for storing interned strings. It is populated by the JVM at runtime based on classes in use by the application. In addition, platform library classes and methods may be stored here.

First, any new objects are allocated to the Eden space. Both survivor spaces start out empty. When the Eden space fills up, a minor garbage collection is triggered. Referenced objects are moved to the first survivor space. Unreferenced objects are deleted.

During the next minor GC, the same thing happens to the Eden space. Unreferenced objects are deleted and referenced objects are moved to a survivor space. However, in this case, they are moved to the second survivor space (S2).

In addition, objects from the last minor GC in the first survivor space (S1) have their age incremented and are moved to S2. Once all surviving objects have been moved to S2, both S1 and Eden space are cleared. At this point, S2 contains objects with different ages.

At the next minor GC, the same process is repeated. However this time the survivor spaces switch. Referenced objects are moved to S1 from both Eden and S2. Surviving objects are aged. Eden and S2 are cleared.

After every minor garbage collection cycle, the age of each object is checked. Those that have reached a certain arbitrary age, for example, 8, are promoted from the young generation to the old or tenured generation. For all subsequent minor GC cycles, objects will continue to be promoted to the old generation space.

This pretty much exhausts the process of garbage collection in the young generation. Eventually, a major garbage collection will be performed on the old generation which cleans up and compacts that space. For each major GC, there are several minor GCs.

<mark>**Question:** When Does an Object Become Eligible for Garbage Collection? Describe How the Gc Collects an Eligible Object?

**Answer:** An object becomes eligible for Garbage collection or GC if it is not reachable from any live threads or by any static references.

The most straightforward case of an object becoming eligible for garbage collection is if all its references are null. Cyclic dependencies without any live external reference are also eligible for GC. So if object A references object B and object B references Object A and they don't have any other live reference then both Objects A and B will be eligible for Garbage collection.

Another obvious case is when a parent object is set to null. When a kitchen object internally references a fridge object and a sink object, and the kitchen object is set to null, both fridge and sink will become eligible for garbage collection alongside their parent, kitchen.

<mark>**Question:** How Do You Trigger Garbage Collection from Java Code?

**Answer:** You, as Java programmer, can not force garbage collection in Java; it will only trigger if JVM thinks it needs a garbage collection based on Java heap size.

Before removing an object from memory garbage collection thread invokes finalize()method of that object and gives an opportunity to perform any sort of cleanup required. You can also invoke this method of an object code, however, there is no guarantee that garbage collection will occur when you call this method.

Additionally, there are methods like System.gc() and Runtime.gc() which is used to send request of Garbage collection to JVM but it’s not guaranteed that garbage collection will happen.

<mark>**Question:** What Happens When There Is Not Enough Heap Space to Accommodate Storage of New Objects?

**Answer:** If there is no memory space for creating a new object in Heap, Java Virtual Machine throws OutOfMemoryError or more specifically java.lang.OutOfMemoryError heap space.

<mark>**Question:** Is It Possible to «Resurrect» an Object That Became Eligible for Garbage Collection?

**Answer:** When an object becomes eligible for garbage collection, the GC has to run the finalize method on it. The finalize method is guaranteed to run only once, thus the GC flags the object as finalized and gives it a rest until the next cycle.

In the finalize method you can technically “resurrect” an object, for example, by assigning it to a static field. The object would become alive again and non-eligible for garbage collection, so the GC would not collect it during the next cycle.

The object, however, would be marked as finalized, so when it would become eligible again, the finalize method would not be called. In essence, you can turn this “resurrection” trick only once for the lifetime of the object. Beware that this ugly hack should be used only if you really know what you're doing — however, understanding this trick gives some insight into how the GC works.

<mark>**Question:** Describe Strong, Weak, Soft and Phantom References and Their Role in Garbage Collection.

**Answer:** Much as memory is managed in Java, an engineer may need to perform as much optimization as possible to minimize latency and maximize throughput, in critical applications. Much as it is impossible to explicitly control when garbage collection is triggered in the JVM, it is possible to influence how it occurs as regards the objects we have created.

Java provides us with reference objects to control the relationship between the objects we create and the garbage collector.

By default, every object we create in a Java program is strongly referenced by a variable:

```
StringBuilder sb = new StringBuilder();
```

In the above snippet, the new keyword creates a new StringBuilder object and stores it on the heap. The variable sb then stores a strong reference to this object. What this means for the garbage collector is that the particular StringBuilder object is not eligible for collection at all due to a strong reference held to it by sb. The story only changes when we nullify sb like this:

```
sb = null;
```

After calling the above line, the object will then be eligible for collection.

We can change this relationship between the object and the garbage collector by explicitly wrapping it inside another reference object which is located inside java.lang.ref package.

A soft reference can be created to the above object like this:

```
StringBuilder sb = new StringBuilder();
SoftReference<StringBuilder> sbRef = new SoftReference<>(sb);
sb = null;
```

In the above snippet, we have created two references to the StringBuilder object. The first line creates a strong reference sb and the second line creates a soft reference sbRef. The third line should make the object eligible for collection but the garbage collector will postpone collecting it because of sbRef.

The story will only change when memory becomes tight and the JVM is on the brink of throwing an OutOfMemory error. In other words, objects with only soft references are collected as a last resort to recover memory.

A weak reference can be created in a similar manner using WeakReference class. When sb is set to null and the StringBuilder object only has a weak reference, the JVM's garbage collector will have absolutely no compromise and immediately collect the object at the very next cycle.

A phantom reference is similar to a weak reference and an object with only phantom references will be collected without waiting. However, phantom references are enqueued as soon as their objects are collected. We can poll the reference queue to know exactly when the object was collected.

<mark>**Question:** Suppose We Have a Circular Reference (Two Objects That Reference Each Other). Could Such Pair of Objects Become Eligible for Garbage Collection and Why?

**Answer:** Yes, a pair of objects with a circular reference can become eligible for garbage collection. This is because of how Java's garbage collector handles circular references. It considers objects live not when they have any reference to them, but when they are reachable by navigating the object graph starting from some garbage collection root (a local variable of a live thread or a static field). If a pair of objects with a circular reference is not reachable from any root, it is considered eligible for garbage collection.

<mark>**Question:** How Are Strings Represented in Memory?

**Answer:** A String instance in Java is an object with two fields: a char[] value field and an int hash field. The value field is an array of chars representing the string itself, and the hash field contains the hashCode of a string which is initialized with zero, calculated during the first hashCode() call and cached ever since. As a curious edge case, if a hashCode of a string has a zero value, it has to be recalculated each time the hashCode() is called.

Important thing is that a String instance is immutable: you can't get or modify the underlying char[] array. Another feature of strings is that the static constant strings are loaded and cached in a string pool. If you have multiple identical String objects in your source code, they are all represented by a single instance at runtime.

<mark>**Question:** Q15. What Is a Stringbuilder and What Are Its Use Cases? What Is the Difference Between Appending a String to a Stringbuilder and Concatenating Two Strings with a + Operator? How Does Stringbuilder Differ from Stringbuffer?

**Answer:** StringBuilder allows manipulating character sequences by appending, deleting and inserting characters and strings. This is a mutable data structure, as opposed to the String class which is immutable.

When concatenating two String instances, a new object is created, and strings are copied. This could bring a huge garbage collector overhead if we need to create or modify a string in a loop. StringBuilder allows handling string manipulations much more efficiently.

StringBuffer is different from StringBuilder in that it is thread-safe. If you need to manipulate a string in a single thread, use StringBuilder instead.

<mark>**Question:** Q1. What Is a Generic Type Parameter?

**Answer:** Type is the name of a class or interface. As implied by the name, a generic type parameter is when a type can be used as a parameter in a class, method or interface declaration.

Let's start with a simple example, one without generics, to demonstrate this:

```
public interface Consumer {
    public void consume(String parameter)
}
```

In this case, the method parameter type of the consume() method is String. It is not parameterized and not configurable.

Now let's replace our String type with a generic type that we will call T. It is named like this by convention:

```
public interface Consumer<T> {
    public void consume(T parameter)
}
```

When we implement our consumer, we can provide the type that we want it to consume as an argument. This is a generic type parameter:

```
public class IntegerConsumer implements Consumer<Integer> {
    public void consume(Integer parameter)
}
```

In this case, now we can consume integers. We can swap out this type for whatever we require.

<mark>**Question:** Q2. What Are Some Advantages of Using Generic Types?

**Answer:** One advantage of using generics is avoiding casts and provide type safety. This is particularly useful when working with collections. Let's demonstrate this:

```
List list = new ArrayList();
list.add("foo");
Object o = list.get(0);
String foo = (String) o;
```

In our example, the element type in our list is unknown to the compiler. This means that the only thing that can be guaranteed is that it is an object. So when we retrieve our element, an Object is what we get back. As the authors of the code, we know it's a String, but we have to cast our object to one to fix the problem explicitly. This produces a lot of noise and boilerplate.

Next, if we start to think about the room for manual error, the casting problem gets worse. What if we accidentally had an Integer in our list?

```
list.add(1)
Object o = list.get(0);
String foo = (String) o;
```

In this case, we would get a ClassCastException at runtime, as an Integer cannot be cast to String.

Now, let's try repeating ourselves, this time using generics:

```
List<String> list = new ArrayList<>();
list.add("foo");
String o = list.get(0);    // No cast
Integer foo = list.get(0); // Compilation error
```

As we can see, by using generics we have a compile type check which prevents ClassCastExceptions and removes the need for casting.

The other advantage is to avoid code duplication. Without generics, we have to copy and paste the same code but for different types. With generics, we do not have to do this. We can even implement algorithms that apply to generic types.

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**
Threading/Concurrency <span id="Concurrency"></span>
----------------------------------------------------

[Back](#top)

**Runnable vs Callable**

The Runnable interface has a single run method. It represents a unit of computation that has to be run in a separate thread. The Runnable interface does not allow this method to return value or to throw unchecked exceptions.

The Callable interface has a single call method and represents a task that has a value. That's why the call method returns a value. It can also throw exceptions. Callable is generally used in ExecutorService instances to start an asynchronous task and then call the returned Future instance to get its value.

<mark>**Question:** Describe the Different States of a Thread and When Do the State Transitions Occur.

**Answer:** The state of a Thread can be checked using the Thread.getState() method. Different states of a Thread are described in the Thread.State enum. They are:

- NEW — a new Thread instance that was not yet started via Thread.start()
- RUNNABLE — a running thread. It is called runnable because at any given time it could be either running or waiting for the next quantum of time from the thread scheduler. A NEW thread enters the RUNNABLE state when you call Thread.start() on it
- BLOCKED — a running thread becomes blocked if it needs to enter a synchronized section but cannot do that due to another thread holding the monitor of this section
- WAITING — a thread enters this state if it waits for another thread to perform a particular action. For instance, a thread enters this state upon calling the Object.wait() method on a monitor it holds, or the Thread.join() method on another thread
- TIMED_WAITING — same as the above, but a thread enters this state after calling timed versions of Thread.sleep(), Object.wait(), Thread.join() and some other methods
- TERMINATED — a thread has completed the execution of its Runnable.run() method and terminated

<mark>**Question:** What Is a Daemon Thread, What Are Its Use Cases? How Can You Create a Daemon Thread?

**Answer:** A daemon thread is a thread that does not prevent JVM from exiting. When all non-daemon threads are terminated, the JVM simply abandons all remaining daemon threads. Daemon threads are usually used to carry out some supportive or service tasks for other threads, but you should take into account that they may be abandoned at any time.

To start a thread as a daemon, you should use the setDaemon() method before calling start():

```
Thread daemon = new Thread(()
  -> System.out.println("Hello from daemon!"));
daemon.setDaemon(true);
daemon.start();
```

Curiously, if you run this as a part of the main() method, the message might not get printed. This could happen if the main() thread would terminate before the daemon would get to the point of printing the message. You generally should not do any I/O in daemon threads, as they won't even be able to execute their finally blocks and close the resources if abandoned.

<mark>**Question:** What Is the Thread’s Interrupt Flag? How Can You Set and Check It? How Does It Relate to the Interruptedexception?

**Answer:** The interrupt flag, or interrupt status, is an internal Thread flag that is set when the thread is interrupted. To set it, simply call thread.interrupt() on the thread object.

If a thread is currently inside one of the methods that throw InterruptedException (wait, join, sleep etc.), then this method immediately throws InterruptedException. The thread is free to process this exception according to its own logic.

If a thread is not inside such method and thread.interrupt() is called, nothing special happens. It is thread's responsibility to periodically check the interrupt status using static Thread.interrupted() or instance isInterrupted() method. The difference between these methods is that the static Thread.interrupted() clears the interrupt flag, while isInterrupted() does not.

<mark>**Question:** What Are Executor and Executorservice? What Are the Differences Between These Interfaces?

**Answer:** Executor and ExecutorService are two related interfaces of java.util.concurrent framework. Executor is a very simple interface with a single execute method accepting Runnable instances for execution. In most cases, this is the interface that your task-executing code should depend on.

ExecutorService extends the Executor interface with multiple methods for handling and checking the lifecycle of a concurrent task execution service (termination of tasks in case of shutdown) and methods for more complex asynchronous task handling including Futures.

<mark>**Question:** What Are the Available Implementations of Executorservice in the Standard Library?

**Answer:** The ExecutorService interface has three standard implementations:

- ThreadPoolExecutor — for executing tasks using a pool of threads. Once a thread is finished executing the task, it goes back into the pool. If all threads in the pool are busy, then the task has to wait for its turn.

- ScheduledThreadPoolExecutor allows to schedule task execution instead of running it immediately when a thread is available. It can also schedule tasks with fixed rate or fixed delay.

- ForkJoinPool is a special ExecutorService for dealing with recursive algorithms tasks. If you use a regular ThreadPoolExecutor for a recursive algorithm, you will quickly find all your threads are busy waiting for the lower levels of recursion to finish. The ForkJoinPool implements the so-called work-stealing algorithm that allows it to use available threads more efficiently.

<mark>**Question:** What Is Java Memory Model (Jmm)? Describe Its Purpose and Basic Ideas.

**Answer:** Java Memory Model is a part of Java language specification described in Chapter 17.4. It specifies how multiple threads access common memory in a concurrent Java application, and how data changes by one thread are made visible to other threads. While being quite short and concise, JMM may be hard to grasp without strong mathematical background.

The need for memory model arises from the fact that the way your Java code is accessing data is not how it actually happens on the lower levels. Memory writes and reads may be reordered or optimized by the Java compiler, JIT compiler, and even CPU, as long as the observable result of these reads and writes is the same.

This can lead to counter-intuitive results when your application is scaled to multiple threads because most of these optimizations take into account a single thread of execution (the cross-thread optimizers are still extremely hard to implement). Another huge problem is that the memory in modern systems is multilayered: multiple cores of a processor may keep some non-flushed data in their caches or read/write buffers, which also affects the state of the memory observed from other cores.

To make things worse, the existence of different memory access architectures would break the Java's promise of “write once, run everywhere”. Happily for the programmers, the JMM specifies some guarantees that you may rely upon when designing multithreaded applications. Sticking to these guarantees helps a programmer to write multithreaded code that is stable and portable between various architectures.

The main notions of JMM are:

- Actions, these are inter-thread actions that can be executed by one thread and detected by another thread, like reading or writing variables, locking/unlocking monitors and so on

- Synchronization actions, a certain subset of actions, like reading/writing a volatile variable, or locking/unlocking a monitor

- Program Order (PO), the observable total order of actions inside a single thread

- Synchronization Order (SO), the total order between all synchronization actions — it has to be consistent with Program Order, that is, if two synchronization actions come one before another in PO, they occur in the same order in SO

- synchronizes-with (SW) relation between certain synchronization actions, like unlocking of monitor and locking of the same monitor (in another or the same thread)
Happens-before Order — combines PO with SW (this is called transitive closure in set theory) to create a partial ordering of all actions between threads. If one action

- happens-before another, then the results of the first action are observable by the second action (for instance, write of a variable in one thread and read in another)
Happens-before consistency — a set of actions is HB-consistent if every read observes either the last write to that location in the happens-before order, or some other write via data race
- Execution — a certain set of ordered actions and consistency rules between them

For a given program, we can observe multiple different executions with various outcomes. But if a program is correctly synchronized, then all of its executions appear to be sequentially consistent, meaning you can reason about the multithreaded program as a set of actions occurring in some sequential order. This saves you the trouble of thinking about under-the-hood reorderings, optimizations or data caching.

<mark>**Question:** What Is a Volatile Field and What Guarantees Does the Jmm Hold for Such Field?

**Answer:** A volatile field has special properties according to the Java Memory Model (see Q9). The reads and writes of a volatile variable are synchronization actions, meaning that they have a total ordering (all threads will observe a consistent order of these actions). A read of a volatile variable is guaranteed to observe the last write to this variable, according to this order.

If you have a field that is accessed from multiple threads, with at least one thread writing to it, then you should consider making it volatile, or else there is a little guarantee to what a certain thread would read from this field.

Another guarantee for volatile is atomicity of writing and reading 64-bit values (long and double). Without a volatile modifier, a read of such field could observe a value partly written by another thread.

<mark>**Question:** Which of the Following Operations Are Atomic?

**Answer:**

- writing to a non-volatile int;
- writing to a volatile int;
- writing to a non-volatile long;
- writing to a volatile long;
- incrementing a volatile long?
A write to an int (32-bit) variable is guaranteed to be atomic, whether it is volatile or not. A long (64-bit) variable could be written in two separate steps, for example, on 32-bit architectures, so by default, there is no atomicity guarantee. However, if you specify the volatile modifier, a long variable is guaranteed to be accessed atomically.

The increment operation is usually done in multiple steps (retrieving a value, changing it and writing back), so it is never guaranteed to be atomic, wether the variable is volatile or not. If you need to implement atomic increment of a value, you should use classes AtomicInteger, AtomicLong etc.

<mark>**Question:** What Special Guarantees Does the Jmm Hold for Final Fields of a Class?

**Answer:** JVM basically guarantees that final fields of a class will be initialized before any thread gets hold of the object. Without this guarantee, a reference to an object may be published, i.e. become visible, to another thread before all the fields of this object are initialized, due to reorderings or other optimizations. This could cause racy access to these fields.

This is why, when creating an immutable object, you should always make all its fields final, even if they are not accessible via getter methods.

<mark>**Question:** What Is the Meaning of a Synchronized Keyword in the Definition of a Method? of a Static Method? Before a Block?

**Answer:** The synchronized keyword before a block means that any thread entering this block has to acquire the monitor (the object in brackets). If the monitor is already acquired by another thread, the former thread will enter the BLOCKED state and wait until the monitor is released.

```
synchronized(object) {
    // ...
}
```

A synchronized instance method has the same semantics, but the instance itself acts as a monitor.

```
synchronized void instanceMethod() {
    // ...
}
```

For a static synchronized method, the monitor is the Class object representing the declaring class.

```
static synchronized void staticMethod() {
    // ...
}
```

<mark>**Question:** If Two Threads Call a Synchronized Method on Different Object Instances Simultaneously, Could One of These Threads Block? What If the Method Is Static?

**Answer:** If the method is an instance method, then the instance acts as a monitor for the method. Two threads calling the method on different instances acquire different monitors, so none of them gets blocked.

If the method is static, then the monitor is the Class object. For both threads, the monitor is the same, so one of them will probably block and wait for another to exit the synchronized method.

<mark>**Question:**  What Is the Purpose of the Wait, Notify and Notifyall Methods of the Object Class?

**Answer:** A thread that owns the object's monitor (for instance, a thread that has entered a synchronized section guarded by the object) may call object.wait() to temporarily release the monitor and give other threads a chance to acquire the monitor. This may be done, for instance, to wait for a certain condition.

When another thread that acquired the monitor fulfills the condition, it may call object.notify() or object.notifyAll() and release the monitor. The notify method awakes a single thread in the waiting state, and the notifyAll method awakes all threads that wait for this monitor, and they all compete for re-acquiring the lock.

The following BlockingQueue implementation shows how multiple threads work together via the wait-notify pattern. If we put an element into an empty queue, all threads that were waiting in the take method wake up and try to receive the value. If we put an element into a full queue, the put method waits for the call to the get method. The get method removes an element and notifies the threads waiting in the put method that the queue has an empty place for a new item.

```
public class BlockingQueue<T> {

    private List<T> queue = new LinkedList<T>();

    private int limit = 10;

    public synchronized void put(T item) {
        while (queue.size() == limit) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }
    
}
```

<mark>**Question:** Describe the Conditions of Deadlock, Livelock, and Starvation. Describe the Possible Causes of These Conditions.

**Answer:**

- Deadlock is a condition within a group of threads that cannot make progress because every thread in the group has to acquire some resource that is already acquired by another thread in the group. The most simple case is when two threads need to lock both of two resources to progress, the first resource is already locked by one thread, and the second by another. These threads will never acquire a lock to both resources and thus will never progress.

- Livelock is a case of multiple threads reacting to conditions, or events, generated by themselves. An event occurs in one thread and has to be processed by another thread. During this processing, a new event occurs which has to be processed in the first thread, and so on. Such threads are alive and not blocked, but still, do not make any progress because they overwhelm each other with useless work.

- Starvation is a case of a thread unable to acquire resource because other thread (or threads) occupy it for too long or have higher priority. A thread cannot make progress and thus is unable to fulfill useful work.

<mark>**Question:** Describe the Purpose and Use-Cases of the Fork/Join Framework.

**Answer:** The fork/join framework allows parallelizing recursive algorithms. The main problem with parallelizing recursion using something like ThreadPoolExecutor is that you may quickly run out of threads because each recursive step would require its own thread, while the threads up the stack would be idle and waiting.

The fork/join framework entry point is the ForkJoinPool class which is an implementation of ExecutorService. It implements the work-stealing algorithm, where idle threads try to “steal” work from busy threads. This allows to spread the calculations between different threads and make progress while using fewer threads than it would require with a usual thread pool.

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**

<mark>**Question:**

**Answer:**
Others
------
