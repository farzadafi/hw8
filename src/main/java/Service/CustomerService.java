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
        return customerRepository.update(customer);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    public int addBudget(int id,Double amount){
        return customerRepository.addBudget(id,amount);
    }

    public Double returnBudget(int id){
        return customerRepository.returnBudget(id);
    }






}
