package Repository;

import Model.Employees;

import java.util.List;

public interface EmployeesDAO {
    List<Employees>  findAllEmployees();
    Employees  findEmployeesById(int id);
    void createEmployee (Employees employees);
    void updateEmployee (int id, Employees employees);
    void deleteEmployee (int id);
}
