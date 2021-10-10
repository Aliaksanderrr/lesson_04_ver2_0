package inKotlin.task4Friends.service

import inKotlin.task4Friends.entity.Person

class SocialNetwork {
    private val userSet: MutableSet<User> = mutableSetOf()

    fun createUser(nickname: String): Boolean {
        val newUser = User(Person(nickname))
        return if (!userSet.contains(newUser)) {
            userSet.add(newUser)
            true
        } else false
    }

    fun getAllUsers(): List<Person> {
        return userSet.map { it.person }
    }

    fun getFriends(person: Person): List<Person>{
        val user = userSet.getUser(person)
        return user?.getAllFriends() ?: listOf()
    }

    fun createFriendship(person1: Person, person2: Person): Boolean {
        val user1 = userSet.getUser(person1)
        val user2 = userSet.getUser(person2)

        if (user1 == user2) {
            return false
        }

        var flag = user2?.let { user1?.addFriend(it) } == true
        if (flag) {
            flag = user1?.let { user2?.addFriend(it) } == true
        }
        return flag
    }
}

private fun MutableSet<User>.getUser(person: Person): User? {
    for (user in this) {
        if (user.person == person) {
            return user
        }
    }
    return null
}
