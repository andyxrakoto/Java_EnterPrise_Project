package Controller;

package Controller;

import Model.Leaves;
import Repository.LeavesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeavesController {
    private final LeavesRepository leavesRepository;

    public LeavesController(LeavesRepository leavesRepository) {
        this.leavesRepository = leavesRepository;
    }

    @GetMapping
    public List<Leaves> getAllLeaves() {
        return leavesRepository.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leaves getLeaveById(@PathVariable int id) {
        return leavesRepository.getLeaveById(id);
    }

    @PostMapping
    public void createLeave(@RequestBody Leaves leave) {
        leavesRepository.createLeave(leave);
    }

    @PutMapping("/{id}")
    public void updateLeave(@PathVariable int id, @RequestBody Leaves leave) {
        leavesRepository.updateLeaves(id, leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable int id) {
        leavesRepository.deleteLeave(id);
    }
}

