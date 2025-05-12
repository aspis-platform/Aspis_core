package team.gram.aspismain.domain.weight.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.animal.exception.AnimalNotFoundException
import team.gram.aspismain.domain.animal.exception.InvalidWeightException
import team.gram.aspismain.domain.animal.exception.WeightNotFoundException
import team.gram.aspismain.domain.animal.service.AnimalQueryService
import team.gram.aspismain.domain.weight.model.Weight
import team.gram.aspismain.domain.weight.spi.WeightPort
import java.util.Date
import java.util.UUID

@Service
class WeightCommandServiceImpl(
    private val weightPort: WeightPort,
    private val animalQueryService: AnimalQueryService
) : WeightCommandService {

    override fun saveWeight(weight: Weight): Weight {
        validateWeight(weight.weight)
        validateAnimal(weight.animalId)
        return weightPort.saveWeight(weight)
    }

    override fun updateWeight(weightId: UUID, newWeight: Int, newDate: Date): Weight {
        validateWeight(newWeight)
        
        val weight = weightPort.getWeightById(weightId) ?: throw WeightNotFoundException
        
        val updatedWeight = weight.copy(
            weight = newWeight,
            date = newDate
        )
        
        return weightPort.updateWeight(updatedWeight)
    }

    override fun deleteWeight(weightId: UUID) {
        val weight = weightPort.getWeightById(weightId) ?: throw WeightNotFoundException
        weightPort.deleteWeightById(weightId)
    }
    
    private fun validateWeight(weight: Int) {
        if (weight <= 0) {
            throw InvalidWeightException
        }
    }
    
    private fun validateAnimal(animalId: UUID) {
        animalQueryService.getAnimalById(animalId) 
            ?: throw AnimalNotFoundException
    }
}