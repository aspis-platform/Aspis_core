package team.gram.aspismain.persistence.weight.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.gram.aspismain.persistence.weight.entity.WeightJpaEntity
import java.util.UUID

@Repository
interface WeightJpaRepository : CrudRepository<WeightJpaEntity, UUID> {
    fun findAllByAnimalId(animalId: UUID): List<WeightJpaEntity>
    fun findAllByAnimalIdOrderByDateDesc(animalId: UUID): List<WeightJpaEntity>
}