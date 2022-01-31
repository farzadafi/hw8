package Service;

import Entity.Customer;
import Repository.CustomerRepository;

import java.util.List;

public class CustomerService implements Service<Customer> {
    CustomerRepository customerRepository = new CustomerRepository();


    @Override
    public int add(Customer customer) {
        return customerRepository.add(customer);
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
