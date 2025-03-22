package team.gram.team.gram.aspismain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(basePackages = ["team.gram"])
@EnableJpaRepositories(basePackages = ["team.gram.aspismain.persistence"])
@EntityScan(basePackages = ["team.gram.aspismain.persistence"])
@SpringBootApplication
class AspisMainServerApplication

fun main(args: Array<String>) {
	runApplication<AspisMainServerApplication>(*args)
}