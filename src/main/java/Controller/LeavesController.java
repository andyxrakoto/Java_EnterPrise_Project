package Controller;


import Model.Leaves;
import Service.LeavesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/leaves")
@RestController
public class LeavesController {
    private final LeavesService leavesService;

    public LeavesController(LeavesService leavesService) {
        this.leavesService = leavesService;
    }

    @GetMapping("/allleaves")
    public List<Leaves> getAllLeaves() {
        return leavesService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leaves getLeaveById(@PathVariable int id) {
        return leavesService.getLeaveById(id);
    }

    @PostMapping
    public void createLeave(@RequestBody Leaves leave) {
        leavesService.createLeave(leave);
    }

    @PutMapping("/{id}")
    public void updateLeave(@PathVariable int id, @RequestBody Leaves leave) {
        leavesService.updateLeaves(id, leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable int id) {
        leavesService.deleteLeave(id);
    }
}

