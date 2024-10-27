import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.plan.NotFoundException;
import ru.netology.plan.Product;
import ru.netology.plan.ShopRepository;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Лаваш", 100);
        Product product2 = new Product(2, "Капуста", 150);

        repo.add(product1);
        repo.add(product2);

        repo.removeById(1);

        Product[] expected = {product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionProduct() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Лаваш", 100);
        Product product2 = new Product(2, "Капуста", 150);

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(3);
        });
    }

}

