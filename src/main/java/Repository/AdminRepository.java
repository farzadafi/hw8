package Repository;

import Entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminRepository implements Repository<Admin> {
    private Connection connection;

    public AdminRepository() {
        try {
            this.connection = Singleton.getInstance().getConnection();
            String CreateTable = "CREATE TABLE IF NOT EXISTS UserTable(id serial PRIMARY KEY," +
                    "fullName varchar(50)," +
                    "nationalId varchar(20)," +
                    "password varchar(50)," +
                    "kind varchar(50)," +
                    "address varchar(100)," +
                    "budget DECIMAL)";
            PreparedStatement preparedStatement = connection.prepareStatement(CreateTable);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int add(Admin admin) {
        try {
            String add = "INSERT INTO UserTable(fullName,nationalId,password,kind,address,budget) VALUES (?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setString(1, admin.getFullName());
            preparedStatement.setString(2, admin.getNationalId());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setString(4, String.valueOf(admin.getTypeUser()));
            preparedStatement.setString(5, null);
            preparedStatement.setDouble(6, 0);
            return preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
