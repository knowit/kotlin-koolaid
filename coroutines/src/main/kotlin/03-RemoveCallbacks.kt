import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// In this exercise we will look at how we can use coroutines to get a nicer way to work with callback based code/libraries.

// suspendCoroutine - Obtains the current continuation instance inside suspend functions and suspends currently running coroutine.
// Continuation.resume() - Resumes the execution of the corresponding coroutine passing value as the return value of the last suspension point.

private suspend fun heavyCalculation(): Int = suspendCoroutine { continuation ->
    heavyCalculationAsync { result ->
        continuation.resume(result)
    }
}

private suspend fun anotherHeavyCalculation(): Int = suspendCoroutine { continuation ->
    anotherHeavyCalculationAsync { result ->
        continuation.resume(result)
    }
}

private suspend fun combineResult(first: Int, second: Int): Int = suspendCoroutine { continuation ->
    combineResultsAsync(first, second) { result ->
        continuation.resume(result)
    }
}

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCoroutinesSequential()
}


private fun calculateAndCombineCoroutinesSequential() {
    GlobalScope.launch(Dispatchers.Main) {
        val firstResult = heavyCalculation()
        updateUi("First result is: $firstResult")
        val secondResult = anotherHeavyCalculation()
        updateUi("Second result is: $secondResult")
        updateUi("Combined result is: ${combineResults(firstResult, secondResult)}")
    }
}