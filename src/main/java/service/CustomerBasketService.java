package service;

import entity.CustomerBasket;
import repository.CustomerBasketRepository;

import java.util.List;

public class CustomerBasketService implements Service<CustomerBasket> {
    private CustomerBasketRepository customerBasketRepository = new CustomerBasketRepository();


    @Override
    public int add(CustomerBasket customerBasket) {
        return customerBasketRepository.add(customerBasket);
    }

    @Override
    public List<CustomerBasket> findAll() {
        return null;
    }

    @Override
    public int update(CustomerBasket customerBasket) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return customerBasketRepository.delete(id);
    }

    public List<CustomerBasket> customerBasketById(int id){
        return customerBasketRepository.customerBasketById(id);
    }

    public int findIdBy(int customerId,int productId,int numberProduct){
        return customerBasketRepository.findIdBy(customerId,productId,numberProduct);
    }
}
