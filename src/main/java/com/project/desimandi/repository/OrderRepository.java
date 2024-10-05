package com.project.desimandi.repository;

import com.project.desimandi.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    List<Order> findByUserMobileNumber(String mobileNumber);
}
