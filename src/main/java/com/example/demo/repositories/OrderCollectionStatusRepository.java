package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderCollectionStatus;


@Repository
@Qualifier(value="orderCollectionStatusRespository")
public interface OrderCollectionStatusRepository extends JpaRepository<OrderCollectionStatus,Long>{

	
	
}
