

// In this exercise we will look at how we can use coroutines to avoid blocking the UI thread

// But first, there's a few things you need to know:

// All the coroutine launchers can take a coroutine context/dispatcher as a parameter. This decides which thread (pool) the coroutine will run in.
// The most important dispatchers are:
// * Dispatchers.Main - A coroutine dispatcher that is confined to the Main thread operating with UI objects. Usually such dispatcher is single-threaded.
// * Dispatchers.Default - The default CoroutineDispatcher that is used by all standard builders like launch, async,
//                         etc if no dispatcher nor any other ContinuationInterceptor is specified in their context.
//                         It is backed by a shared pool of threads on JVM. By default, the maximal level of parallelism used by this
//                         dispatcher is equal to the number of CPU cores, but is at least two.
// * Dispatchers.IO - The CoroutineDispatcher that is designed for offloading blocking IO tasks to a shared pool of threads.
//                    It defaults to the limit of 64 threads or the number of cores (whichever is larger).

// In summary, use Main to update UI, Default to do cpu intensive tasks, and IO for database and http calls.

// You can temporary switch to another context with:
// withContext(coroutineContext) {} - Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCoroutinesSequential()
}

private suspend fun heavyCalculation(): Int {
    TODO("Implement so you can call this from a coroutine running on the UI (Main) Dispatcher, " +
            "without blocking the UI Thread, and without starting another coroutine" +
            "This function should call the heavyCalculationBlocking() function")
}

private suspend fun anotherHeavyCalculation(): Int {
    TODO("Implement so you can call this from a coroutine running on the UI (Main) Dispatcher, " +
            "without blocking the UI Thread, and without starting another coroutine" +
            "This function should call the anotherHeavyCalculationBlocking() function")
}

suspend fun combineResults(first: Int, second: Int): Int {
    TODO("Implement so you can call this from a coroutine running on the UI (Main) Dispatcher, " +
            "without blocking the UI Thread, and without starting another coroutine" +
            "This function should call the combineResultsBlocking() function")
}


private fun calculateAndCombineCoroutinesSequential() {
    // TODO:
    // Implement the suspend versions of the calculations above
    // In this method, launch a coroutine on the Main Dispatcher
    // From that coroutine:
    // first call heavyCalculation, and then call updateUi with the result
    // then call anotherHeavyCalculation, and then call updateUi with the result
    // Lastly call combineResults, and then call updateUi with the result
    // The output from main should be similar to the output from the callback based version in 02B
}