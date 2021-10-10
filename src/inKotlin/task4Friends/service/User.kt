package inKotlin.task4Friends.service

import inKotlin.task4Friends.entity.Person

class User(
    val person: Person,
    private val friends: MutableSet<User> = mutableSetOf()
) {

    fun addFriend(newFriend: User): Boolean {
        return friends.add(newFriend)
    }

    fun getAllFriends(): List<Person> {
        return friends.map { it.person }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (person != other.person) return false

        return true
    }

    override fun hashCode(): Int {
        return person.hashCode()
    }

}
