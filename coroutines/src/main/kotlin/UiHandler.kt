import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

private const val UI_THREAD_NAME = "UI Thread"
private var running = true

private val blockingQueue: BlockingQueue<() -> Unit> = LinkedBlockingDeque()
private fun queueUiUpdateJob() {
    runOnUI {
        Thread.sleep(1000)
        updateUi("Another UI update")
        queueUiUpdateJob()
    }
}

fun startUiHandler() {
    thread(start = true, name = UI_THREAD_NAME) {
        while (running) {
            blockingQueue.take()()
        }
    }
    // This implements the Main Dispatcher, so we easily can run coroutines on the UI thread.
    Dispatchers.setMain(object : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            runOnUI { block.run() }
        }
    })
    queueUiUpdateJob()
}

/**
 * Run a lambda on the UI Thread.
 */
fun runOnUI(job: () -> Unit) {
    blockingQueue.put(job)
}

/**
 * Simulate (/pretend) doing some kind of update to the UI. This function must be called from the UI thread.
 *
 * @param text A string that indicates that some kind of a UI update have happened.
 *             This string is printed to the standard output stream from the UI thread.
 */
fun updateUi(text: String) {
    if (Thread.currentThread().name != UI_THREAD_NAME) {
        running = false
        throw IllegalThreadStateException("Trying to update UI from outside of the UI thread")
    }
    println("UI thread: $text")
}
