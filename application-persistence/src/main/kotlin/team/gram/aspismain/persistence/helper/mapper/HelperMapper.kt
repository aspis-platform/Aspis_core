package team.gram.aspismain.persistence.helper.mapper

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.helper.model.Helper
import team.gram.aspismain.persistence.GenericMapper
import team.gram.aspismain.persistence.helper.entity.HelperJpaEntity

@Component
class HelperMapper : GenericMapper<Helper, HelperJpaEntity> {
    override fun toDomain(entity: HelperJpaEntity?): Helper? {
        if (entity == null) return null
        
        return Helper(
            id = entity.id!!,
            name = entity.name,
            phoneNumber = entity.phoneNumber,
        )
    }

    override fun toEntity(domain: Helper): HelperJpaEntity {
        return HelperJpaEntity(
            name = domain.name,
            phoneNumber = domain.phoneNumber,
            id = domain.id
        )
    }
}