package team.gram.aspismain.domain.user.model

import java.util.UUID

data class User(
    val id: String,
    val userName: String,
    val userEmail: String,
    val userPassword: String,
    val userAuthority: UserAuthority
)