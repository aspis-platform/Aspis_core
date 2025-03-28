package team.gram.aspismain.persistence.user

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.user.model.User
import team.gram.aspismain.domain.user.spi.UserPort
import team.gram.aspismain.persistence.user.entity.UserJpaEntity
import team.gram.aspismain.persistence.user.mapper.UserMapper
import team.gram.aspismain.persistence.user.repository.UserJpaRepository

@Component
class UserPersistenceAdapter(
    private val userRepository: UserJpaRepository,
    private val userMapper: UserMapper
) : UserPort {
    override fun getUserById(userId: String): User? {
        val userEntity = userRepository.findById(userId).orElse(null)
        return userMapper.toDomain(userEntity)
    }
}