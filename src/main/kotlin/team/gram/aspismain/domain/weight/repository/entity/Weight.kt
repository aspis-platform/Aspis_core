package team.gram.aspismain.domain.weight.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "tbl_weight")
data class Weight(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "weight_id")
    val animalId: String,

    @Column(name = "value", unique = true)
    val value: String,
)