package by.itacademy.hibernate.service;

import by.itacademy.hibernate.dao.DepartmentRepository;
import by.itacademy.hibernate.entity.Department;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
//    private final DepartmentMapper departmentMapper;

    public long create(Department department) {
//        Department department = departmentMapper.mapTo(departmentDTO);
        return departmentRepository.save(department).getId();
    }

    public boolean delete(Long id) {
        Optional<Department> maybePresent = departmentRepository.findById(id);
        maybePresent.ifPresent(department -> departmentRepository.delete(id));
        return maybePresent.isPresent();
    }

    public Optional<Department> findById(Long id){
        return departmentRepository.findById(id);
    }
}