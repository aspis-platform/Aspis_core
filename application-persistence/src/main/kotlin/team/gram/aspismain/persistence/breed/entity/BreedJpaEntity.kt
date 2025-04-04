package team.gram.aspismain.persistence.breed.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import team.gram.aspismain.domain.breed.model.BreedSize
import team.gram.aspismain.persistence.BaseEntity
import java.util.UUID

@Entity
@Table(name = "tbl_breed")
class BreedJpaEntity(
    @Column(nullable = false, length = 200, name = "name")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "size")
    val size: BreedSize,

    id: UUID? = null
) : BaseEntity(id)