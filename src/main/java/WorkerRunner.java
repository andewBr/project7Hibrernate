import by.itacademy.hibernate.dao.DepartmentRepository;
import by.itacademy.hibernate.dao.WorkerRepository;
import by.itacademy.hibernate.entity.Department;
import by.itacademy.hibernate.entity.PersonalInfo;
import by.itacademy.hibernate.entity.Position;
import by.itacademy.hibernate.entity.Worker;
import by.itacademy.hibernate.service.DepartmentService;
import by.itacademy.hibernate.service.WorkerService;
import by.itacademy.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.lang.reflect.Proxy;

@Transactional
public class WorkerRunner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(),
                    new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));

            session.beginTransaction();

            Department department1 = Department.builder()
                    .name("yandex corp")
                    .location("omsk").build();

            Worker build1 = Worker.builder()
                    .position(Position.PM)
                    .personalInfo(PersonalInfo.builder()
                            .firstName("Andrew")
                            .LastName("Klankov")
                            .build())
                    .salary(100)
                    .department(department1)
                    .build();

            WorkerRepository workerRepository = new WorkerRepository(session);
            WorkerService workerService = new WorkerService(workerRepository);
            workerService.create(build1);

            session.getTransaction().commit();

        }
    }
}
