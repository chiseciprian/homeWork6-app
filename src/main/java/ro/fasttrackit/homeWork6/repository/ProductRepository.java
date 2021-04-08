package ro.fasttrackit.homeWork6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homeWork6.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
