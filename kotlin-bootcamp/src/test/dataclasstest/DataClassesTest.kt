package dataclasstest

import dataclasses.SimpleDataclass
import tasks.DataclassTasks
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DataClassesTest {

    private val functions = DataclassTasks()

    @Test
    fun `test new value for changeableString`() {
        val result = functions.returnWithNewVar(SimpleDataclass())
        assertNotEquals("originalValue", result.changeableString)
    }

    @Test
    fun `test new value for unchangeableString`() {
        val result = functions.returnWithNewVal(SimpleDataclass())
        assertNotEquals("originalValue", result.unchangeableString)
    }

    @Test
    fun `test length of the nullableString`() {
        var length = functions.returnLengthOfNullableString(SimpleDataclass(nullableString = "test"))
        assertEquals(4, length)

        length = functions.returnLengthOfNullableString(SimpleDataclass(nullableString = ""))
        assertEquals(0, length)

        length = functions.returnLengthOfNullableString(SimpleDataclass())
        assertEquals(42, length)
    }

    @Test
    fun `test length of the nullableString with extension function`() {
        var length = functions.returnLengthOfNullableStringUsingExtensionFunction(SimpleDataclass(nullableString = "test"))
        assertEquals(4, length)

        length = functions.returnLengthOfNullableStringUsingExtensionFunction(SimpleDataclass(nullableString = ""))
        assertEquals(0, length)

        length = functions.returnLengthOfNullableStringUsingExtensionFunction(SimpleDataclass())
        assertEquals(42, length)
    }
}