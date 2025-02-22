# Design principles :-
* Identify the aspects of your application that vary and separate them from what stays the same.
    * Take what varies and "encapsulate" it so it won't affect the rest of your code.
    * This will result in fewer unintended consequences of code changes and more flexibility in your system.
* Program to an interface, not to an implementation.
* Favour composition over inheritance.
* patterns allow some part of a system to vary independently of all other parts.
* By not knowing too much about other objects, we can create
  designs that can handle change better. Designs that have more
  flexibility. --> ***Strive for loosely coupled designs
  between objects that interact.***







## Design Patterns:-

### Strategy Design Pattern:-
* **The Strategy Pattern defines a family of algorithms, encapsulates each one, 
  and makes them interchangeable. Strategy lets the algorithm vary 
  independently of clients that use it.**
* Think of different strategies as a family of algorithms.
* We can extend this technique to other problems and can interchange the final algorithm at runtime based on some criteria.
* When different algorithms implement same interface, they become easily interchangeable during runtime.



### Observer Design Pattern:-
* **The Observer Pattern defines a one-to-many dependency between objects so that
  when one object changes state, all of its dependents are notified and updated automatically.**

