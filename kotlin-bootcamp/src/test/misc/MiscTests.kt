package misc

import org.junit.jupiter.api.Test
import tasks.MiscTasks
import kotlin.test.assertEquals

class MiscTests {

    private val miscTasks = MiscTasks()

    @Test
    fun `test stringmaker string`() {
        val testInput = "yolo"
        val correctResult = "java.lang.String : yolo"

        assertEquals(correctResult, miscTasks.buildFancyToString(testInput))
    }

    @Test
    fun `test stringmaker boolean`() {
        val testInput = true
        val correctResult = "java.lang.Boolean : true"

        assertEquals(correctResult, miscTasks.buildFancyToString(testInput))
    }

    @Test
    fun `test stringmaker integer`() {
        val testInput = 2
        val correctResult = "java.lang.Integer : 2"

        assertEquals(correctResult, miscTasks.buildFancyToString(testInput))
    }
}