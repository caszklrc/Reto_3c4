package com.cuatroa.reto3Back.service;

import com.cuatroa.reto3Back.model.Gadget;
import com.cuatroa.reto3Back.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author  CarlosSacristan
 * @version 1.0
 * @since   2021-12-09
 */
@Service
public class GadgetService {

    @Autowired
    private GadgetRepository gadgetRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Gadget> getAll() {
        return gadgetRepository.getAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return gadgetRepository.getGadget(id);
    }
    public Optional<Gadget> getAccesory(int id){
        return gadgetRepository.getGadget(id);
    }

    public Gadget create(Gadget gadget) {
        if (gadget.getId() == null) {
            return gadget;
        } else {
            return gadgetRepository.create(gadget);
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId()!= null) {
            Optional<Gadget> gadgetDb = gadgetRepository.getGadget(gadget.getId());
            if (gadgetDb.isPresent()) {
                if (gadget.getBrand() != null) {
                    gadgetDb.get().setBrand(gadget.getBrand());
                }

                if (gadget.getCategory() != null) {
                    gadgetDb.get().setCategory(gadget.getCategory());
                }

                if (gadget.getName()!= null) {
                    gadgetDb.get().setName(gadget.getName());
                }

                if (gadget.getDescription() != null) {
                    gadgetDb.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != 0.0) {
                    gadgetDb.get().setPrice(gadget.getPrice());
                }
                if (gadget.getQuantity() != 0) {
                   gadgetDb.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    gadgetDb.get().setPhotography(gadget.getPhotography());
                }
                gadgetDb.get().setAvailability(gadget.isAvailability());
                gadgetRepository.update(gadgetDb.get());
                return gadget;
            } else {
                return gadgetDb.get();
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getGadget(id).map(accesory -> {
            gadgetRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
