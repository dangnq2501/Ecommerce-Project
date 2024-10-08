package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.dto.request.ProductRequest;
import com.example.ecommerce_backend.dto.request.UserCreationRequest;
import com.example.ecommerce_backend.dto.request.UserUpdateRequest;
import com.example.ecommerce_backend.dto.response.ProductResponse;
import com.example.ecommerce_backend.dto.response.UserResponse;
import com.example.ecommerce_backend.service.ProductService;
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

import java.util.*;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    private UserCreationRequest adminCreationRequest;
    private UserResponse userResponse;
    private Set<String> admin_roles = new HashSet<>();
    private ProductRequest productCreateRequest;
    private ProductRequest productUpdateRequest;
    private ProductResponse productResponse;
    private List<ProductResponse> productResponseList;

    @BeforeEach
    void initData(){
        admin_roles.add("ADMIN");
        adminCreationRequest = UserCreationRequest.builder()
                .username("admin")
                .password("password123")
                .email("admin@gmail.com")
                .phone("0912345876")
                .roles(admin_roles)
                .build();

        productCreateRequest = ProductRequest.builder()
                .name("T-Shirt")
                .price(19.99)
                .category("shirt")
                .description("black comfortable shirt")
                .pathId("xyz")
                .stockQuantity(10)
                .build();

        productUpdateRequest = ProductRequest.builder()
                .name("T-Shirt")
                .price(10.99)
                .category("shirt")
                .description("red comfortable shirt")
                .pathId("abc")
                .stockQuantity(22)
                .build();

        productResponse = ProductResponse.builder()
                .name("T-Shirt")
                .price(19.99)
                .category("shirt")
                .description("black comfortable shirt")
                .pathId("xyz")
                .stockQuantity(10)
                .build();
//        productResponseList.add(productResponse);
    }

    @Test
    @WithMockUser(username="admin")
    void createValidProduct() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(productCreateRequest);
        Mockito.when(productService.create(ArgumentMatchers.any())).thenReturn(productResponse);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/product")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.name").value("T-Shirt"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.price").value(19.99))
                .andExpect(MockMvcResultMatchers.jsonPath("result.stockQuantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("result.description").value("black comfortable shirt"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.pathId").value("xyz"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.category").value("shirt")
                );
    }

    @Test
    @WithMockUser(username="admin")
    void getAllProduct() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
//        UUID product_id = UUID.fromString("00000000-3838-3137-0000-000000000000");
        String content = objectMapper.writeValueAsString(productUpdateRequest);
        Mockito.when(productService.getAll()).thenReturn(productResponseList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/getAll")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000")
                );
    }

    @Test
    @WithMockUser(username="admin")
    void getProductById() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
//        UUID product_id = UUID.fromString("00000000-3838-3137-0000-000000000000");
        String content = objectMapper.writeValueAsString(productUpdateRequest);
        Mockito.when(productService.findById(ArgumentMatchers.any())).thenReturn(productResponse);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/getById/00000000-3838-3137-0000-000000000000")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000")
                );
    }

    @Test
    @WithMockUser(username="admin")
    void getProductByName() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(productUpdateRequest);
        Mockito.when(productService.findByName(ArgumentMatchers.any())).thenReturn(productResponseList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/getByName/brown leather jackets")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000")
                );
    }


}
