The main difference between Either and Try is that Either is a general-purpose type for representing success or failure,
while Try is specifically designed for handling exceptions.

Either is a monadic type that can represent two possible states: either a success value of type L or a failure value of
type R. It is typically used to model the result of an operation that may either succeed or fail, such as parsing a
string into an integer or reading a file from disk.

Try is a monadic type that represents a computation that may either succeed or fail due to an exception. It is typically
used to wrap code that may throw an exception, and to provide a way to handle the exception without breaking the flow of
the program.

Here is a table that summarizes the key differences between Either and Try:

| Feature            | 	Either            | Try                                    |
|--------------------|--------------------|----------------------------------------|
| Represents         | Success or failure | Success or failure due to an exception |
| General-purpose    | Yes                | No                                     |
| Exception handling | No                 | Yes                                    |


Monadic container types are typically defined by two operations:

Unit: A function that takes a value of the input type and wraps it in a monadic value.
Bind: A combinator that takes a monadic value and a function that produces a new monadic value, and applies the function to the value in the first monadic value, producing a new monadic value.
