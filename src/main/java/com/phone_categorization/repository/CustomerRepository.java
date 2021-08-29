package com.phone_categorization.repository;

import com.phone_categorization.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    public List<Customer> findAll();
}
