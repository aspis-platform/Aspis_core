package team.gram.aspismain.persistence.helper.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.gram.aspismain.persistence.helper.entity.HelperJpaEntity
import java.util.UUID

@Repository
interface HelperRepository : JpaRepository<HelperJpaEntity, UUID>