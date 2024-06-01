package by.itacademy.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workers", schema = "worker")
public class Worker implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Position position;
    private PersonalInfo personalInfo;
    @NotNull
    private Integer salary;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Department department;

    void setDepartment(Department department) {
        department = department;
        department.getWorkers().add(this);
    }
}