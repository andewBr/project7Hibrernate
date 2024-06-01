//package by.itacademy.hibernate.mapper;
//
//import by.itacademy.hibernate.dto.WorkerCreateDTO;
//import by.itacademy.hibernate.entity.Worker;
//
//public class WorkerMapper implements Mapper<Worker, WorkerCreateDTO> {
//    @Override
//    public WorkerCreateDTO mapFrom(Worker worker) {
//        return new WorkerCreateDTO(
//                worker.getId(),
//                worker.getPersonalInfo(),
//                worker.getPosition(),
//                worker.getSalary()
//                );
//    }
//
//    @Override
//    public Worker mapTo(WorkerCreateDTO workerCreateDTO) {
//        return Worker.builder()
//                .id(workerCreateDTO.id())
//                .personalInfo(workerCreateDTO.personalInfo())
//                .position(workerCreateDTO.position())
//                .salary(workerCreateDTO.salary())
//                .build();
//    }
//
//}
