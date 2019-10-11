package creational.factory.factoryMethod

import java.lang.RuntimeException

interface ContentDecoder {
    fun decode(content: String): String
}

class Base64Decoder : ContentDecoder {
    override fun decode(content: String): String {
        return "Base64: $content"
    }
}

class Utf8Decoder : ContentDecoder {
    override fun decode(content: String): String {
        return "UTF8: $content"
    }
}

fun main() {
    val userInput = "abc,utf8"

    // Every time we have a new decoder we have to change this client class
    // We need to find a way to keep this client compliant with OCP
    val result: String = when {
        userInput.contains("utf8") -> Utf8Decoder().decode("asdf")
        userInput.contains("base64") -> Base64Decoder().decode("asdf")
        else -> throw RuntimeException("No decoder found to decode: $userInput")
    }

    println("Decoding result: $result")

}

/**
 * A factory is a class responsible for a particular creation mechanism. This solves the problem of creating a thing
 * in different ways. Or different subtypes. It provides us the possibility of deferring the logic for creation of objects for subclasses.
 * The 'factory method' is the concrete factory responsible for creating objects (We only have one type of factory).
 * The creators part of the code are responsible for the creation of the objects only.
 */


