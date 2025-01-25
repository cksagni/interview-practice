# Design principles :-
* Identify the aspects of your application that vary and separate them from what stays the same.
    * Take what varies and "encapsulate" it so it won't affect the rest of your code.
    * This will result in fewer unintended consequences of code changes and more flexibility in your system.
* Program to an interface, not to an implementation.
* Favour composition over inheritance.