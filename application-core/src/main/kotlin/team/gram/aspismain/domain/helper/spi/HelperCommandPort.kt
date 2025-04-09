package team.gram.aspismain.domain.helper.spi

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

interface HelperCommandPort {
    fun saveHelper(helper: Helper): Helper
    fun updateHelper(helper: Helper): Helper
    fun deleteHelper(helperId: UUID)
}