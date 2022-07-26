package com.example.advancejavaassignmentfetchandsave.order.data.entity.mapper;

import com.example.advancejavaassignmentfetchandsave.order.data.entity.OrderDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.advancejavaassignmentfetchandsave.common.utils.Utils.formatDecimal;

public class OrderDetailsRowMapper implements RowMapper<OrderDetails> {
    @Override
    public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetails orders = new OrderDetails();
        orders.setOrderId(rs.getLong("order_id"));
        orders.setInvoiceId(rs.getLong("invoice_id"));
        orders.setTransactionDate(rs.getString("transaction_date"));
        orders.setSkuId(rs.getLong("sku_id"));
        orders.setSkuName(rs.getString("sku_name"));
        orders.setRlp(rs.getDouble("rlp"));
        orders.setRlpVat(formatDecimal(rs.getDouble("rlp_vat")));
        orders.setQuantity(rs.getInt("quantity"));
        orders.setGrossAmount(formatDecimal(rs.getDouble("gross_amount")));
        orders.setUserId(rs.getLong("user_id"));
        orders.setFullName(rs.getString("full_name"));
        return orders;
    }
}
