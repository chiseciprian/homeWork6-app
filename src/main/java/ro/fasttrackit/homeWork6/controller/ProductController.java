package ro.fasttrackit.homeWork6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homeWork6.domain.Product;
import ro.fasttrackit.homeWork6.exception.ProductNotFoundException;
import ro.fasttrackit.homeWork6.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getProducts(@RequestParam(required = false) String category,
                              @RequestParam(required = false) Integer maxPrice) {
        return service.getProducts(category, maxPrice);
    }

    @GetMapping(path = "/{id}")
    Product getProduct(@PathVariable Long id) {
        return service.getProduct(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with " + id + " doesn't exist"));
    }

    @PostMapping
    void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @DeleteMapping(path = "/{id}")
    void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
