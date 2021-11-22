package com.codegym.exam.repository;

import com.codegym.exam.model.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassNameRepository extends JpaRepository<ClassName,Long> {
}
