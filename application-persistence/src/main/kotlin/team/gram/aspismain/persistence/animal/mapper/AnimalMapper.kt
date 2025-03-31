package team.gram.aspismain.persistence.animal.mapper

import team.gram.aspismain.domain.animal.model.Animal
import org.springframework.stereotype.Component
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.animal.entity.AnimalJpaEntity

@Component
class AnimalMapper : GenericMapper<Animal, AnimalJpaEntity> {

    override fun toEntity(domain: Animal): AnimalJpaEntity {
        return AnimalJpaEntity(
            breedId = domain.breedId,
            helperId = domain.helperId,
            name = domain.name,
            isNeutered = domain.isNeutered,
            sex = domain.sex,
            animalStatus = domain.animalStatus,
            profileUrl = domain.profileUrl,
            id = domain.id,
            birthYear = domain.birthYear
        )
    }

    override fun toDomain(entity: AnimalJpaEntity?): Animal? {
        return entity?.let {
            Animal(
                id = it.id!!,
                breedId = it.breedId,
                helperId = it.helperId,
                name = it.name,
                isNeutered = it.isNeutered,
                sex = it.sex,
                animalStatus = it.animalStatus,
                profileUrl = it.profileUrl,
                birthYear = it.birthYear
            )
        }
    }
}