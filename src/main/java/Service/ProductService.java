package Service;

import Entity.Product;

import java.util.List;

public class ProductService implements Service<Product> {
    @Override
    public int add(Product product) {
        return 0;
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
