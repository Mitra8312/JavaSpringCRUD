package com.example.daosism.Controllers;

import com.example.daosism.Dao.CRUD;
import com.example.daosism.Models.Cell;
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
public class CellController {
    private CRUD<Cell> CellDao = new CRUD<>();
    private Cell updateableCell = null;
    int id = 0;
    public List<Optional<Cell>> cells = new ArrayList<Optional<Cell>>();

    @GetMapping("/Cells")
    public String Cells(Model model){
        cells = CellDao.List;

        model.addAttribute("cells", cells);
        return "Cells";
    }

    @GetMapping("/deleteCell/{cellId}")
    public String DeleteCell(@PathVariable("cellId") int id) {
        for (int i = 0; i <= cells.size(); i++) {
            if (cells.get(i).get().getId() == id) {
                CellDao.delete(Optional.of(cells.get(i).get()));
            }
        }
        return "Cells";
    }

    @GetMapping("/UpdateCell/{cellId}")
    public String UpdateCell(@PathVariable("cellId") Integer id, Model model) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).get().getId() == id) {
                updateableCell = cells.get(i).get();
                model.addAttribute("name", cells.get(i).get().getName());
                model.addAttribute("id", cells.get(i).get().getId());
                model.addAttribute("level", cells.get(i).get().getLevel());
                model.addAttribute("hash", cells.get(i).get().getHash());
                model.addAttribute("loc", cells.get(i).get().getLoc());
                model.addAttribute("product", cells.get(i).get().getProduct());
            }
        }
        return "Cell";
    }

    @PostMapping("/AddCell")
    public String AddCell(@ModelAttribute("name") String name, @ModelAttribute("level") Integer level, @ModelAttribute("hash") String hash, @ModelAttribute("loc") String loc, @ModelAttribute("product") String product){
        id++;
        CellDao.create(Optional.of(new Cell(name, level, hash, loc, product, id)));
        return "redirect:/Cells";
    }

    @PostMapping("/updateCell")
    public String UpdateCell(@ModelAttribute("name") String name, @ModelAttribute("level") Integer level, @ModelAttribute("hash") String hash, @ModelAttribute("loc") String loc, @ModelAttribute("product") String product, @ModelAttribute("id") Integer id){

        CellDao.update(Optional.ofNullable(updateableCell), Optional.of(new Cell(name, level, hash, loc, product, id)));
        return "redirect:/Cells";
    }

    @GetMapping("/goInd")
    public String Index() {

        return "Index";
    }
}
