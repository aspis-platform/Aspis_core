package team.gram.aspismain.domain.weight.service

import team.gram.aspismain.domain.weight.model.Weight
import java.util.UUID

interface WeightQueryService {
    fun getWeightById(weightId: UUID): Weight?
    fun getWeightsByAnimalId(animalId: UUID): List<Weight>
    fun getAllWeights(): List<Weight>
}