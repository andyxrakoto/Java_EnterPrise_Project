package Repository;

import Model.Leaves;

import java.util.List;

public interface LeavesDAO {
    List<Leaves> getAllLeaves();
    Leaves getLeaveById(int id);
    void createLeave(Leaves leaves);
    void updateLeaves(int id, Leaves leave);
    void deleteLeave(int id);
}
