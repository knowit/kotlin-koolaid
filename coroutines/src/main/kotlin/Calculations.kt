import kotlin.concurrent.thread

private fun heavyCalculation(): Int =
    (1..5).map {
        println("Calculating part $it ...")
        Thread.sleep(1000)
        it
    }.sum()

fun heavyCalculationBlocking(): Int {
    println("Heavy calculation job started on ${Thread.currentThread().name}")
    val result = heavyCalculation()
    println("Heavy calculation job done")
    return result
}

fun heavyCalculationAsync(callback: (Int) -> Unit) {
    thread(start = true) {
        println("Async heavy calculation job started on ${Thread.currentThread().name}")
        val result = heavyCalculation()
        println("Async heavy calculation job done")
        callback(result)
    }
}

private fun anotherHeavyCalculation(): Int =
    (6..10).map {
        println("Calculating part $it ...")
        Thread.sleep(1000)
        it
    }.sum()

fun anotherHeavyCalculationBlocking(): Int {
    println("Start another heavy calculation job on ${Thread.currentThread().name}")
    val result = anotherHeavyCalculation()
    println("Another heavy calculation job done")
    return result
}

fun anotherHeavyCalculationAsync(callback: (Int) -> Unit) {
    thread(start = true) {
        println("Another async heavy calculation job started on ${Thread.currentThread().name}")
        val result = anotherHeavyCalculation()
        println("Another async heavy calculation job done")
        callback(result)
    }
}

fun combineResultsBlocking(first: Int, second: Int): Int {
    println("Combining result on ${Thread.currentThread().name}")
    Thread.sleep(3000)
    return first + second
}

fun combineResultsAsync(first: Int, second: Int, callback: (Int) -> Unit) {
    thread(start = true) {
        println("Combining result on ${Thread.currentThread().name}")
        Thread.sleep(3000)
        callback(first + second)
    }
}
