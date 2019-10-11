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

class ContentDecoderFactory private constructor() {
    companion object {
        fun makeContentDecoder(content: String): ContentDecoder {
            return when {
                content.contains("utf8") -> Utf8Decoder()
                content.contains("base64") -> Base64Decoder()
                else -> throw RuntimeException("No decoder found to decode: $content")
            }
        }
    }
}

fun main() {
    val userInput = "abc,utf8"

    // Now we can evolve the ConcentDecoder without having to change their clients
    val decoder: ContentDecoder = ContentDecoderFactory.makeContentDecoder(userInput)

    println("Decoding result: ${decoder.decode(userInput)}")

}

/**
 * A factory is a class responsible for a particular creation mechanism. This solves the problem of creating a thing
 * in different ways. Or different subtypes. It provides us the possibility of deferring the logic for creation of objects for subclasses.
 * The 'factory method' is the concrete factory responsible for creating objects (We only have one type of factory).
 * The creators part of the code are responsible for the creation of the objects only.
 */


