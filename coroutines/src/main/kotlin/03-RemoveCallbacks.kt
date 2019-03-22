
// In this exercise we will look at how we can use coroutines to get a nicer way to work with callback based code/libraries.

// suspendCoroutine - Obtains the current continuation instance inside suspend functions and suspends currently running coroutine.
// Continuation.resume() - Resumes the execution of the corresponding coroutine passing value as the return value of the last suspension point.

private suspend fun heavyCalculation(): Int {
    TODO("Use suspendCoroutine to call heavyCalculationAsync")
}

private suspend fun anotherHeavyCalculation(): Int {
    TODO("Use suspendCoroutine to call anotherHeavyCalculationAsync")
}

private suspend fun combineResult(first: Int, second: Int): Int {
    TODO("Use suspendCoroutine to call combineResultAsync")
}

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCoroutinesSequential()
}


private fun calculateAndCombineCoroutinesSequential() {
    // Implement the suspend versions of the callback based calculations above
    // This method should be implemented similar to 02C, but with using the methods above
}