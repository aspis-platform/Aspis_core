package team.gram.aspismain.persistence.helper.mapper

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.helper.entity.HelperEntity

@Component
class HelperMapper : GenericMapper<Helper, HelperEntity> {
    override fun toDomain(entity: HelperEntity?): Helper? {
        if (entity == null) return null
        
        return Helper(
            id = entity.id!!,
            name = entity.name,
            phoneNumber = entity.phoneNumber,
            address = entity.address
        )
    }

    override fun toEntity(domain: Helper): HelperEntity {
        return HelperEntity(
            name = domain.name,
            phoneNumber = domain.phoneNumber,
            address = domain.address,
            id = domain.id
        )
    }
}