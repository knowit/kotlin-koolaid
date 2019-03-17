package tasks

import dataclasses.SimpleDataclass

class DataclassTasks {

    /*
    The tasks in this file are an attempt to teach you the basics of val, vars and nullables
    In the final task you are supposed to create an extension function, see the extensions-folder
     */

    fun returnWithNewVar(input: SimpleDataclass): SimpleDataclass {
        //TODO Write code that changes the value of the changeableString var of the input

        return SimpleDataclass()
    }

    fun returnWithNewVal(input: SimpleDataclass): SimpleDataclass {
        //TODO Write code that returns a copy of the input, with a new value for unchangeableString. Hint copy()

        return SimpleDataclass()
    }

    fun returnLengthOfNullableString(input: SimpleDataclass): Int {
        //TODO Write code that returns the length of the nullable string, should return 42 if the string is null

        return 1905
    }

    fun returnLengthOfNullableStringUsingExtensionFunction(input: SimpleDataclass): Int {
        //TODO Write code that returns the length of the nullable string by creating an extension function for the String class, should return 42 if the string is null.

        return 1905
    }
}