package com.rest.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "student_group_id")
    private StudentGroup studentGroup;
    @Column(name = "rating_score")
    private int ratingScore;

    public Student(
            String firstName,
            String lastName,
            Address address,
            StudentGroup studentGroup,
            int averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.studentGroup = studentGroup;
        this.ratingScore = averageScore;
    }

}
