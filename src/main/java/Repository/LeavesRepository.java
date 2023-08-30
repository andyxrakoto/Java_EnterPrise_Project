package Repository;

import Model.Leaves;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeavesRepository implements LeavesDAO {
    private final Connection connection;

    public LeavesRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Leaves> getAllLeaves() {
        List<Leaves> leaves = new ArrayList<>();
        String sql = "SELECT * FROM leaves";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Leaves leave = new Leaves();
                leave.setId(resultSet.getInt("ID"));
                leave.setEmployeeId(resultSet.getInt("EmployeeID"));
                leave.setStartDate(resultSet.getDate("StartDate"));
                leave.setEndDate(resultSet.getDate("EndDate"));
                leave.setLeaveReason(resultSet.getString("LeaveReason"));
                leave.setLeaveStatus(resultSet.getString("LeaveStatus"));
                leaves.add(leave);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return leaves;
    }

    public Leaves getLeaveById(int id) {
        String sql = "SELECT * FROM leaves WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Leaves leave = new Leaves();
                leave.setId(resultSet.getInt("ID"));
                leave.setEmployeeId(resultSet.getInt("EmployeeID"));
                leave.setStartDate(resultSet.getDate("StartDate"));
                leave.setEndDate(resultSet.getDate("EndDate"));
                return leave;
            }
        } catch (SQLException e) {
            System.out.println("LEAVES NOT FOUND");
        }
        return null;
    }

    public void createLeave(Leaves leave) {
        String sql = "INSERT INTO leaves (id,employeeID, startDate, endDate) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, leave.getId());
            statement.setInt(2, leave.getEmployeeId());
            statement.setDate(3, (Date) leave.getStartDate());
            statement.setDate(4, (Date) leave.getEndDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LEAVES NOT CREATED");
        }
    }

    public void updateLeaves(int id, Leaves leave) {
        String sql = "UPDATE leaves SET EmployeeID = ?, StartDate = ?, EndDate = ? WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, leave.getEmployeeId());
            statement.setDate(2, (Date) leave.getStartDate());
            statement.setDate(3, (Date) leave.getEndDate());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LEAVES NOT UPDATED");
        }
    }

    public void deleteLeave(int id) {
        String sql = "DELETE FROM leaves WHERE ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LEAVES NOT DELETED");
        }
    }
}

