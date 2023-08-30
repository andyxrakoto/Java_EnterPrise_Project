package Repository;

import Model.Employees;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeesRepository implements EmployeesDAO {

    private final Connection connection;

    public EmployeesRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Employees> findAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employees";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employees employee = new Employees();
                employee.setId(resultSet.getInt("Id"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setFirstName(resultSet.getString("FirstName"));
                employee.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                employee.setEmailAddress(resultSet.getString("emailAddress"));
                employee.setHireDate(resultSet.getDate("HireDate"));
                employee.setJobTitle(resultSet.getString("JobTitle"));
                employee.setSalary(resultSet.getFloat("Salary"));
                employee.setDepartmentId(resultSet.getInt("DepartmentID"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("NO EMPLOYESS MY G!!");
        }
        return employees;
    }

    public Employees findEmployeesById(int id) {
        String sql = "SELECT * FROM Employees WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Employees employee = new Employees();
                employee.setId(resultSet.getInt("ID"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setFirstName(resultSet.getString("FirstName"));
                employee.setJobTitle(resultSet.getString("JobTitle"));
                return employee;
            }
        } catch (SQLException e) {
            System.out.println("EMPLOYEE NOT FOUND");
        }
        return null;
    }

    public void createEmployee(Employees employee) {
        String sql = "INSERT INTO Employees (Id, LastName, FirstName) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employee.getId());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getFirstName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("EMPLOYEE NOT ADDED");
        }
    }

    public void updateEmployee(int id, Employees employee) {
        String sql = "UPDATE Employees SET LastName = ?, FirstName = ? WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getFirstName());
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("EMPLOYEE NOT UPDATED");
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employees WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("EMPLOYEE NOT DELETED");
        }
    }
}
