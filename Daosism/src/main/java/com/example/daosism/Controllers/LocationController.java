package com.example.daosism.Controllers;

import com.example.daosism.Dao.CRUD;
import com.example.daosism.Models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    private final CRUD<Location> locDao = new CRUD<>();
    private Location updateableLocation = null;
    int id = 0;
    public List<Optional<Location>> locs = new ArrayList<Optional<Location>>();

    @GetMapping("/Locations")
    public String Locations(Model model){
        locs = locDao.List;
        model.addAttribute("locs", locs);
        return "Locations";
    }

    @GetMapping("/deleteLocation/{locId}")
    public String DeleteLocation(@PathVariable("locId") int id) {
        for (int i = 0; i < locs.size(); i++) {
            if (locs.get(i).get().getId() == id) {
                locDao.delete(Optional.of(locs.get(i).get()));
            }
        }
        return "redirect:/Locations";
    }

    @GetMapping("/UpdateLocation/{locId}")
    public String UpdateLocation(@PathVariable("locId") Integer id, Model model) {
        for (int i = 0; i < locs.size(); i++) {
            if (locs.get(i).get().getId() == id) {
                updateableLocation = locs.get(i).get();
                model.addAttribute("name", locs.get(i).get().getName());
                model.addAttribute("id", locs.get(i).get().getId());
                model.addAttribute("address", locs.get(i).get().getAddress());
                model.addAttribute("description", locs.get(i).get().getDescription());
                model.addAttribute("countCells", locs.get(i).get().getCountCell());
                model.addAttribute("mainPerson", locs.get(i).get().getMainPerson());
            }
        }
        return "Location";
    }

    @GetMapping("/AddLocation")
    public String AddLocation(@ModelAttribute("name") String name, @ModelAttribute("address") String address, @ModelAttribute("description") String description, @ModelAttribute("countCells") Integer countCells, @ModelAttribute("mainPerson") String mainPerson){
        id++;
        locDao.create(Optional.of(new Location(name, address, description, countCells, mainPerson, id)));
        return "redirect:/Locations";
    }

    @PostMapping("/updateLocation")
    public String UpdatePerson(@ModelAttribute("name") String name, @ModelAttribute("address") String address, @ModelAttribute("description") String description, @ModelAttribute("countCells") Integer countCells, @ModelAttribute("mainPerson") String mainPerson, @ModelAttribute("id") Integer id){

        locDao.update(Optional.ofNullable(updateableLocation), Optional.of(new Location(name, address, description, countCells, mainPerson, id)));
        return "redirect:/Locations";
    }

    @GetMapping("/goIn")
    public String Index() {

        return "Index";
    }
}
