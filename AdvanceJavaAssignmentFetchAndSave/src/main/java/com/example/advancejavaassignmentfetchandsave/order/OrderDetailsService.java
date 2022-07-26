package com.example.advancejavaassignmentfetchandsave.order;

import com.example.advancejavaassignmentfetchandsave.order.data.entity.mapper.OrderDetailsRowMapper;
import com.example.advancejavaassignmentfetchandsave.order.data.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository repository;
    private final JdbcTemplate eshopTemplate;
    private final JdbcTemplate eshopOrdersTemplate;

    public OrderDetailsService(OrderDetailsRepository repository,
                               @Qualifier("eshopTemplate") JdbcTemplate eshopTemplate,
                               @Qualifier("eshopOrdersTemplate") JdbcTemplate eshopOrdersTemplate) {
        this.repository = repository;
        this.eshopTemplate = eshopTemplate;
        this.eshopOrdersTemplate = eshopOrdersTemplate;
    }

    List<OrderDetails> getOrderDetails() {
        String query = """
                select o.id as order_id,
                   o.invoice_id as invoice_id,
                   o.quantity as quantity,
                   o.gross_amount as gross_amount,
                   o.transaction_date as transaction_date,
                   s.id as sku_id,
                   s.name as sku_name,
                   s.rlp as rlp,
                   s.rlp_vat as rlp_vat,
                   u.id as user_id,    
                   u.full_name as full_name    
                   from orders o
                   inner join order_sku os on os.order_id = o.id 
                   inner join skus s on s.id=os.sku_id
                   inner join user_order uo on uo.order_id=o.id
                   inner join users u on u.id = uo.user_id 
                 """;
        List<OrderDetails> orders = eshopTemplate.query(query, new OrderDetailsRowMapper());
       return repository.saveAll(orders);
    }
}
