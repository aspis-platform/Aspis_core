package team.gram.aspismain.domain.breed.repository.entity

import jakarta.persistence.*
import team.gram.aspismain.domain.breed.domain.BreedSize

@Entity()
@Table(name = "tbl_breed_name")
data class Breed(
    @Id
    @Column(name = "breed_name")
    val breedName: String,

    @Column(name = "breed_size")
    @Enumerated(EnumType.ORDINAL)
    val breedSize: BreedSize
)