package team.gram.aspismain.persistence.helper.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import team.gram.aspismain.persistence.BaseEntity
import java.util.UUID

@Entity
@Table(name = "tbl_helper")
class HelperJpaEntity(
    @Column(nullable = false, name = "name")
    val name: String,

    @Column(nullable = false, name = "phone_number")
    val phoneNumber: String,

    id: UUID? = null
) : BaseEntity(id)