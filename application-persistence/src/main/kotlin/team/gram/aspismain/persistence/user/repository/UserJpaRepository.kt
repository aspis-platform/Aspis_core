package team.gram.aspismain.persistence.user.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.gram.aspismain.persistence.user.entity.UserJpaEntity
import java.util.*

@Repository
interface UserJpaRepository : CrudRepository<UserJpaEntity, UUID> {
    fun findById(id: String): Optional<UserJpaEntity>
}