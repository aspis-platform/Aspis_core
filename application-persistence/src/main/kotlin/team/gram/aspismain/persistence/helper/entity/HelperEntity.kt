package team.gram.aspismain.persistence.helper.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import team.gram.aspismain.persistence.BaseEntity
import java.util.UUID

@Entity
@Table(name = "tbl_helper")
class HelperEntity(
    val name: String,
    val phoneNumber: String,
    val address: String,
    id: UUID? = null
) : BaseEntity(id)