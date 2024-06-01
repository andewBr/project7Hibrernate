package by.itacademy.hibernate.service;

import by.itacademy.hibernate.dao.WorkerRepository;
import by.itacademy.hibernate.entity.Worker;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;
//    private final WorkerMapper workerMapper;

    public Long create(Worker worker) {
//        Worker worker = workerMapper.mapTo(workerCreateDTO);
        return workerRepository.save(worker).getId();
    }

    public boolean delete(Long id) {
        Optional<Worker> maybeWorker = workerRepository.findById(id);
        maybeWorker.ifPresent(worker -> workerRepository.delete(id));
        return maybeWorker.isPresent();
    }

    public Optional<Worker> findById(Long id) {
        return workerRepository.findById(id);
    }

}
