package team.gram.aspismain.persistence.breed.mapper

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.breed.entity.BreedJpaEntity

@Component
class BreedMapper : GenericMapper<Breed, BreedJpaEntity> {

    override fun toDomain(entity: BreedJpaEntity?): Breed {
        requireNotNull(entity) { "BreedJpaEntity must not be null" }

        return Breed(
            id = requireNotNull(entity.id) { "BreedJpaEntity.id must not be null" },
            name = entity.name,
            size = entity.size
        )
    }

    override fun toEntity(domain: Breed): BreedJpaEntity {
        return BreedJpaEntity(
            id = domain.id,
            name = domain.name,
            size = domain.size
        )
    }
}
