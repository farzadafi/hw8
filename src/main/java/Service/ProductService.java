package Service;

import Entity.Product;
import Repository.ProductRepository;

import java.util.List;

public class ProductService implements Service<Product> {
    private ProductRepository productRepository = new ProductRepository();


    @Override
    public int add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
