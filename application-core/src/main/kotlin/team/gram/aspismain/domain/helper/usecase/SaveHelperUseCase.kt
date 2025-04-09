package team.gram.aspismain.domain.helper.usecase

import team.gram.aspismain.domain.helper.model.Helper

fun interface SaveHelperUseCase {
    fun execute(helper: Helper): Helper
}