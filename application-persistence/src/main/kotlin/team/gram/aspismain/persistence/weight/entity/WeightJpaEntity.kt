package team.gram.aspismain.persistence.weight.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import team.gram.aspismain.persistence.BaseEntity
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "tbl_weight")
class WeightJpaEntity(
    @Column(name = "animal_id", nullable = false)
    val animalId: UUID,

    @Column(name = "weight", nullable = false)
    val weight: Int,

    @Column(name = "date", nullable = false)
    val date: Date,

    id: UUID? = null
) : BaseEntity(id)