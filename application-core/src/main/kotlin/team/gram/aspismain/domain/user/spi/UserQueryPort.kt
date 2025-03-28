package team.gram.aspismain.domain.user.spi

import team.gram.aspismain.domain.user.model.User

interface UserQueryPort {
    fun getUserById(userId: String): User?
}