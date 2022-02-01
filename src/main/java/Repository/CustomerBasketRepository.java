package Repository;

import Entity.Admin;
import Entity.CustomerBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerBasketRepository implements Repository<CustomerBasket> {
    private Connection connection;

    public CustomerBasketRepository() {
        try{
            connection = Singleton.getInstance().getConnection();
            String CreateTable = "CREATE TABLE IF NOT EXISTS CustomerBasket(id serial PRIMARY KEY," +
                    "customerId integer REFERENCES UserTable(id)," +
                    "productId integer ," +
                    "numberProduct integer," +
                    "price DECIMAL)";
            PreparedStatement preparedStatement = connection.prepareStatement(CreateTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(CustomerBasket customerBasket) {
        try {
            String add = "INSERT INTO CustomerBasket(customerId,productId,numberProduct,price) VALUES (?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1, customerBasket.getCustomerId());
            preparedStatement.setInt(2, customerBasket.getProductId());
            preparedStatement.setInt(3, customerBasket.getNumber());
            preparedStatement.setDouble(4, customerBasket.getTotalPrice());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
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
