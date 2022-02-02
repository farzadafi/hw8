package Repository;

import Entity.SaleProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaleProductRepository implements Repository<SaleProduct> {
    private Connection connection;

    public SaleProductRepository() {
        try{
            connection = Singleton.getInstance().getConnection();
            String CreateTable = "CREATE TABLE IF NOT EXISTS SaleProduct(id serial PRIMARY KEY," +
                    "customerId integer REFERENCES UserTable(id)," +
                    "productId integer ," +
                    "numberProduct integer," +
                    "price DECIMAL," +
                    "dateFinal DATE)";
            PreparedStatement preparedStatement = connection.prepareStatement(CreateTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(SaleProduct saleProduct) {
        try {
            String add = "INSERT INTO SaleProduct(customerId,productId,numberProduct,price,dateFinal) VALUES (?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1,saleProduct.getCustomerId());
            preparedStatement.setInt(2,saleProduct.getProductId());
            preparedStatement.setInt(3,saleProduct.getNumber());
            preparedStatement.setDouble(4,saleProduct.getTotalPrice());
            preparedStatement.setDate(5,saleProduct.getDate());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public List<SaleProduct> findAll() {
        return null;
    }

    @Override
    public int update(SaleProduct saleProduct) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
