package tasks

import dataclasses.Car
import dataclasses.Vehicle

class StreamTasks {

    fun sumOfList(input: List<Int>): Int {
        //TODO Write code that returns the sum of the list

        return 13
    }

    fun sumOfListWithNullableEntries(input: List<Int?>): Int {
        //TODO Write code that returns the sum of the list

        return 13
    }

    fun oddNumbersInList(input: List<Int>): List<Int> {
        //TODO Write code that returns the odd numbers of the input list.

        return emptyList()
    }

    fun usingMapAndWhenAddOrSubtractOne(input: List<Int>): List<Int> {
        //TODO Write code that maps over the list. If the entry is even, subtract one, odd -> add one

        return emptyList()
    }

    fun inputOfManyTypes(input: List<Any>):  List<Int> {
        //TODO Given a list with Any input, do the following:
        //TODO Return the value of an int, length of a String or list and 1 if a true boolean value

        return emptyList()
    }

    fun addOneUsingForEach(input: List<Int>): List<Int> {
        //TODO Add one to each list element using for each, x+1

        return emptyList()
    }

    fun addOneUsingMap(input: List<Int>): List<Int> {
        //TODO Add one to each list element using map, x+1

        return emptyList()
    }

    fun returnListOfListSums(input: List<List<Int>>): List<Int> {
        //TODO Return a list of the sums of the lists in the input list

        return emptyList()
    }

    fun turnMultipleListsIntoOne(input: List<List<Int>>): List<Int> {
        //TODO Turn the list of lists into a single list

        return emptyList()
    }

    fun foldAndMultiply(input: List<Int>): Int {
        //TODO Write a function, that using fold add the entries together and times the next entry with the sum of the previous entries.
        //TODO Example, given (2, 2, 2) -> 2 + 2*2 + 2*6 = 18. If total sum is zero, it should not be used to multiply the next value
        //TODO Example, given (1, 2, 0, 4) -> 1 + 1*2 + 0 + 3*4 = 15

        return 1030
    }

    fun zipTwoListsTogether(inputOne: List<Int>, inputTwo: List<Int>): List<Int> {
        //TODO Add the content of two lists together, i.e A = (1, 2), B = (1, 2). -> C = A + B = (2, 4)

        return emptyList()
    }

    fun findVehiclesWithHighFuelConsumption(input: List<Car>): List<Vehicle> {
        //TODO Map all cars with a fuel consumption higher than 5 to vehicles

        return emptyList()
    }
}