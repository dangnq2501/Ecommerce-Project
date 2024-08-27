package com.example.ecommerce_backend.mapper;

import com.example.ecommerce_backend.dto.request.OrderRequest;
import com.example.ecommerce_backend.dto.response.OrderResponse;
import com.example.ecommerce_backend.models.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( orderRequest.getId() );
        order.address( orderRequest.getAddress() );
        order.paid( orderRequest.isPaid() );
        order.status( orderRequest.getStatus() );
        order.username( orderRequest.getUsername() );
        order.shipping_cost( orderRequest.getShipping_cost() );
        order.total_cost( orderRequest.getTotal_cost() );

        return order.build();
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();

        orderResponse.id( order.getId() );
        orderResponse.create_at( order.getCreate_at() );
        orderResponse.username( order.getUsername() );
        orderResponse.paid( order.isPaid() );
        orderResponse.status( order.getStatus() );
        orderResponse.address( order.getAddress() );
        orderResponse.total_cost( order.getTotal_cost() );
        orderResponse.shipping_cost( order.getShipping_cost() );

        return orderResponse.build();
    }
}
