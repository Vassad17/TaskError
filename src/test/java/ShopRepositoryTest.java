import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.plan.AlreadyExistsException;
import ru.netology.plan.NotFoundException;
import ru.netology.plan.Product;
import ru.netology.plan.ShopRepository;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Лаваш", 100);
        Product product2 = new Product(2, "Капуста", 150);
        Product product3 = new Product(3, "Курица", 600);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(3);

        Product[] expected = {product1, product2};
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

    @Test
    public void shouldAddProductIdTrue() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 60);
        Product product2 = new Product(2, "Капуста", 150);

        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductIdPovtor() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Лаваш", 100);
        Product product2 = new Product(2, "Капуста", 150);
        Product product3 = new Product(2, "Coca Cola", 150);

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product3);
        });
    }
}

