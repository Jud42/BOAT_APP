package com.example.boat.service;

import com.example.boat.dao.BoatRepository;
import com.example.boat.model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Boat createBoat(Boat boat) {

        return boatRepository.save(boat);
    }

    public String getBoatById(Long id) {
        Boat boat = boatRepository.findById(id).orElse(null);
        if (boat != null && boat.getName() != null)
            return boat.getDescription();
        else
            return null;
    }

    public List<String> getBoats() {
        List<Boat> boats = boatRepository.findAll();
        List<String> boatNames = new ArrayList<>();

        for (Boat boat : boats) {
            boatNames.add(boat.getName());
        }

        return boatNames;
    }

    public Boat updateBoat(Boat boat) {
        Boat oldboat=null;
        Optional<Boat> optboat=boatRepository.findById(boat.getId());
        if (optboat.isPresent()) {
            oldboat=optboat.get();
            oldboat.setName(boat.getName());
            oldboat.setDescription(boat.getDescription());
            boatRepository.save(oldboat);
        }
        else {
            return boat;
        }
        return oldboat;
    }

    public String deleteBoatById(Long id) {
        boatRepository.deleteById(id);
        return "Boat deleted";
    }

    public String deleteAllBoatId(List<Long> ids) {
        boatRepository.deleteAllById(ids);
        return "selection deleted";
    }
}
