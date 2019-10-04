package behavioral.strategyPattern

interface FlyStrategy {
    fun fly()
}

class FlyFast : FlyStrategy {
    override fun fly() {
        println("Flyieeeeeng!")
    }

}

interface RunStrategy {
    fun run()
}

class RunFast : RunStrategy {
    override fun run() {
        println("RUUUN, Forest!")
    }

}

interface QuackStrategy {
    fun quack()
}

class QuackQuiet : QuackStrategy {
    override fun quack() {
        println("qu....")
    }

}

class RealDuck(
    private val flyStrategy: FlyStrategy,
    private val runStrategy: RunStrategy,
    private val quackStrategy: QuackStrategy
) {
    fun realFly() {
        flyStrategy.fly()
    }

    fun realRun() {
        runStrategy.run()
    }

    fun realQuack() {
        quackStrategy.quack()
    }

}

fun main() {
    val realDuck = RealDuck(flyStrategy = FlyFast(), runStrategy = RunFast(), quackStrategy = QuackQuiet())
    realDuck.realFly()
    realDuck.realRun()
    realDuck.realQuack()
}

/**
 * The Strategy pattern defines a family of algorithms (Concrete implementation of abstractions
 * such as FlyFast, RunFast, etc), encapsulates them (in their methods), and makes them
 * interchangeable (the client uses interfaces)
 */
