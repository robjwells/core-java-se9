# Exercise 5.10

> The methods of the Scanner and PrintWriter classes do not throw checked
> exceptions to make them easier to use for beginning programmers.

> How do you find out whether errors occurred during reading or writing?

By inspecting the documentation for **Throws:** sections for each method.
(And trusting it’s complete.) Otherwise by inspecting the source code(!).

> Note that the constructors can throw checked exceptions.
> Why does that defeat the goal of making the classes easier to use for beginners?

Because they will have to put in the ceremony of handling the checked exception
when they first create the class (rather than, given the case of the methods
above, when they interact with the class).
