package shop.mtcoding.buyer3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.buyer3.model.Product;
import shop.mtcoding.buyer3.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping({ "/", "/product/list" })
    public String home(Model model) {
        List<Product> productList = productRepository.findALl();

        model.addAttribute("productList", productList);

        return "product/list";
    }

    @GetMapping("/product/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);

        return "product/detail";
    }
}
