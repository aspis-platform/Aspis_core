package team.gram.aspismain.domain.helper.service

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

interface HelperQueryService {
    fun getHelperById(helperId: UUID): Helper?
    fun getHelperNameById(helperId: UUID): String?
    fun getAllHelpers(): List<Helper>
}