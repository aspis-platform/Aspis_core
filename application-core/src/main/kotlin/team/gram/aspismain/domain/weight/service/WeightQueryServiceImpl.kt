package team.gram.aspismain.domain.weight.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.weight.model.Weight
import team.gram.aspismain.domain.weight.spi.WeightPort
import java.util.UUID

@Service
class WeightQueryServiceImpl(
    private val weightPort: WeightPort
) : WeightQueryService {

    override fun getWeightById(weightId: UUID): Weight? {
        return weightPort.getWeightById(weightId)
    }

    override fun getWeightsByAnimalId(animalId: UUID): List<Weight> {
        return weightPort.getWeightsByAnimalId(animalId)
    }

    override fun getAllWeights(): List<Weight> {
        return weightPort.getAllWeights()
    }
}