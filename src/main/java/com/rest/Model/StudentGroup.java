package com.rest.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student_group")
@Getter
@Setter
@NoArgsConstructor
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_group_id")
    private long id;
    private String studentGroupName;

    public StudentGroup(String studentGroupName) {
        this.studentGroupName = studentGroupName;
    }
}
