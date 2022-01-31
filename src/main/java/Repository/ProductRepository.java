package Repository;

import Entity.Admin;
import Entity.Category;
import Entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            String update = "UPDATE product SET numberProduct = numberProduct + ? , price = ? WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1,product.getNumber());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            String delete = "DELETE FROM product WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public List<Product> showAdminProduct(int id){
        try {
            String findAll = "SELECT * FROM Product WHERE adminId = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);
            preparedStatement.setInt(1,id);
            List<Product> productList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setCategoryId(resultSet.getInt("categoryId"));
                    product.setBrandId(resultSet.getInt("brandId"));
                    product.setName(resultSet.getString("nameProduct"));
                    product.setNumber(resultSet.getInt("numberProduct"));
                    product.setPrice(resultSet.getDouble("price"));
                    productList.add(product);
                }
                return productList;
            } else
                return null;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }



}
