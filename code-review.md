**Java code/Oops naming convention**
- package: lowercase
- Interface
    - first letter caps.
    - not real world entity. e.g. Vehicle, Animal, Furniture etc. 
- class
    - first letter caps. 
    - real world entity. e.g. car, dog, table etc.    
    - noun
- method name: 
    - starts with lowercase.
    - behaviour of the object so needs to be verb or combination of verbs. e.g. getSpeed, bark, tableColor etc.
- variable: meaningful first letter lowercase. e.g. speedOfCar, ageOfDog, tableColor etc.
- Constant: all caps


**NullPointer**
 - use Optional instead of null checks.
 - In spring, use @NotNull, @Nullable etc.

Choice of correct data structures.

Correct access modifiers. public, protected, private. Class members must be private.

Use Underscores in lengthy Numeric Literals.  int num = 58356823; int num = 58_356_823;


Never leave a Catch Blocks empty

Use StringBuilder or StringBuffer for String Concatenation. Prefferably StringBuilder

Avoid Redundant Initializations: there is default initialization in Java

Float or Double: use Double if precision is important or go with Float as it takes half space.

Always use double quotes (not single quotes).

Return Empty Collections instead of returning Null elements.

Ordering Class Members by Scopes. private, then, protected, then, public 

Use Constant where possible and keep them in a constant file.

Avoid using for loops with indexes. Instead use the enhanced version.

Try to restrict the number of parameters a method accepts, three parameters can be one good choice.










