package com.projector.security.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import com.projector.security.jwt.SecurityConstants.EXPIRATION_TIME
import com.projector.security.jwt.SecurityConstants.HEADER_STRING
import com.projector.security.jwt.SecurityConstants.SECRET
import com.projector.security.jwt.SecurityConstants.TOKEN_PREFIX
import com.projector.users.modal.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthenticationFilter(private var authManager: AuthenticationManager): UsernamePasswordAuthenticationFilter() {
    init {
        authenticationManager = authManager
    }

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(
            req: HttpServletRequest, res: HttpServletResponse): Authentication {
        val creds = ObjectMapper()
                .readValue(req.inputStream, User::class.java)
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        creds.email,
                        creds.password.toString(),
                        emptyList<GrantedAuthority>()
                )
        )
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse, chain: FilterChain?,
            auth: Authentication) {
        val JWT = Jwts.builder()
                .setSubject((auth.principal as User).email)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact()
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT)
    }
}