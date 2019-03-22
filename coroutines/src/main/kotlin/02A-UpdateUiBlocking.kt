
// The rest of the code examples and tasks in this directory is based on a
// very simple simulation of an application with one UI thread. Imagine that the
// UI thread have to run one task each second to update the UI.
// This means that if we do any other calculations on the same thread, the
// UI will not be updated while this happens. You can look at the code in UiHandler.kt
// to see how this is implemented. In Calculations.kt there's a few functions
// that simulates blocking and long running operations.

// Blocking the UI thread

// Imagine that we want to do some long running tasks and update the UI
// with the result. (This can both be cpu intensive tasks, http calls,
// or database operations.)

// In this example we block the UI from updating while we wait for the calculations.

// This is just meant as an example of what happens when blocking, and how to
// wrongly perform long running tasks.

// In all of these main functions, we first start the startUiHandler, that will "update" the UI
// (by printing "UI thread: Another UI update") every second, unless the UI thread is blocked.


fun main() {
    startUiHandler()
    Thread.sleep(3000)
    runOnUi { calculateAndCombineBlocking() }
}

private fun calculateAndCombineBlocking() {
    val firstResult = heavyCalculationBlocking()
    updateUi("Result from heavy calculation is: $firstResult")
    val secondResult = anotherHeavyCalculationBlocking()
    updateUi("Result from another heavy calculation is: $secondResult")
    val combined = combineResultsBlocking(firstResult, secondResult)
    updateUi("Combined result is: $combined")
}
