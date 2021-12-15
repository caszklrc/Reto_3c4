package com.cuatroa.reto3Back.crudRepository;

import com.cuatroa.reto3Back.model.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    List<Order> findBySalesManZone(String zone);
}
