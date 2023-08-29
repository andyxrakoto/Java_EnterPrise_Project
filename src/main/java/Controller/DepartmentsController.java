package Controller;

import Model.Departments;
import Repository.DepartmentsRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentsController(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @GetMapping
    public List<Departments> getAllDepartments() {
        return departmentsRepository.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Departments getDepartmentById(@PathVariable int id) {
        return departmentsRepository.getDepartmentById(id);
    }

    @PostMapping
    public void createDepartment(@RequestBody Departments department) {
        departmentsRepository.createDepartment(department);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody Departments department) {
        departmentsRepository.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentsRepository.deleteDepartment(id);
    }
}
