package Service;

import Model.Leaves;
import Repository.LeavesDAO;
import Repository.LeavesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavesService implements LeavesDAO {

    private final LeavesRepository leavesRepository;

    public LeavesService(LeavesRepository leavesRepository) {
        this.leavesRepository = leavesRepository;
    }
    public List<Leaves> getAllLeaves() {
        return leavesRepository.getAllLeaves();
    }
    public Leaves getLeaveById(int id) {
        return leavesRepository.getLeaveById(id);
    }
    public void createLeave(Leaves leave) {
        leavesRepository.createLeave(leave);
    }

    public void updateLeaves(int id, Leaves leave) {
        leavesRepository.updateLeaves(id, leave);
    }
    public void deleteLeave(int id) {
        leavesRepository.deleteLeave(id);
    }
}

