package team.gram.aspismain.domain.helper.usecase

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

fun interface GetHelperByIdUseCase {
    fun execute(helperId: UUID): Helper?
}