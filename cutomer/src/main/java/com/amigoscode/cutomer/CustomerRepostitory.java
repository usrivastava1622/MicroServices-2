package com.amigoscode.cutomer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepostitory  extends JpaRepository<Customer,Integer>{
    
}
