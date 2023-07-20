### Build
```shell
mvn package
```

### Test
```shell
mvn test
```

### Run
```shell
java -cp target/orderProcessor-1.0-SNAPSHOT.jar com.cake.Main
```

### Problem
You get several values from an object and then pass them as parameters to a method.

#### Benifits
- Instead of a hodgepodge of parameters, you see a single object with a comprehensible name.
- If the method needs more data from an object, you won’t need to rewrite all the places where the method is used—merely inside the method itself.

#### Drawbacks
- previously the method could get data from many different sources but now, because of refactoring, we’re limiting its use to only objects with a particular interface.


### Reference
1. http://silab.fon.bg.ac.rs/wp-content/uploads/2016/10/Refactoring-Improving-the-Design-of-Existing-Code-Addison-Wesley-Professional-1999.pdf
2. https://www.youtube.com/watch?v=PJjHfa5yxlU
3. https://www.industriallogic.com/img/blog/2005/09/smellstorefactorings.pdf
4. https://refactoring.guru/refactoring/techniques
