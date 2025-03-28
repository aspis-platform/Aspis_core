package team.gram.aspismain.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import team.gram.aspismain.global.filter.ExceptionFilter
import team.gram.aspismain.global.filter.JwtFilter
import team.gram.aspismain.global.security.jwt.JwtParser
import team.gram.team.gram.aspismain.domain.auth.model.Authority

@Configuration
class SecurityConfig(
    private val authenticationEntryPoint: CustomAuthenticationEntryPoint,
    private val accessDeniedHandler: CustomAccessDeniedHandler,
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper

) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .cors(Customizer.withDefaults())
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http
            .authorizeHttpRequests { authorize ->
                authorize
                    // /healthcheck
                    .requestMatchers(HttpMethod.GET, "/").permitAll()
                authorize
                    // /animal
                    .requestMatchers(HttpMethod.GET, "/v1/animals/get-all").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.GET, "/v1/animals/**").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.POST, "/v1/animals").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.POST, "/v1/animals/").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.PUT, "/v1/animals/**").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.DELETE, "/v1/animals/**").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                authorize
                    // /users
                    .requestMatchers(HttpMethod.GET, "/users/password").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)
                    .requestMatchers(HttpMethod.PATCH, "/users/password").hasAnyAuthority(Authority.STAFF.name,Authority.MANAGER.name)

                authorize
                    // /students
                    .requestMatchers(HttpMethod.GET, "/students/email/duplication").permitAll()
                    .requestMatchers(HttpMethod.GET, "/students/account-id/duplication").permitAll()
                    .requestMatchers(HttpMethod.GET, "/students/account-id/{school-id}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/students/name").permitAll()
                    .requestMatchers(HttpMethod.GET, "/students/profile").hasAuthority(Authority.STAFF.name)
                    .requestMatchers(HttpMethod.POST, "/students/signup").permitAll()
                authorize
                    // /managers
                    .requestMatchers(HttpMethod.GET, "/managers/account-id/{school-id}").permitAll()
                    .requestMatchers(HttpMethod.PATCH, "/managers/password/initialization").permitAll()

                authorize
                    // /schools
                    .requestMatchers(HttpMethod.GET, "/schools").permitAll()
                    .requestMatchers(HttpMethod.GET, "/schools/question/{school-id}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/schools/answer/{school-id}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/schools/code").permitAll()
                    .anyRequest().denyAll()
            }
        val jwtFilter = JwtFilter(jwtParser)
        val exceptionFilter = ExceptionFilter(objectMapper)

        http.addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter::class.java)
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)

        http
            .exceptionHandling { exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
            }
        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}