package inKotlin.task4Friends

import inKotlin.task4Friends.entity.Person
import inKotlin.task4Friends.service.SocialNetwork
import kotlin.random.Random

const val INDENT = "    "

fun main() {
    val myNetwork = initialisingMySocialNetwork()

    //TASK 4
    val persons = myNetwork.getAllUsers()
    val randomPerson = persons[Random.nextInt(0, persons.size)]
    val nested = 2
    randomPerson.printFriends(myNetwork, "", nested)
}

fun Person.printFriends(network: SocialNetwork, indent: String, nested: Int) {
    println("$indent$this")
    if (nested > 0) {
        for (friend in network.getFriends(this)) {
            friend.printFriends(network, "$indent$INDENT", nested - 1)
        }
    }
}

fun initialisingMySocialNetwork(): SocialNetwork {
    val personNicknames: List<String> = listOf(
        "Bob", "Marcie", "Martina", "Brenda", "Joseph",
        "Lewis", "Nick", "Augustus", "Janey", "Carrie",
        "Carrie", "Pavlina", "Emil", "Ryan", "Juliana",
        "Cristina", "Sebastian", "Fedora", "Jimi", "Nicoletta"
    )

    return SocialNetwork().apply {
        for (person in personNicknames) {
            createUser(person)
        }
        val persons = this.getAllUsers()
        for (i in 1..20) {
            val randomPerson1 = persons[Random.nextInt(0, persons.size)]
            val randomPerson2 = persons[Random.nextInt(0, persons.size)]
            this.createFriendship(randomPerson1, randomPerson2)
        }
    }
}
