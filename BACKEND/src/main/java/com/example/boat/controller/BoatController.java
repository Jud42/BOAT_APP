package com.example.boat.controller;

import com.example.boat.model.Boat;
import com.example.boat.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/")
    public List<String> getAllBoats() {
        return boatService.getBoats();
    }

    @GetMapping("/getBoat/{id}")
    public String getBoatById(@PathVariable Long id) {
        return boatService.getBoatById(id);
    }

    @PostMapping("/addBoat")
    public Boat createBoat(@RequestBody Boat boat) {
        return boatService.createBoat(boat);
    }
    @PutMapping("/updBoat")
    public Boat updateBoat(@RequestBody Boat boat) {
        return boatService.updateBoat(boat);
    }

    @DeleteMapping("/deleteBoat/{id}")
    public String deleteBoat(@PathVariable Long id) {
        return boatService.deleteBoatById(id);
    }

    @DeleteMapping("/deleteBoats")
    public void deleteBoats(@RequestParam("ids") List<Long> ids) {
        boatService.deleteAllBoatId(ids);
    }
}
