package mk.ukim.finki.wp.kol2022.g3.web;

import mk.ukim.finki.wp.kol2022.g3.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<Category> findAll(){
        return Arrays.asList(Category.values());
    }
}
