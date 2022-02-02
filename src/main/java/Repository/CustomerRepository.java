package Repository;

import entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            String findAll = "SELECT * FROM UserTable" ;
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);
            List<Customer> customerList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setFullName(resultSet.getString("fullName"));
                    customer.setNationalId(resultSet.getString("nationalId"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setBalance(resultSet.getDouble("budget"));
                    customer.setAddress(resultSet.getString("address"));
                    customerList.add(customer);
                }
                return customerList;
            } else
                return null;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
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
        try {
            String del = "DELETE FROM UserTable WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(del);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int addBudget(int id,Double amount){
        try {
            String deposit = "UPDATE UserTable SET budget = budget + ? where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(deposit);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setInt(2,id);
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public Double returnBudget(int id){
        try {
            String budget = "SELECT budget FROM UserTable WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(budget);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return resultSet.getDouble("budget");
            else
                return 0d;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0d;
    }



}
