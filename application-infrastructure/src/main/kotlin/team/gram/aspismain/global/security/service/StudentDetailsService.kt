package team.gram.aspismain.global.security.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import team.gram.aspismain.domain.user.model.UserAuthority
import team.gram.aspismain.global.security.exception.UnexpectedTokenException
import team.gram.aspismain.persistence.user.UserPersistenceAdapter

@Service
class StudentDetailsService(
    private val userPersistenceAdapter: UserPersistenceAdapter
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        try {
            val user = userPersistenceAdapter.getUserById(userId)
                ?: throw UsernameNotFoundException("사용자를 찾을 수 없습니다: $userId")

            return org.springframework.security.core.userdetails.User.builder()
                .username(user.id.toString())
                .password(user.userPassword)
                .authorities(user.userAuthority.name)
                .build()
        } catch (e: IllegalArgumentException) {
            throw UnexpectedTokenException
        }
    }
}