package com.example.ecommerce_backend.mapper;

import com.example.ecommerce_backend.dto.request.CartItemRequest;
import com.example.ecommerce_backend.dto.response.CartItemResponse;
import com.example.ecommerce_backend.models.CartItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItem toCartItem(CartItemRequest cartItemRequest) {
        if ( cartItemRequest == null ) {
            return null;
        }

        CartItem.CartItemBuilder cartItem = CartItem.builder();

        cartItem.id( cartItemRequest.getId() );
        cartItem.price( cartItemRequest.getPrice() );
        cartItem.color( cartItemRequest.getColor() );
        cartItem.size( cartItemRequest.getSize() );
        cartItem.quantity( cartItemRequest.getQuantity() );
        cartItem.product_id( cartItemRequest.getProduct_id() );
        cartItem.rating( cartItemRequest.getRating() );

        return cartItem.build();
    }

    @Override
    public CartItemResponse toCartItemResponse(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemResponse.CartItemResponseBuilder cartItemResponse = CartItemResponse.builder();

        cartItemResponse.id( cartItem.getId() );
        cartItemResponse.product_id( cartItem.getProduct_id() );
        cartItemResponse.quantity( cartItem.getQuantity() );
        cartItemResponse.price( cartItem.getPrice() );
        cartItemResponse.rating( cartItem.getRating() );
        cartItemResponse.size( cartItem.getSize() );
        cartItemResponse.color( cartItem.getColor() );

        return cartItemResponse.build();
    }
}
