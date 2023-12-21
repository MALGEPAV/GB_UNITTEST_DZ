package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Product apples  = new Product();
        apples.setCost(100);;
        apples.setTitle("Apples");

        Product bread  = new Product();
        bread.setCost(50);;
        bread.setTitle("Bread");

        Product caviar  = new Product();
        caviar.setCost(5000);
        caviar.setTitle("Caviar");

        Product cheese  = new Product();
        cheese.setTitle("Cheese");
        cheese.setCost(300);

        List<Product> productList = List.of(apples,bread,caviar,cheese);
        Shop shop = new Shop();
        shop.setProducts(productList);


        //1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
        // (правильное количество продуктов, верное содержимое корзины).

        assertThat(shop.getProducts()).hasSize(productList.size()).containsAll(productList);

        //2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.

        assertThat(shop.getMostExpensiveProduct().getTitle())
                .isEqualTo("Caviar");
        //3. Напишите тесты для проверки корректности работы метода
        // sortProductsByPrice (проверьте правильность сортировки).
        assertThat(shop.sortProductsByPrice()).isSortedAccordingTo(Comparator.comparingInt(Product::getCost));
    }
}