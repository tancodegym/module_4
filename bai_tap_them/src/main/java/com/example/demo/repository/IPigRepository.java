package com.example.demo.repository;

import com.example.demo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPigRepository  extends JpaRepository<Pig,Long> {


    @Query(value="Select * From pig where status like :status and pig_code like :pigCode AND country_id Like :country ", nativeQuery=true)
    Page<Pig> search(Pageable pageable, @Param("status") String status,@Param("pigCode") String pigCode,@Param("country") String country);
}
