package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(3, "Book 1", 120, "Author 1");
    Product product2 = new Book(8, "Book 2", 110, "Author 2");
    Product product3 = new Book(11, "Book 3", 115, "Author 3");
    Product product4 = new Smartphone(12, "Smartphone 1", 120, "Producer 1");
    Product product5 = new Smartphone(16, "Smartphone 2", 95, "Producer 2");
    Product product6 = new Smartphone(19, "Smartphone 3", 9500, "Producer 3");

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(12);

        Product[] expected = {product1, product2, product3, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(15);
        });
    }

    @Test
    public void shouldSaveProduct() {

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionSaveProduct() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product5);
        });
    }
}
