import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StoreRepository;

import java.io.IOException;

/**
 * Created by gobi on 4/24/18.
 */
public class IntegrationHomeworkTest {

    private static final String PRODUCT_CATEGORY = "abc";
    private static final int PRODUCT_CODE = 1;
    private static final String PRODUCT_NAME = "BEMVEU";
    private static final int PRODUCT_QUANTITY = 1;
    private static final String PRODUCT_SUPPLIER = "abc";
    private StoreRepository repository;

    @Before
    public void initialize(){
        this.repository = new StoreRepository();
        repository.setFile("testFile.txt");
    }

    public void testAdd() throws IOException {
        repository.setFile("testFile.txt");
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(PRODUCT_QUANTITY);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size + 1, repository.getAllProducts().size());
    }

    public void testGetProductCategories(){
        Assert.assertFalse(repository.getProductsCategory(PRODUCT_CATEGORY).isEmpty());
    }

    public void testGetStockDifferentName() throws IOException{
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName("gobi");
        product.setQuantity(PRODUCT_QUANTITY);
        product.setSupplier(PRODUCT_SUPPLIER);

        repository.addNewProduct(product);

        Assert.assertFalse(repository.stockSituation().isEmpty());
    }


    @Test
    public void testIntegrate() throws IOException{
        testAdd();
        testGetProductCategoriesAndAdd();
        testGetProductCategoriesAndAddAndGetStock();
    }

    private void testGetProductCategoriesAndAddAndGetStock() throws IOException {
        testAdd();
        testGetProductCategories();
        testGetStockDifferentName();
    }

    private void testGetProductCategoriesAndAdd() throws IOException {
        testAdd();
        testGetProductCategories();
    }

}
