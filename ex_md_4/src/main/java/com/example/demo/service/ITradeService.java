package com.example.demo.service;

import com.example.demo.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITradeService {

    Page<Trade> searchAll(Pageable pageable,String customerName, String type);
    Trade findById(Long id);

    void save(Trade trade);

    void delete(Long id);

    List<Trade> findAll();
}
