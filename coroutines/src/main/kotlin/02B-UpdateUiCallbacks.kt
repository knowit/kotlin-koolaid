
// This show one example of how we could use background threads and callbacks to avoid blocking UI thread

// It works much better than the blocking example, but the code ends up being kind of messy.

fun main() {
    startUiHandler()
    Thread.sleep(3000)
    calculateAndCombineCallbacks()
}

private fun calculateAndCombineCallbacks() {
    heavyCalculationAsync { firstResult ->
        runOnUI {
            updateUi("Result from heavy calculation is: $firstResult")
            anotherHeavyCalculationAsync { secondResult ->
                runOnUI {
                    updateUi("Result from another heavy calculation is: $secondResult")
                    combineResultsAsync(firstResult, secondResult) { combined ->
                        runOnUI {
                            updateUi("Combined result is: $combined")
                        }
                    }
                }
            }
        }
    }
}
