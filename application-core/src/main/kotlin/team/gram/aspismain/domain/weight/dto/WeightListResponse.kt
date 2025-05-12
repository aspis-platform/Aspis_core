package team.gram.aspismain.domain.weight.dto

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.weight.model.Weight

data class WeightListResponse(
    val animalName: String,
    val weights: List<WeightResponse>
) {
    companion object {
        fun of(animal: Animal, weights: List<Weight>): WeightListResponse {
            return WeightListResponse(
                animalName = animal.name,
                weights = weights.map { WeightResponse.of(it) }
            )
        }
    }
}