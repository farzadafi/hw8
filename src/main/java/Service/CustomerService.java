package Service;

import Entity.Customer;

import java.util.List;

public class CustomerService implements Service<Customer> {
    @Override
    public int add(Customer customer) {
        return 0;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
