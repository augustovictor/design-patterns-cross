package behavioral.observerPattern

interface IObservable {
    fun register(observer: IObserver)
    fun deregister(observer: IObserver)
    fun notifyObservers()
}

interface IObserver {
    fun update()
}

class ChatRoom : IObservable {
    private val observers: MutableList<IObserver> = mutableListOf()

    override fun register(observer: IObserver) {
        observers.add(observer)
    }

    override fun deregister(observer: IObserver) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.onEach { it.update() }.also { println("Calling update on $it") }
    }

    fun roomState(): String {
        println("roomState requested by observer!")
        return "Sits available..."
    }
}

class ChatUser(val chatRoom: ChatRoom): IObserver {
    init {
        chatRoom.register(this)
    }

    override fun update() {
        println("Updating ${this}")
        chatRoom.roomState()
    }
}

/*
 * The observer pattern provides a solution for objects getting notified when a change on another object occurs
 * In our example the chatRoom has more responsibilities than only handling the state. To solve that it would be a better alternative to
 * make chatRoom have an IObservable as an attribute. Composition over inheritance.
 */

fun main() {
    val chatRoom = ChatRoom()
    ChatUser(chatRoom)
    ChatUser(chatRoom)

    chatRoom.notifyObservers()
}
