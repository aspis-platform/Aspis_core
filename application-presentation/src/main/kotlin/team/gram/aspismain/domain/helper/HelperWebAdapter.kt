package team.gram.aspismain.domain.helper

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.gram.aspismain.domain.helper.dto.request.HelperRequest
import team.gram.aspismain.domain.helper.dto.response.HelperResponse
import team.gram.aspismain.domain.helper.usecase.DeleteHelperUseCase
import team.gram.aspismain.domain.helper.usecase.GetAllHelpersUseCase
import team.gram.aspismain.domain.helper.usecase.GetHelperByIdUseCase
import team.gram.aspismain.domain.helper.usecase.SaveHelperUseCase
import team.gram.aspismain.domain.helper.usecase.UpdateHelperUseCase
import java.util.UUID

@RestController
@RequestMapping("/v1/helpers")
class HelperWebAdapter(
    private val saveHelperUseCase: SaveHelperUseCase,
    private val getAllHelpersUseCase: GetAllHelpersUseCase,
    private val getHelperByIdUseCase: GetHelperByIdUseCase,
    private val updateHelperUseCase: UpdateHelperUseCase,
    private val deleteHelperUseCase: DeleteHelperUseCase
) {
    @PostMapping
    fun saveHelper(@RequestBody request: HelperRequest): ResponseEntity<HelperResponse> {
        val helper = HelperRequest.toModel(request)
        val savedHelper = saveHelperUseCase.execute(helper)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(HelperResponse.fromModel(savedHelper))
    }

    @GetMapping
    fun getAllHelpers(): ResponseEntity<List<HelperResponse>> {
        val helpers = getAllHelpersUseCase.execute()
        return ResponseEntity.ok(helpers.map { HelperResponse.fromModel(it) })
    }

    @GetMapping("/{helperId}")
    fun getHelperById(@PathVariable helperId: UUID): ResponseEntity<HelperResponse> {
        val helper = getHelperByIdUseCase.execute(helperId)
        return if (helper != null) {
            ResponseEntity.ok(HelperResponse.fromModel(helper))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{helperId}")
    fun updateHelper(
        @PathVariable helperId: UUID,
        @RequestBody request: HelperRequest
    ): ResponseEntity<HelperResponse> {
        val helper = HelperRequest.toModel(request, helperId)
        val updatedHelper = updateHelperUseCase.execute(helper)
        return ResponseEntity.ok(HelperResponse.fromModel(updatedHelper))
    }

    @DeleteMapping("/{helperId}")
    fun deleteHelper(@PathVariable helperId: UUID): ResponseEntity<Void> {
        deleteHelperUseCase.execute(helperId)
        return ResponseEntity.noContent().build()
    }
}