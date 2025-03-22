package team.gram.aspismain.persistence

interface GenericMapper<D,E> {
    fun toDomain(entity: E?): D?

    fun toEntity(domain: D): E
}