package com.example.demo.repository;

import com.example.demo.model.Pig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigRepository extends JpaRepository<Pig,Long> {
}
