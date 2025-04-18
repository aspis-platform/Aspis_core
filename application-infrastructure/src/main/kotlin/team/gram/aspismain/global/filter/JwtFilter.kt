package team.gram.aspismain.global.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import team.gram.aspismain.global.security.jwt.JwtParser
import team.gram.aspismain.global.security.jwt.JwtProperties

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = resolvedToken(request)

        SecurityContextHolder.clearContext()
        token?.let {
            SecurityContextHolder.getContext().authentication = jwtParser.getAuthentication(token)
        }
        filterChain.doFilter(request, response)
    }

    private fun resolvedToken(request: HttpServletRequest): String? =
        request.getHeader(JwtProperties.HEADER)?.also {
            if (it.startsWith(JwtProperties.PREFIX)) {
                return it.substring(JwtProperties.PREFIX.length)
            }
        }
}