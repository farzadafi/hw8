package Repository;

import Entity.CustomerBasket;

import java.util.List;

public class CustomerBasketRepository implements Repository<CustomerBasket> {
    @Override
    public int add(CustomerBasket customerBasket) {
        return 0;
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
        return 0;
    }
}
