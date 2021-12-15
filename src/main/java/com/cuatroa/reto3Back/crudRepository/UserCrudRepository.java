package com.cuatroa.reto3Back.crudRepository;

import com.cuatroa.reto3Back.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    //Métodos para autenticación de usuarios
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    
    //Para seleccionar el usuario con el id maor
    Optional<User> findTopByOrderByIdDesc();
}
