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
        // 먼저 이 Helper를 참조하는 모든 동물을 찾아 helperId를 null로 설정
        val animalsWithHelper = animalQueryPort.getAnimalsByHelperId(helperId)
        
        // 각 동물에 대해 helperId를 null로 설정하고 업데이트
        animalsWithHelper.forEach { animal ->
            val updatedAnimal = animal.copy(helperId = null)
            animalCommandPort.updateAnimal(updatedAnimal)
        }
        
        // Helper 삭제
        helperCommandPort.deleteHelper(helperId)
    }
}