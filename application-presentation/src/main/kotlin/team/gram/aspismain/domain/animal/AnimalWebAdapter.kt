package team.gram.aspismain.domain.animal

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.gram.aspismain.domain.animal.dto.AnimalResponse

@Validated
@RestController
@RequestMapping("/v1/animal")
class AnimalWebAdapter (

) {
    @GetMapping("/get-all")
    fun getAllAnimals() : AnimalResponse {
        val result =

    }
}