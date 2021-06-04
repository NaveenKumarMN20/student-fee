package dev.mnnk.studentfee.repository;

import dev.mnnk.studentfee.entity.StudentFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentFeeRepository extends CrudRepository<StudentFee, Integer> {

    Optional<StudentFee> findByStudentId(Integer id);

}