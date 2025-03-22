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
            admissionDate = domain.admissionDate,
            sex = domain.sex,
            animalStatus = domain.animalStatus,
            profileUrl = domain.profile_url,
            id = domain.id
        )
    }

    override fun toDomain(entity: AnimalJpaEntity?): Animal? {
        return entity?.let {
            Animal(
                id = it.id!!,
                breedId = it.breedId,
                helperId = it.helperId,
                name = it.name,
                admissionDate = it.admissionDate,
                sex = it.sex,
                animalStatus = it.animalStatus,
                profile_url = it.profileUrl
            )
        }
    }
}