package Controller;
package Controller;

import Model.Employees;
import Repository.EmployeesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("/all")
    public List<Employees> getAllEmployees(){
        return employeesRepository.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employees getEmployeeById(@PathVariable int id) {
        return employeesRepository.getEmployeeById(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody Employees employee) {
        employeesRepository.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employees employee) {
        employeesRepository.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeesRepository.deleteEmployee(id);
    }
}

