package team.gram.aspismain.domain.helper.spi

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

interface HelperQueryPort {
    fun getAllHelpers(): List<Helper>
    fun getHelperById(helperId: UUID): Helper?
}