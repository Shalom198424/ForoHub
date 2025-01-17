package foro.hub.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByActivoTrue(Pageable pageable);
    UserDetails findByEmail(String username);
    boolean existsByEmail(@NotBlank String email);
    boolean existsByUsername(@NotBlank(message = "Utilice su correo electrónico como nombre de usuario") @Email String username);
}