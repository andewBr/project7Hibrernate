package by.itacademy.hibernate.dao;

import by.itacademy.hibernate.entity.Worker;

import javax.persistence.EntityManager;

public class WorkerRepository extends BaseRepository<Long, Worker>  {

    public WorkerRepository( EntityManager entityManager) {
        super(Worker.class, entityManager);
    }
}
