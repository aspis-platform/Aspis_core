package team.gram.aspismain.persistence.weight.mapper

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.weight.model.Weight
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.weight.entity.WeightJpaEntity

@Component
class WeightMapper : GenericMapper<Weight, WeightJpaEntity> {

    override fun toEntity(domain: Weight): WeightJpaEntity {
        return WeightJpaEntity(
            animalId = domain.animalId,
            weight = domain.weight,
            date = domain.date,
            id = domain.id
        )
    }

    override fun toDomain(entity: WeightJpaEntity?): Weight? {
        return entity?.let {
            Weight(
                id = it.id!!,
                animalId = it.animalId,
                weight = it.weight,
                date = it.date
            )
        }
    }
}