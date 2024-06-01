//package by.itacademy.hibernate.mapper;
//
//import by.itacademy.hibernate.dto.DepartmentDTO;
//import by.itacademy.hibernate.entity.Department;
//
//public class DepartmentMapper implements Mapper<Department, DepartmentDTO> {
//    @Override
//    public DepartmentDTO mapFrom(Department department) {
//        return new DepartmentDTO(department.getId(),
//                department.getName(),
//                department.getLocation());
//    }
//
//    @Override
//    public Department mapTo(DepartmentDTO departmentDTO) {
//        return Department.builder()
//                .id(departmentDTO.id())
//                .name(departmentDTO.name())
//                .location(departmentDTO.location())
//                .build();
//    }
//}
