package team.gram.aspismain.domain.helper.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.animal.spi.AnimalCommandPort
import team.gram.aspismain.domain.animal.spi.AnimalQueryPort
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.domain.helper.spi.HelperCommandPort
import java.util.UUID

@Service
class HelperCommandServiceImpl(
    private val helperCommandPort: HelperCommandPort,
    private val animalQueryPort: AnimalQueryPort,
    private val animalCommandPort: AnimalCommandPort
) : HelperCommandService {
    override fun saveHelper(helper: Helper): Helper {
        return helperCommandPort.saveHelper(helper)
    }

    override fun updateHelper(helper: Helper): Helper {
        return helperCommandPort.updateHelper(helper)
    }

    override fun deleteHelper(helperId: UUID) {
        val animalsWithHelper = animalQueryPort.getAnimalsByHelperId(helperId)

        animalsWithHelper.forEach { animal ->
            val updatedAnimal = animal.copy(helperId = null)
            animalCommandPort.updateAnimal(updatedAnimal)
        }

        helperCommandPort.deleteHelper(helperId)
    }
}