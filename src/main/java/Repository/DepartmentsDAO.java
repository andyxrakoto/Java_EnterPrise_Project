package Repository;

import Model.Departments;
import Model.Employees;

import java.util.List;
public interface DepartmentsDAO {
    List<Departments> findAllDepartments();
    Departments  findDepartmentById(int id);
    void createDepartment (Departments departments);
    void updateDepartment (int id, Departments departments);
    void deleteDepartment (int id);
}
