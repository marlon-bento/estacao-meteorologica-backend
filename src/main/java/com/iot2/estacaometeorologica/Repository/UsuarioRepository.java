package com.iot2.estacaometeorologica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot2.estacaometeorologica.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
//    @Query("SELECT u FROM Usuario u WHERE LOWER(unaccent(u.name)) = LOWER(unaccent(:nome))")
//    Optional<Usuario> findByNome(@Param("nome") String nome);

//    Usuario findByUsername(String username);


    Usuario findByUsername(String username);

    @Query("from Usuario u where LOWER(u.name) = LOWER(:name)")
    Usuario findByName(String name);
}
