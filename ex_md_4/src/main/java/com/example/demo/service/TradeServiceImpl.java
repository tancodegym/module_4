package com.example.demo.service;

import com.example.demo.model.Trade;
import com.example.demo.repository.ITradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class TradeServiceImpl implements ITradeService{
    @Autowired
    ITradeRepository iTradeRepository;


    @Override
    public Page<Trade> searchAll(Pageable pageable, String customerName, String type) {
        return iTradeRepository.searchAll(pageable,"%"+customerName+"%","%"+type+"%");
    }

    @Override
    public Trade findById(Long id) {
        return iTradeRepository.findById(id).get();
    }

    @Override
    public void save(Trade trade) {
    iTradeRepository.save(trade);
    }

    @Override
    public void delete(Long id) {
        iTradeRepository.delete(findById(id));
    }

    @Override
    public List<Trade> findAll() {
        return iTradeRepository.findAll();
    }


}
