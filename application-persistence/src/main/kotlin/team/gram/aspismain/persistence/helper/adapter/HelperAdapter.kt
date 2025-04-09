package team.gram.aspismain.persistence.helper.adapter

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.domain.helper.spi.HelperPort
import team.gram.aspismain.persistence.helper.mapper.HelperMapper
import team.gram.aspismain.persistence.helper.repository.HelperRepository
import java.util.UUID

@Component
class HelperAdapter(
    private val helperRepository: HelperRepository,
    private val helperMapper: HelperMapper
) : HelperPort {
    override fun saveHelper(helper: Helper): Helper {
        val entity = helperMapper.toEntity(helper)
        val savedEntity = helperRepository.save(entity)
        return helperMapper.toDomain(savedEntity)!!
    }

    override fun updateHelper(helper: Helper): Helper {
        val entity = helperMapper.toEntity(helper)
        val savedEntity = helperRepository.save(entity)
        return helperMapper.toDomain(savedEntity)!!
    }

    override fun deleteHelper(helperId: UUID) {
        helperRepository.deleteById(helperId)
    }

    override fun getAllHelpers(): List<Helper> {
        return helperRepository.findAll()
            .map { helperMapper.toDomain(it)!! }
    }

    override fun getHelperById(helperId: UUID): Helper? {
        val optionalEntity = helperRepository.findById(helperId)
        if (!optionalEntity.isPresent) {
            return null
        }
        return helperMapper.toDomain(optionalEntity.get())
    }
}