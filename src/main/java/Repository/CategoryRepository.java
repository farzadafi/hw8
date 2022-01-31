package Repository;

import Entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository<Category> {
    private Connection connection;

    public CategoryRepository() {
        try {
            connection = Singleton.getInstance().getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS Category(parentId integer ,id serial PRIMARY KEY,nameCategory varchar(50)) ";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(Category category) {
        try {
            String add = "INSERT INTO Category(parentId,nameCategory) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1, category.getParentId());
            preparedStatement.setString(2, category.getName());
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public List<Category> findAll() {
        try {
            String findAll = "SELECT * FROM Category WHERE parentId = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);
            preparedStatement.setInt(1,0);
            List<Category> categoryList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("nameCategory"));
                    categoryList.add(category);
                }
                return categoryList;
            } else
                return null;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }


    public List<Category> showCategory(int number) {
        try {
            String findAll = "SELECT * FROM Category WHERE parentId = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(findAll);
            preparedStatement.setInt(1,number);
            List<Category> categoryList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("nameCategory"));
                    categoryList.add(category);
                }
                return categoryList;
            } else
                return null;
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
