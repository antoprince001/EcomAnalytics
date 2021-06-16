package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderReceived;

@Repository
@Qualifier(value="orderReceivedRespository")
public interface OrderReceivedRepository extends JpaRepository<OrderReceived,Long>{

}
