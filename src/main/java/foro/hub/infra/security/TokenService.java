package foro.hub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import foro.hub.domain.usuarios.Usuario;
import foro.hub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro")
                    .withSubject(usuario.getUsername())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new IllegalArgumentException("El token es nulo.");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // Usa la clave secreta definida en la configuración
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("foro")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token); // Verifica el token con la clave correcta
            return decodedJWT.getSubject(); // Retorna el "subject" (normalmente el email o username)
        } catch (JWTVerificationException e) {
            throw new IllegalArgumentException("Token no válido: " + e.getMessage(), e);
        }
    }


        private Instant generarFechaExpiracion () {
            return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
        }

    }