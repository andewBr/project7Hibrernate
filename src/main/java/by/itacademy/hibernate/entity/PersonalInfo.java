package by.itacademy.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    private String email;
}
