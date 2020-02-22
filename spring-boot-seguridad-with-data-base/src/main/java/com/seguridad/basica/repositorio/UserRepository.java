package com.seguridad.basica.repositorio;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seguridad.basica.entidad.User;


/**
 * Dao para las operaciones de entrada y salidas
 * @author erosas
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}
