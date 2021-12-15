package com.cuatroa.reto3Back.controller;

import com.cuatroa.reto3Back.model.User;
import com.cuatroa.reto3Back.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
 * Clase publica Usercontroller
 */
public class UserController {

    @Autowired
     /**
     * Método pars llamar los servicios
     */
    private UserService userService;

    @GetMapping("/all")
     /**
     * Hacer llamados get
     */
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
     /**
     * Hacer llamados get por Id
     */
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
     /*
     * Peticion new (POST)
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
     /**
     * Peticion update para actualizar (PUT)
     * @param user
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
     /**
     * Peticion email
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * clase verificar email
     * @param email
     * @return 
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
