package streams

import tasks.StreamTasks
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StreamTests {

    private val streamFunctions = StreamTasks()

    @Test
    fun `test sum of list`() {
        val testInput = listOf(1, 2, 3, 4, 5)

        assertEquals(15, streamFunctions.sumOfList(testInput))
    }

    @Test
    fun `test sum of nullable entries list`() {
        val testInput = listOf(null, 1, 2, 3, 4, null, 5)

        assertEquals(15, streamFunctions.sumOfListWithNullableEntries(testInput))
    }
    
    @Test
    fun `check that the returned list only containts odd numbers`() {
        val testInput = listOf(1, 2, 3, 4, 44, 5, 6, 7) 
        val result = streamFunctions.oddNumbersInList(testInput)

        result.forEach { assert(it % 2 != 0) }
    }

    @Test
    fun `test adding or subtracting one using when`() {
        val testInput =     listOf(1, 2, 3, 4, 5, 6, 920, 999)
        val correctResult = listOf(2, 1, 4, 3, 6, 5, 919, 1000)

        assertEquals(correctResult, streamFunctions.usingMapAndWhenAddOrSubtractOne(testInput))
    }

    @Test
    fun `test the input of many types function`() {
        val testInput = listOf(1, 2, "fire", true, emptyList<Int>(), false)
        val correctResult = listOf(1, 2, 4, 1, 0, 0)
        val actualResult = streamFunctions.inputOfManyTypes(testInput)

        assertEquals(correctResult, actualResult)
    }

    @Test
    fun `test add one using for each`() {
        val testInput = listOf(-1, 2, 3)
        val correctResult = listOf(0, 3, 4)
        val actualResult = streamFunctions.addOneUsingForEach(testInput)

        assertEquals(correctResult, actualResult)
    }

    @Test
    fun `test add one using for map`() {
        val testInput = listOf(-1, 2, 3)
        val correctResult = listOf(0, 3, 4)
        val actualResult = streamFunctions.addOneUsingMap(testInput)

        assertEquals(correctResult, actualResult)
    }

    @Test
    fun `test list of list sums`() {
        val testInput = listOf(listOf(1,2), listOf(3,4,5), listOf(0), listOf(-2), emptyList())
        val correctResult = listOf(3, 12, 0, -2, 0)
        val actualResult = streamFunctions.returnListOfListSums(testInput)

        assertEquals(correctResult, actualResult)
    }

    @Test
    fun `test turning a list of lists into one list`() {
        val testInput = listOf(listOf(1,2), listOf(3,4,5), listOf(0), listOf(-2), emptyList())
        val correctResult = testInput.flatten()
        val actualResult = streamFunctions.turnMultipleListsIntoOne(testInput)

        assertEquals(correctResult, actualResult)
    }

    @Test
    fun `test fold and multiply method`() {
        val testInput = listOf(2,2,2)

        assertEquals(18, streamFunctions.foldAndMultiply(testInput))
    }

    @Test
    fun `test fold and multiply method with sneaky zero`() {
        val testInput = listOf(2,0,2)

        assertEquals(6, streamFunctions.foldAndMultiply(testInput))
    }

    @Test
    fun `test fold and multiply method with final zero`() {
        val testInput = listOf(2,2,0)

        assertEquals(6, streamFunctions.foldAndMultiply(testInput))
    }

    @Test
    fun `test fold and multiply method long input list`() {
        val testInput = listOf(2,2,0, 12, 9, -4, 5, 10, 1)

        assertEquals(-308880, streamFunctions.foldAndMultiply(testInput))
    }
}