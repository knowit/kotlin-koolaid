package extensions

//TODO This file is where you should declare your extension functions, see examples

fun String.addSentFromMyIpad() = this.plus(" sent from my iPad")

fun String.addText(extraText: String): String {
    return "$this $extraText"
}