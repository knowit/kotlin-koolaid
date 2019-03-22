import kotlinx.coroutines.*

// In this exercise, we will do some of the work in parallel

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCoroutinesParallel()
}

private fun calculateAndCombineCoroutinesParallel() {
    GlobalScope.launch(Dispatchers.Main) {
        val firstDeferred = async(Dispatchers.IO) { heavyCalculationBlocking() }
        val secondDeferred = async(Dispatchers.IO) { anotherHeavyCalculationBlocking() }
        updateUi("Combined result is: ${combineResults(firstDeferred.await(), secondDeferred.await())}")
    }
}