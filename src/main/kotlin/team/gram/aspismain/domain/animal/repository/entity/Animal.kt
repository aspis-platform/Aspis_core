package team.gram.aspismain.domain.animal.repository.entity

import jakarta.persistence.*
import team.gram.aspismain.domain.animal.repository.entity.enums.AnimalStatus
import team.gram.aspismain.domain.animal.repository.entity.enums.Gender

@Entity
@Table(name = "tbl_animal")
data class Animal(
    @Id //PK
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "animal_id")
    val animalId: String,

    @Column(name = "animal_name", unique = true) //Unique
    val animalName: String,

    @Column(name = "admission_date" , nullable = true)
    val admissionDate: String,

    @Column(name = "animal_gender")
    @Enumerated(EnumType.ORDINAL)
    val animalGender: Gender,

    @Column(name = "animal_status")
    @Enumerated(EnumType.ORDINAL)
    val animalStatus: AnimalStatus,

    @Column(name = "is_neutered")
    val isNeutred: Boolean,

    @Column(name = "profile_url")
    val profileUrl: String,

    @Column(name = "is_vaccinated")
    val isVaccinated: Boolean
)