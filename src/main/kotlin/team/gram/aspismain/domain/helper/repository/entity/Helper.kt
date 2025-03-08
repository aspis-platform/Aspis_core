package team.gram.aspismain.domain.helper.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "tbl_helper")
data class Helper(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "helper_id")
    val helperId: String,

    @Column(name = "helper_name", unique = true)
    val helperName: String,
)