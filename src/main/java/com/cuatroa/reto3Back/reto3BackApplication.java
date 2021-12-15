package com.cuatroa.reto3Back;

import com.cuatroa.reto3Back.crudRepository.GadgetCrudRepository;
import com.cuatroa.reto3Back.crudRepository.OrderCrudRepository;
import com.cuatroa.reto3Back.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */
@Component
@SpringBootApplication   //Esta clase permite que spring despliegue los servicios web en Tonked//
public class reto3BackApplication implements CommandLineRunner {

    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;
   
    public static void main(String[] args) {
        SpringApplication.run(reto3BackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
       gadgetCrudRepository.deleteAll();
       userCrudRepository.deleteAll();
       orderCrudRepository.deleteAll();
        }
    }
