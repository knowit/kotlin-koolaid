import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Uncomment one function at a time. For each, look at the function, and try to guess how the printed output will be,
// and approximately how many milliseconds main will run for. Then run main to check your guess/estimate.

// You can run heavyCalculationBlocking once first, to check how long it runs for (should be about 5 seconds)

// In IntelliJ you can run main by clicking on the Play icon next to the "fun main() {" line.

fun main() {
    val time = measureTimeMillis {
        heavyCalculationBlocking()

        // f01startWithLaunch()
        // f02startWithLaunchThenSleep()
        // f03startWithRunBlocking()
        // f04launchInsideRunBlocking()
        // f05launchAndJoinInsideRunBlocking()
        // f06startWithAsync()
        // f06startWithAsyncInParallel()
    }
    println("Main took $time milliseconds")
}

// CoroutineScope.launch {} - Launches new coroutine without blocking current thread and
// returns a reference to the coroutine as a Job.

fun f01startWithLaunch() {
    println("Start")
    GlobalScope.launch {
        println("Start of launch")
        val result = heavyCalculationBlocking()
        println("Result from longRunningCalculation is: $result")
        println("End of launch")
    }
    println("End")
}

fun f02startWithLaunchThenSleep() {
    println("Start")
    GlobalScope.launch {
        println("Start of launch")
        val result = heavyCalculationBlocking()
        println("Result from longRunningCalculation is: $result")
        println("End of launch")
    }
    println("When will this line be printed?")
    Thread.sleep(8000)
    println("End")
}


// runBlocking - Runs new coroutine and blocks current thread interruptibly until its completion.
// This function should not be used from coroutine. It is designed to bridge regular blocking code
// to libraries that are written in suspending style, to be used in main functions and in tests.

fun f03startWithRunBlocking() {
    println("Start")
    runBlocking {
        println("Start of runBlocking")
        val result = heavyCalculationBlocking()
        println("Result from longRunningCalculation is: $result")
        println("End of runBlocking")
    }
    println("End")
}


// Nested coroutines

fun f04launchInsideRunBlocking() {
    println("Start")
    runBlocking {
        println("Start of runBlocking")
        GlobalScope.launch {
            println("Start of launch")
            val result = heavyCalculationBlocking()
            println("Result from heavyCalculationBlocking is: $result")
            println("End of launch")
        }
        println("End of runBlocking")
    }
    println("End")
}

// Job.join() - Suspends coroutine until this job is complete.

fun f05launchAndJoinInsideRunBlocking() {
    println("Start")
    runBlocking {
        println("Start of runBlocking")
        val job: Job = GlobalScope.launch {
            println("Start of launch")
            val result = heavyCalculationBlocking()
            println("Result from heavyCalculationBlocking is: $result")
            println("End of launch")
        }
        println("Where will this line show up?")
        job.join()
        println("End of runBlocking")
    }
    println("End")
}

// CoroutineScope.async {} - Creates new coroutine and returns its future result as an implementation of Deferred.

// Deferred.await() - Awaits for completion of this value without blocking a thread and resumes
// when deferred computation is complete, returning the resulting value.

fun f06startWithAsync() {
    println("Start")
    runBlocking {
        println("Start of runBlocking")
        val deferred = GlobalScope.async { heavyCalculationBlocking() }
        println("Result from heavyCalculationBlocking is: ${deferred.await()}")
        println("End of runBlocking")
    }
    println("End")
}

// Guess approximately how long main will run for here?
fun f07startWithAsyncInParallel() {
    println("Start")
    runBlocking {
        println("Start of runBlocking")
        val deferredList = (1..5).map { GlobalScope.async { heavyCalculationBlocking() } }
        val total = deferredList.map { it.await() }.sum()
        println("Result from multiple heavyCalculationBlocking is: $total")
        println("End of runBlocking")
    }
    println("End")
}