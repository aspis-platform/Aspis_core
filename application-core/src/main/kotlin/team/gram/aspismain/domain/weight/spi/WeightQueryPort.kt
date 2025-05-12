package team.gram.aspismain.domain.weight.spi

import team.gram.aspismain.domain.weight.model.Weight
import java.util.UUID

interface WeightQueryPort {
    fun getWeightById(weightId: UUID): Weight?
    fun getWeightsByAnimalId(animalId: UUID): List<Weight>
    fun getAllWeights(): List<Weight>
}