package misc

import tasks.StreamTasks
import org.junit.jupiter.api.Test
import tasks.MiscTasks
import kotlin.test.assertEquals

class MiscTests {

    private val miscTasks = MiscTasks()

    @Test
    fun `test numbers string`() {
        val testInput = listOf(1,2,3,44,99)
        val correctResult = "Numbers: 12345678910"

        assertEquals(correctResult, miscTasks.buildANumberString(testInput))
    }
}