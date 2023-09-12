package com.example.daosism.Controllers;

import com.example.daosism.Dao.CRUD;
import com.example.daosism.Models.Transport;
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
public class TransportController {
    private final CRUD<Transport> transpDao = new CRUD<>();
    private Transport updateableTransport = null;
    int id = 0;
    public List<Optional<Transport>> transp = new ArrayList<Optional<Transport>>();

    @GetMapping("/Transports")
    public String Transports(Model model){
        transp = transpDao.List;
        model.addAttribute("transp", transp);
        return "Transports";
    }

    @GetMapping("/deleteTransport/{transpId}")
    public String DeleteTransport(@PathVariable("transpId") int id) {
        for (int i = 0; i < transp.size(); i++) {
            if (transp.get(i).get().getId() == id) {
                transpDao.delete(Optional.of(transp.get(i).get()));
            }
        }
        return "redirect:/Transports";
    }

    @GetMapping("/UpdateTransport/{transpId}")
    public String UpdateLocation(@PathVariable("transpId") Integer id, Model model) {
        for (int i = 0; i < transp.size(); i++) {
            if (transp.get(i).get().getId() == id) {
                updateableTransport = transp.get(i).get();
                model.addAttribute("name", transp.get(i).get().getName());
                model.addAttribute("id", transp.get(i).get().getId());
                model.addAttribute("number", transp.get(i).get().getNumber());
                model.addAttribute("description", transp.get(i).get().getDescription());
                model.addAttribute("driver", transp.get(i).get().getDriver());
                model.addAttribute("location", transp.get(i).get().getLocation());
            }
        }
        return "Transport";
    }

    @GetMapping("/AddTransport")
    public String AddTransport(@ModelAttribute("name") String name, @ModelAttribute("number") String number, @ModelAttribute("description") String description, @ModelAttribute("driver") String driver, @ModelAttribute("location") String location){
        id++;
        transpDao.create(Optional.of(new Transport(name, number, description, driver, location, id)));
        return "redirect:/Transports";
    }

    @PostMapping("/updateTransport")
    public String UpdateTransport(@ModelAttribute("name") String name, @ModelAttribute("number") String number, @ModelAttribute("description") String description, @ModelAttribute("driver") String driver, @ModelAttribute("location") String location, @ModelAttribute("id") Integer id){

        transpDao.update(Optional.ofNullable(updateableTransport), Optional.of(new Transport(name, number, description, driver, location, id)));
        return "redirect:/Transports";
    }

    @GetMapping("/goI")
    public String Index() {

        return "Index";
    }
}
