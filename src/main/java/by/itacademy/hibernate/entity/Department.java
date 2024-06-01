package by.itacademy.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"workers"})
@Table(name = "department", schema = "worker")
public class Department implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String location;
    @Email
    private String email;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Worker> workers;

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
        workers.forEach(worker -> worker.setDepartment(this));
    }
}
