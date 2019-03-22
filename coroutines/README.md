# Coroutines

This is a mix of some code examples and some exercises that is meant to give a
short introduction to Kotlin coroutines.

### What is a coroutine

According to Wikipedia: "Coroutines are computer program components that 
generalize subroutines for non-preemptive multitasking, by allowing execution 
to be suspended and resumed."

According to Donald Knuth, Melvin Conway coined the term coroutine in 1958 when he applied 
it to construction of an assembly program.

In Kotlin coroutines is mostly implemented as library functions (kotlinx.coroutines).
While the *suspend* keyword is part of the core language.

The most important aspect of coroutines is that a coroutine is able to suspend the current
execution, run another coroutine for a while, and then resume the first one.

### Builders

In the file 01-StartingCoroutines.kt there's some examples on how the
different coroutine builders work.

### Asynchronous / non-blocking programming

In the rest of the files in this project, we look at how we can utilize coroutines
to do asynchronous and non-blocking programming.

### Structured concurrency

In short, all coroutines must run in a scope. In these examples/tasks we start all coroutines
in *GlobalScope*, which is a scope that follows the lifecycle of the application.
In actual software you would create multiple scopes with different lifecycles, so
you can stop and clean up all coroutines in a spesific scope when a lifecycle ends.

See more: https://kotlinlang.org/docs/reference/coroutines/basics.html#structured-concurrency  

### Docs

https://kotlinlang.org/docs/reference/coroutines-overview.html