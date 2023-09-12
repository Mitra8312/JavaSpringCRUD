package com.example.daosism.Controllers;

import com.example.daosism.Dao.CRUD;
import com.example.daosism.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private CRUD<Product> productDao = new CRUD<>();
    private Product updateableProduct = null;
    int id = 0;
    public List<Optional<Product>> products = new ArrayList<Optional<Product>>();
    @GetMapping("/Products")
    public String Product(Model model){
        products = productDao.List;

        model.addAttribute("products", products);
        return "Products";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String DeleteProduct(@PathVariable("productId") int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).get().getId() == id) {
                productDao.delete(Optional.of(products.get(i).get()));
            }
        }
        return "redirect:/Products";
    }

    @GetMapping("/UpdateProduct/{productId}")
    public String UpdateProduct(@PathVariable("productId") int id, Model model) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).get().getId() == id) {
                updateableProduct = products.get(i).get();
                model.addAttribute("name1", products.get(i).get().getName());
                model.addAttribute("id1", products.get(i).get().getId());
                model.addAttribute("quantity1", products.get(i).get().getQuantity());
                model.addAttribute("article1", products.get(i).get().getArticle());
                model.addAttribute("price1", products.get(i).get().getPrice());
                model.addAttribute("owner1", products.get(i).get().getOwner());

            }
        }
        return "Product";
    }

    @PostMapping("/AddProduct")
    public String AddProduct(@ModelAttribute("name") String name, @ModelAttribute("article") String article, @ModelAttribute("owner") String owner, @ModelAttribute("quantity") String quantity, @ModelAttribute("price") String price){
        id++;
        productDao.create(Optional.of(new Product(name, article, owner, quantity, price, id)));
        return "redirect:/Products";
    }

    @PostMapping("/updateProduct")
    public String UpdateProduct(@ModelAttribute("name1") String name, @ModelAttribute("article1") String article, @ModelAttribute("owner1") String owner, @ModelAttribute("quantity1") String quantity, @ModelAttribute("price1") String price, @ModelAttribute("id1") Integer id){

        productDao.update(Optional.ofNullable(updateableProduct), Optional.of(new Product(name, article, owner, quantity, price, id)));
        return "redirect:/Products";
    }

    @GetMapping("/goIndex")
    public String Index() {

        return "Index";
    }
}
