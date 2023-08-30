package Repository;

import Model.Departments;
import Model.Employees;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentsRepository implements DepartmentsDAO {

    private final Connection connection;

    public DepartmentsRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Departments> findAllDepartments() {
        List<Departments> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 departments.add( new Departments(
                         resultSet.getInt("Id"),
                         resultSet.getString("DepartmentName"),
                         resultSet.getString("Description"))
                 );

            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return departments;
    }

    public Departments findDepartmentById(int id) {
        String sql = "SELECT * FROM departments WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Departments department = new Departments();
                department.setId(resultSet.getInt("ID"));
                department.setDepartmentName(resultSet.getString("DepartmentName"));
                department.setDescription(resultSet.getString("Description"));
                return department;
            }
        } catch (SQLException e) {
            System.out.println("DEPARTMENT NOT FOUND");
        }
        return null;
    }

    public void createDepartment(Departments department) {
        String sql = "INSERT INTO departments (Id, DepartmentName, Description) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department.getDepartmentName());
            statement.setString(2, department.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DEPARTMENT NOT CREATED");
        }
    }

    public void updateDepartment(int id, Departments department) {
        String sql = "UPDATE departments SET DepartmentName = ?, Description = ? WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department.getDepartmentName());
            statement.setString(2, department.getDescription());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DEPARTMENT NOT UPDATED");
        }
    }

    public void deleteDepartment(int id) {
        String sql = "DELETE FROM departments WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DEPARTMENT NOT DELETED");
        }
    }
}
