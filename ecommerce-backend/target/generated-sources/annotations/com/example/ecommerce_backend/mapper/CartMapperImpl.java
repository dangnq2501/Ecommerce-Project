package com.example.ecommerce_backend.mapper;

import com.example.ecommerce_backend.dto.request.CartRequest;
import com.example.ecommerce_backend.dto.response.CartResponse;
import com.example.ecommerce_backend.models.Cart;
import com.example.ecommerce_backend.models.CartItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart toCart(CartRequest cartRequest) {
        if ( cartRequest == null ) {
            return null;
        }

        Cart.CartBuilder cart = Cart.builder();

        cart.cart_id( cartRequest.getCart_id() );
        cart.total_price( cartRequest.getTotal_price() );
        List<CartItem> list = cartRequest.getCartItems();
        if ( list != null ) {
            cart.cartItems( new ArrayList<CartItem>( list ) );
        }

        return cart.build();
    }

    @Override
    public CartResponse toCartResponse(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartResponse.CartResponseBuilder cartResponse = CartResponse.builder();

        cartResponse.cart_id( cart.getCart_id() );
        cartResponse.total_price( cart.getTotal_price() );
        List<CartItem> list = cart.getCartItems();
        if ( list != null ) {
            cartResponse.cartItems( new ArrayList<CartItem>( list ) );
        }

        return cartResponse.build();
    }

    @Override
    public void updateCart(Cart cart, CartRequest cartRequest) {
        if ( cartRequest == null ) {
            return;
        }

        if ( cartRequest.getCart_id() != null ) {
            cart.setCart_id( cartRequest.getCart_id() );
        }
        cart.setTotal_price( cartRequest.getTotal_price() );
        if ( cart.getCartItems() != null ) {
            List<CartItem> list = cartRequest.getCartItems();
            if ( list != null ) {
                cart.getCartItems().clear();
                cart.getCartItems().addAll( list );
            }
        }
        else {
            List<CartItem> list = cartRequest.getCartItems();
            if ( list != null ) {
                cart.setCartItems( new ArrayList<CartItem>( list ) );
            }
        }
    }
}
