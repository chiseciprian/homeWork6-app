package ro.fasttrackit.homeWork6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homeWork6.domain.Product;
import ro.fasttrackit.homeWork6.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getProducts(String category, Integer maxPrice) {
        List<Product> products = repository.findAll();
        if (category != null) {
            products = filterProductsByCategory(products, category);
        }
        if (maxPrice != null) {
            products = filterByMaxPrice(products, maxPrice);
        }
        return products;
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    private List<Product> filterByMaxPrice(List<Product> products, Integer maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    private List<Product> filterProductsByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().toString().equals(category))
                .collect(Collectors.toList());
    }

    public Optional<Product> getProduct(Long id) {
        return repository.findById(id);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
