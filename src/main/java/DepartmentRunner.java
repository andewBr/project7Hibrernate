import by.itacademy.hibernate.dao.DepartmentRepository;
import by.itacademy.hibernate.entity.Department;
import by.itacademy.hibernate.service.DepartmentService;
import by.itacademy.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.lang.reflect.Proxy;

@Transactional
public class DepartmentRunner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(),
                    new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));

            session.beginTransaction();

            Department department1 = Department.builder()
                    .name("personal cabinet")
                    .location("moscow").build();

            DepartmentRepository departmentRepository = new DepartmentRepository(session);
            DepartmentService departmentService = new DepartmentService(departmentRepository);
            departmentService.create(department1);

            session.getTransaction().commit();

        }
    }
}
