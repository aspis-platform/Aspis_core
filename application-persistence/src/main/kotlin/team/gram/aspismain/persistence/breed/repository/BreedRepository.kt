package team.gram.aspismain.persistence.breed.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.gram.aspismain.persistence.breed.entity.BreedJpaEntity
import java.util.UUID

@Repository
interface BreedRepository : JpaRepository<BreedJpaEntity, UUID>