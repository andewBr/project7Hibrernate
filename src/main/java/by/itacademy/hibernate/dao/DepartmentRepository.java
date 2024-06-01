package by.itacademy.hibernate.dao;

import by.itacademy.hibernate.entity.Department;

import javax.persistence.EntityManager;

public class DepartmentRepository extends BaseRepository<Long, Department> {
    public DepartmentRepository(EntityManager entityManager) {
        super(Department.class, entityManager);
    }
}
