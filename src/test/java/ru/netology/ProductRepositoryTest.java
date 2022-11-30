package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Product(3, "Book 1", 120);
    Product product2 = new Product(8, "Book 2", 110);
    Product product3 = new Product(11, "Book 3", 115);
    Product product4 = new Product(12, "Book 4", 120);
    Product product5 = new Product(16, "Book 5", 95);

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
    }

    @Test
    public void shouldRemoveBiId() {
        repo.removeById(12);

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
