package Repository;

import Entity.Admin;
import Entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    private Connection connection;

    public ProductRepository() {
        try {
            this.connection = Singleton.getInstance().getConnection();
            String CreateTable = "CREATE TABLE IF NOT EXISTS Product(id serial PRIMARY KEY," +
                    "adminId integer REFERENCES UserTable(id)," +
                    "categoryId integer ," +
                    "brandId integer REFERENCES Category(id)," +
                    "nameProduct varchar(50)," +
                    "numberProduct integer," +
                    "price DECIMAL)";
            PreparedStatement preparedStatement = connection.prepareStatement(CreateTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(Product product) {
        try {
            String add = "INSERT INTO Product(adminId,categoryId,brandId,nameProduct,numberProduct,price) VALUES (?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1, product.getAdminId());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setInt(3, product.getBrandId());
            preparedStatement.setString(4, product.getName());
            preparedStatement.setInt(5, product.getNumber());
            preparedStatement.setDouble(6, product.getPrice());
            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }


        @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
