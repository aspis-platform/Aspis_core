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
    @Id
    @Column(columnDefinition = "VARCHAR(36)" , name = "id")
    val id: String = UUID.randomUUID().toString(),

    @Column(nullable = false, length = 100, name = "user_name")
    val userName: String,

    @Column(nullable = false, unique = true , name = "user_email")
    val userEmail: String,

    @Column(nullable = false , name = "user_password")
    val userPassword: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_authority")
    val userAuthority: UserAuthority = UserAuthority.STAFF
)