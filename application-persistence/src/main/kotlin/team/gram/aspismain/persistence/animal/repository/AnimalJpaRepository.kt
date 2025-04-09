package team.gram.aspismain.persistence.animal.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.gram.aspismain.persistence.animal.entity.AnimalJpaEntity
import java.util.UUID

@Repository
interface AnimalJpaRepository : CrudRepository<AnimalJpaEntity,UUID> {
    fun findAllByHelperId(helperId: UUID): List<AnimalJpaEntity>
}