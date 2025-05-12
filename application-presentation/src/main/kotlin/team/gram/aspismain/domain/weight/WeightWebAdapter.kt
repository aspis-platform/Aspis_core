package team.gram.aspismain.domain.weight

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import team.gram.aspismain.domain.weight.dto.WeightListResponse
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.dto.request.SaveWeightWebRequest
import team.gram.aspismain.domain.weight.dto.request.UpdateWeightWebRequest
import team.gram.aspismain.domain.weight.usecase.*
import java.util.UUID

@Validated
@RestController
@RequestMapping("/v1/weights")
class WeightWebAdapter(
    private val saveWeightUseCase: SaveWeightUseCase,
    private val updateWeightUseCase: UpdateWeightUseCase,
    private val deleteWeightUseCase: DeleteWeightUseCase,
    private val getWeightByIdUseCase: GetWeightByIdUseCase,
    private val getWeightsByAnimalIdUseCase: GetWeightsByAnimalIdUseCase,
    private val getAllWeightsUseCase: GetAllWeightsUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllWeights(): List<WeightResponse> {
        return getAllWeightsUseCase.execute()
    }
    
    @GetMapping("/{weightId}")
    @ResponseStatus(HttpStatus.OK)
    fun getWeightById(@PathVariable weightId: UUID): WeightResponse {
        return getWeightByIdUseCase.execute(weightId)
    }
    
    @GetMapping("/animal/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    fun getWeightsByAnimalId(@PathVariable animalId: UUID): WeightListResponse {
        return getWeightsByAnimalIdUseCase.execute(animalId)
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveWeight(@RequestBody @Validated request: SaveWeightWebRequest): WeightResponse {
        val domainRequest = request.toDomainRequest()
        return saveWeightUseCase.execute(domainRequest)
    }
    
    @PutMapping("/{weightId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateWeight(
        @PathVariable weightId: UUID,
        @RequestBody @Validated request: UpdateWeightWebRequest
    ): WeightResponse {
        val domainRequest = request.toDomainRequest(weightId)
        return updateWeightUseCase.execute(domainRequest)
    }
    
    @DeleteMapping("/{weightId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteWeight(@PathVariable weightId: UUID) {
        deleteWeightUseCase.execute(weightId)
    }
}