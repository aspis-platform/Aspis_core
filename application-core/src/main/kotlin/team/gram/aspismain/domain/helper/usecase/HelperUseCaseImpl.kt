package team.gram.aspismain.domain.helper.usecase

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.domain.helper.service.HelperCommandService
import team.gram.aspismain.domain.helper.service.HelperQueryService
import java.util.UUID

@Component
class SaveHelperUseCaseImpl(
    private val helperCommandService: HelperCommandService
) : SaveHelperUseCase {
    override fun execute(helper: Helper): Helper {
        return helperCommandService.saveHelper(helper)
    }
}

@Component
class UpdateHelperUseCaseImpl(
    private val helperCommandService: HelperCommandService
) : UpdateHelperUseCase {
    override fun execute(helper: Helper): Helper {
        return helperCommandService.updateHelper(helper)
    }
}

@Component
class DeleteHelperUseCaseImpl(
    private val helperCommandService: HelperCommandService
) : DeleteHelperUseCase {
    override fun execute(helperId: UUID) {
        return helperCommandService.deleteHelper(helperId)
    }
}

@Component
class GetAllHelpersUseCaseImpl(
    private val helperQueryService: HelperQueryService
) : GetAllHelpersUseCase {
    override fun execute(): List<Helper> {
        return helperQueryService.getAllHelpers()
    }
}

@Component
class GetHelperByIdUseCaseImpl(
    private val helperQueryService: HelperQueryService
) : GetHelperByIdUseCase {
    override fun execute(helperId: UUID): Helper? {
        return helperQueryService.getHelperById(helperId)
    }
}