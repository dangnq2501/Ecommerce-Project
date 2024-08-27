package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.dto.request.CartItemRequest;
import com.example.ecommerce_backend.dto.request.CartRequest;
import com.example.ecommerce_backend.dto.request.UserCreationRequest;
import com.example.ecommerce_backend.dto.request.UserUpdateRequest;
import com.example.ecommerce_backend.dto.response.CartResponse;
import com.example.ecommerce_backend.dto.response.UserResponse;
import com.example.ecommerce_backend.models.CartItem;
import com.example.ecommerce_backend.models.User;
import com.example.ecommerce_backend.repository.CartItemRepository;
import com.example.ecommerce_backend.repository.UserRepository;
import com.example.ecommerce_backend.service.CartService;
import com.example.ecommerce_backend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @MockBean
    private CartService cartService;
    private CartResponse cartResponse;
    private CartItemRequest cartItemRequest;
    private CartRequest cartRequest;
    private Set<String> user_roles = new HashSet<>();
    private UUID user_id;
    private UUID cart_id;
    @BeforeEach
    void initDatat(){
        user_id = UUID.fromString("0507c6b3-4acb-40fa-b95e-b59e4570a4a0");
        cart_id = UUID.fromString("0705c6b3-4acb-40fa-b95e-b59e4570a4a0");
        user_roles.add("USER");
        User user = User.builder()
                .id(user_id)
                .username("quydang")
                .password("password")
                .email("quydang@gmail.com")
                .build();
        userRepository.save(user);
        cartRequest = CartRequest.builder()
                .build();
        cartResponse = CartResponse.builder().build();
        cartItemRequest = CartItemRequest.builder()
                .color("red")
                .size("large")
                .build();

    }

    @Test
    @WithMockUser(username="quydang")
    void getCart() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(cartRequest);
        Mockito.when(cartService.getCart(user_id)).thenReturn(cartResponse);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/0507c6b3-4acb-40fa-b95e-b59e4570a4a0/cart")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000"));
    }

    @Test
    @WithMockUser(username="quydang")
    void addCartItem() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(cartRequest);
        Mockito.when(cartService.addCartItem(user_id, cartItemRequest)).thenReturn(cartResponse);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/0507c6b3-4acb-40fa-b95e-b59e4570a4a0/cart/add")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000"));
    }
}
