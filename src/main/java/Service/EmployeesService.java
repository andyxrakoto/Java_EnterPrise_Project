package Service;

import Model.Employees;
import Repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getAllEmployees(){
        return employeesRepository.findAllEmployees();
    }

    public Employees getEmployeeById(int id) {
        return employeesRepository.findEmployeesById(id);
    }

    public void createEmployee(Employees employee) {
        employeesRepository.createEmployee(employee);
    }

    public void updateEmployee(int id, Employees employee) {
        employeesRepository.updateEmployee(id, employee);
    }

    public void deleteEmployee(int id) {
        employeesRepository.deleteEmployee(id);
    }
}


