package com.rest.Repository;

import com.rest.Model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    StudentGroup findByStudentGroupName(String name);
}
