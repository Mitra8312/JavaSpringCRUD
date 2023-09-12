package com.example.daosism.Controllers;

import com.example.daosism.Dao.CRUD;
import com.example.daosism.Models.Person;
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
public class PersonController {
    private CRUD<Person> personDao = new CRUD<>();
    private Person updateablePerson = null;
    int id = 0;
    public List<Optional<Person>> perses = new ArrayList<Optional<Person>>();

    @GetMapping("/People")
    public String People(Model model){
        perses = personDao.List;

        model.addAttribute("perses", perses);
        return "People";
    }

    @GetMapping("/deletePerson/{personId}")
    public String DeletePerson(@PathVariable("personId") int id) {
        for (int i = 0; i <= perses.size(); i++) {
            if (perses.get(i).get().getId() == id) {
                personDao.delete(Optional.of(perses.get(i).get()));
            }
        }
        return "redirect:/People";
    }

    @GetMapping("/UpdatePerson/{personId}")
    public String UpdatePerson(@PathVariable("personId") Integer id, Model model) {
        for (int i = 0; i < perses.size(); i++) {
            if (perses.get(i).get().getId() == id) {
                updateablePerson = perses.get(i).get();
                model.addAttribute("name1", perses.get(i).get().getName());
                model.addAttribute("id1", perses.get(i).get().getId());
                model.addAttribute("secondName1", perses.get(i).get().getSecondName());
                model.addAttribute("age1", perses.get(i).get().getAge());
                model.addAttribute("family1", perses.get(i).get().getFamily());
            }
        }
        return "Person";
    }

    @GetMapping("/AddPeople")
    public String AddPerson(@ModelAttribute("name") String name, @ModelAttribute("secondName") String secondname, @ModelAttribute("age") Integer age, @ModelAttribute("family") String family){
        id++;
        personDao.create(Optional.of(new Person(name, secondname, age, family, id)));
        return "redirect:/People";
    }

    @PostMapping("/updatePerson")
    public String UpdatePerson(@ModelAttribute("name1") String name, @ModelAttribute("secondName1") String secondname, @ModelAttribute("age1") Integer age, @ModelAttribute("family1") String family, @ModelAttribute("id1") Integer id){

        personDao.update(Optional.ofNullable(updateablePerson), Optional.of(new Person(name, secondname, age, family, id)));
        return "redirect:/People";
    }

    @GetMapping("/goInde")
    public String Index() {

        return "Index";
    }
}
