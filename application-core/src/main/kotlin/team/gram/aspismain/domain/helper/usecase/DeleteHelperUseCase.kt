package team.gram.aspismain.domain.helper.usecase

import java.util.UUID

fun interface DeleteHelperUseCase {
    fun execute(helperId: UUID)
}