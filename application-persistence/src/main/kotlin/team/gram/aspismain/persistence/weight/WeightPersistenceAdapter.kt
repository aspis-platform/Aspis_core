package team.gram.aspismain.persistence.weight

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.weight.model.Weight
import team.gram.aspismain.domain.weight.spi.WeightPort
import team.gram.aspismain.persistence.weight.mapper.WeightMapper
import team.gram.aspismain.persistence.weight.repository.WeightJpaRepository
import java.util.UUID

@Component
class WeightPersistenceAdapter(
    private val weightRepository: WeightJpaRepository,
    private val weightMapper: WeightMapper
) : WeightPort {
    
    override fun saveWeight(weight: Weight): Weight {
        val entity = weightRepository.save(
            weightMapper.toEntity(weight)
        )
        return weightMapper.toDomain(entity)!!
    }

    override fun updateWeight(weight: Weight): Weight {
        val entity = weightMapper.toEntity(weight)
        val savedEntity = weightRepository.save(entity)
        return weightMapper.toDomain(savedEntity)!!
    }

    override fun deleteWeightById(weightId: UUID) {
        weightRepository.deleteById(weightId)
    }

    override fun getWeightById(weightId: UUID): Weight? {
        return weightRepository.findById(weightId)
            .map { weightMapper.toDomain(it) }
            .orElse(null)
    }

    override fun getWeightsByAnimalId(animalId: UUID): List<Weight> {
        return weightRepository.findAllByAnimalIdOrderByDateDesc(animalId)
            .mapNotNull { weightMapper.toDomain(it) }
    }

    override fun getAllWeights(): List<Weight> {
        return weightRepository.findAll()
            .mapNotNull { weightMapper.toDomain(it) }
    }
}