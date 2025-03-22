package team.gram.aspismain.persistence.animal.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import team.gram.aspismain.domain.animal.model.AnimalSexType
import team.gram.aspismain.domain.animal.model.AnimalStatusType
import team.gram.aspismain.persistence.BaseEntity
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "tbl_animal")
class AnimalJpaEntity(
    @Column(nullable = false)
    val breedId: UUID,

    @Column(nullable = false)
    val helperId: UUID,

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = false)
    val admissionDate: Date,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val sex: AnimalSexType,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val animalStatus: AnimalStatusType,

    @Column(name = "profile_url", length = 255)
    val profileUrl: String,

    id: UUID? = null
) : BaseEntity(id)