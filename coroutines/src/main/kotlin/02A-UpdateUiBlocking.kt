
//  Blocking UI thread



fun main() {
    startUiHandler()
    Thread.sleep(3000)
    runOnUI { calculateAndCombineBlocking() }
}

private fun calculateAndCombineBlocking() {
    val firstResult = heavyCalculationBlocking()
    updateUi("Result from heavy calculation is: $firstResult")
    val secondResult = anotherHeavyCalculationBlocking()
    updateUi("Result from another heavy calculation is: $secondResult")
    val combined = combineResultsBlocking(firstResult, secondResult)
    updateUi("Combined result is: $combined")
}
