package com.javaCourse.crud.repository;

import com.javaCourse.crud.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {
}
