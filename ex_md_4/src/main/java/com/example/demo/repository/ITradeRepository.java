package com.example.demo.repository;

import com.example.demo.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ITradeRepository extends JpaRepository<Trade,Long> {
    @Query(value="Select * from trade join customer on customer.id = trade.customer_id where customer.customer_name like :customerName and `type` like :type   ",nativeQuery=true)
    Page<Trade> searchAll(Pageable pageable, @Param("customerName")String customerName, @Param("type") String type);
}
