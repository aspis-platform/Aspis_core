package team.gram.aspismain.persistence.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import team.gram.aspismain.domain.user.model.UserAuthority
import java.util.UUID

@Entity
@Table(name = "tbl_user")
class UserJpaEntity(
    @Column(nullable = false, length = 100)
    val userName: String,

    @Column(nullable = false, unique = true)
    val userEmail: String,

    @Column(nullable = false)
    val userPassword: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val userAuthority: UserAuthority = UserAuthority.STAFF,

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    val id: String = UUID.randomUUID().toString()
)