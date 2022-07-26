package com.example.advancejavaassignmentfetchandsave.order;

import com.example.advancejavaassignmentfetchandsave.order.data.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}


