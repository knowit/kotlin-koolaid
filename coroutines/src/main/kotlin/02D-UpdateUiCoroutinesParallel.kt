import kotlinx.coroutines.runBlocking

// In this exercise, we will do some of the work in parallel

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCoroutinesParallel()
}

private fun calculateAndCombineCoroutinesParallel() {
    // TODO:

    while (true) {
        runBlocking {



        }
    }
    // In this version, we want to do the two first calculations in parallel
    //
    // So, first launch a coroutine on the Main Dispatcher
    // From that coroutine:
    // Launch two more coroutines, one for heavyCalculationBlocking and one for anotherHeavyCalculationBlocking both using the async coroutine launcher
    // Make sure they don't run on the UI thread.
    // Since we want to optimize, we don't call updateUi with the intermediate values
    // Lastly call combineResults (from 02C) with the values from the coroutines, and then call updateUi with the result
    // This should make the calculations in total much quicker then 02C
}