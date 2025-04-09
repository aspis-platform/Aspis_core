package team.gram.aspismain.domain.helper.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.domain.helper.spi.HelperPort
import java.util.UUID

@Service
class HelperQueryServiceImpl(
    private val helperPort: HelperPort
) : HelperQueryService {
    override fun getHelperById(helperId: UUID): Helper? {
        return helperPort.getHelperById(helperId)
    }
    
    override fun getHelperNameById(helperId: UUID): String? {
        val helper = helperPort.getHelperById(helperId)
        return helper?.name
    }
    
    override fun getAllHelpers(): List<Helper> {
        return helperPort.getAllHelpers()
    }
}