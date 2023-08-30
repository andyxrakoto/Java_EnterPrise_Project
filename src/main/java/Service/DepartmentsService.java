package Service;

import Model.Departments;
import Repository.DepartmentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Departments> findAllDepartments() {
        return departmentsRepository.findAllDepartments();
    }

    public Departments findDepartmentById(int id) {
        return departmentsRepository.findDepartmentById(id);
    }

    public void createDepartment(Departments department) {
        departmentsRepository.createDepartment(department);
    }

    public void updateDepartment(int id, Departments departments) {
        departmentsRepository.updateDepartment(id, departments);
    }

    public void deleteDepartment(int id) {
        departmentsRepository.deleteDepartment(id);
    }
}

