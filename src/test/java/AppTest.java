import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StoreRepository;

import java.io.IOException;



/**
 * Created by gobi on 4/2/18.
 */

public class AppTest{

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

    @Test
    public void testAdd() throws IOException {
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

    @Test
    public void testAddMaxIntCode() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(Integer.MAX_VALUE + 1);
        product.setName(PRODUCT_NAME);
        product.setQuantity(PRODUCT_QUANTITY);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testAddMaxIntQuantity() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(Integer.MAX_VALUE + 1);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }


    @Test
    public void testAddNullCategory() throws IOException {
        Product product = new Product();

        product.setCategory(null);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(Integer.MAX_VALUE + 1);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testAddNullSupplier() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(Integer.MAX_VALUE + 1);
        product.setSupplier(null);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testAddNullName() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(null);
        product.setQuantity(Integer.MAX_VALUE + 1);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testAddNullCode() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(0);
        product.setName(PRODUCT_NAME);
        product.setQuantity(Integer.MAX_VALUE + 1);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testAddNullQuantity() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(-1);
        product.setSupplier(PRODUCT_SUPPLIER);

        int size = repository.getAllProducts().size();

        repository.addNewProduct(product);

        Assert.assertEquals(size, repository.getAllProducts().size());
    }

    @Test
    public void testGetProductCategories() throws IOException{
        Product product = new Product();

        product.setCategory("5lei");
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(PRODUCT_QUANTITY);
        product.setSupplier(PRODUCT_SUPPLIER);

        repository.addNewProduct(product);

        Assert.assertTrue(repository.getProductsCategory(PRODUCT_CATEGORY).isEmpty());
    }

    @Test
    public void testGetProductCategorieswAdd() throws IOException {
        Product product = new Product();

        product.setCategory(PRODUCT_CATEGORY);
        product.setCode(PRODUCT_CODE);
        product.setName(PRODUCT_NAME);
        product.setQuantity(PRODUCT_QUANTITY);
        product.setSupplier(PRODUCT_SUPPLIER);

        repository.addNewProduct(product);

        Assert.assertFalse(repository.getProductsCategory(PRODUCT_CATEGORY).isEmpty());
    }

    @Test
    public void testGetProductCategoriesEmptyList(){
        Assert.assertTrue(repository.getProductsCategory(PRODUCT_CATEGORY).isEmpty());
    }
}
