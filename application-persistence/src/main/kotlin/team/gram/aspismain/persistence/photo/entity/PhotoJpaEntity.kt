package team.gram.aspismain.persistence.photo.entity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import team.gram.aspismain.domain.breed.model.BreedSize
import team.gram.aspismain.domain.user.model.UserAuthority
import team.gram.aspismain.persistence.BaseEntity
import java.util.UUID

@Entity
@Table(name = "tbl_photo")
class photoJpaEntity(
    @Column(nullable = false, length = 200, name = "name")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "size")
    val size: BreedSize,

    id: UUID? = null
) : BaseEntity(id)