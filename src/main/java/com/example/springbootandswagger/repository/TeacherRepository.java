package com.example.springbootandswagger.repository;

import com.example.springbootandswagger.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select case when count(t)>0 then true else false end from Teacher t where t.email like :email")
    boolean existsByEmail(@Param(value = "email") String email);
}