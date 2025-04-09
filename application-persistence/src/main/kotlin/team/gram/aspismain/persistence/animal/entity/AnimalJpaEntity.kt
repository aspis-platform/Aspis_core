package team.gram.aspismain.persistence.animal.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import team.gram.aspismain.domain.animal.model.AnimalSexType
import team.gram.aspismain.domain.animal.model.AnimalStatusType
import team.gram.aspismain.persistence.BaseEntity
import java.time.Year
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "tbl_animal")
class AnimalJpaEntity(
    @Column(name = "breed_id",nullable = false)
    val breedId: UUID,

    @Column(name = "helper_id", nullable = true)
    val helperId: UUID?,

    @Column(name = "name",nullable = false, length = 100)
    val name: String,

    @Column(name = "is_neutered",nullable = false)
    val isNeutered: Boolean,

    @Enumerated(EnumType.STRING)
    @Column(name = "sex",nullable = false)
    val sex: AnimalSexType,

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_status",nullable = false)
    val animalStatus: AnimalStatusType,

    @Column(name = "profile_url", length = 255)
    val profileUrl: String,

    @Column(name = "birth_year", length = 4)
    val birthYear: Int,

    id: UUID? = null
) : BaseEntity(id)