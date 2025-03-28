package team.gram.aspismain.persistence.user.mapper

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.user.model.User
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.user.entity.UserJpaEntity

@Component
class UserMapper : GenericMapper<User, UserJpaEntity> {
    override fun toEntity(domain: User): UserJpaEntity {
        return UserJpaEntity(
            userName = domain.userName,
            userEmail = domain.userEmail,
            userPassword = domain.userPassword,
            userAuthority = domain.userAuthority,
            id = domain.id
        )
    }

    override fun toDomain(entity: UserJpaEntity?): User? {
        return entity?.let {
            User(
                id = it.id!!,
                userName = it.userName,
                userEmail = it.userEmail,
                userPassword = it.userPassword,
                userAuthority = it.userAuthority
            )
        }
    }
}