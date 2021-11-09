package com.codegym.su_dung_restful.repository;

import com.codegym.su_dung_restful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,Long> {
}
