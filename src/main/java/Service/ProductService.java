package Service;

import entity.Product;
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
        return productRepository.update(product);
    }

    @Override
    public int delete(int id) {
       return productRepository.delete(id);
    }

    public List<Product> showAdminProduct(int id){
        return productRepository.showAdminProduct(id);
    }

    public List<Product> showProductForCustomer(int idCategory,int idBrand){
        return productRepository.showProductForCustomer(idCategory,idBrand);
    }

    public int returnNumberProduct(int id){
        return productRepository.returnNumberProduct(id);
    }

    public int minesNumberProduct(int id,int number){
        return productRepository.minesNumberProduct(id,number);
    }
}
