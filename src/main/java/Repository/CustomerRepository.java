package Repository;

import Entity.Admin;
import Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    private Connection connection;

    public CustomerRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(Customer customer) {
        try {
            String add = "INSERT INTO UserTable(fullName,nationalId,password,kind,address,budget) VALUES (?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getNationalId());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setString(4, String.valueOf(customer.getTypeUser()));
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setDouble(6, customer.getBalance());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public int update(Customer customer) {
        try {
            String update = "UPDATE UserTable SET fullName = ? , password = ? , address = ?  WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,customer.getFullName());
            preparedStatement.setString(2,customer.getPassword());
            preparedStatement.setString(3,customer.getAddress());
            preparedStatement.setInt(4,customer.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
