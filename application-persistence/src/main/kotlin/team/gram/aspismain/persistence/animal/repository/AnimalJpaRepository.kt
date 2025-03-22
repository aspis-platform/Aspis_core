package team.gram.aspismain.persistence.animal.repository

import org.springframework.data.repository.CrudRepository
import team.gram.aspismain.persistence.animal.entity.AnimalJpaEntity
import java.util.UUID

interface AnimalJpaRepository : CrudRepository<AnimalJpaEntity,UUID> {
}