package team.gram.aspismain.domain.helper.service

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

interface HelperCommandService {
    fun saveHelper(helper: Helper): Helper
    fun updateHelper(helper: Helper): Helper
    fun deleteHelper(helperId: UUID)
}