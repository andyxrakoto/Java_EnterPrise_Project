package Controller;

import Model.Departments;
import Service.DepartmentsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
    public class DepartmentsController {
        private final DepartmentsService departmentsService;
        public DepartmentsController(DepartmentsService departmentsService) {
            this.departmentsService = departmentsService;
        }
        @GetMapping
        public List<Departments> getAllDepartments() {
            return departmentsService.findAllDepartments();
        }

        @GetMapping("/{id}")
        public Departments getDepartmentById(@PathVariable int id) {
            return departmentsService.findDepartmentById(id);
        }
        @PostMapping
        public void createDepartment(@RequestBody Departments department) {
            departmentsService.createDepartment(department);
        }

        @PutMapping("/{id}")
        public void updateDepartment(@PathVariable int id, @RequestBody Departments department) {
            departmentsService.updateDepartment(id, department);
        }

        @DeleteMapping("/{id}")
        public void deleteDepartment(@PathVariable int id) {
            departmentsService.deleteDepartment(id);
        }
    }
