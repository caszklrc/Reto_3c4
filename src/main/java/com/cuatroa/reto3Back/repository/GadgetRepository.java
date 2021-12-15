package com.cuatroa.reto3Back.repository;

import com.cuatroa.reto3Back.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.reto3Back.crudRepository.GadgetCrudRepository;
//import static org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id;//

/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */
@Repository
public class GadgetRepository {
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;

    public List<Gadget> getAll() {
        return gadgetCrudRepository.findAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return gadgetCrudRepository.findById(id);
    }
    
    public Gadget create(Gadget accesory) {
        return gadgetCrudRepository.save(accesory);
    }

    public void update(Gadget accesory) {
        gadgetCrudRepository.save(accesory);
    }
    
    public void delete(Gadget accesory) {
        gadgetCrudRepository.delete(accesory);
    }

    public Optional<Gadget> getGadget(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
