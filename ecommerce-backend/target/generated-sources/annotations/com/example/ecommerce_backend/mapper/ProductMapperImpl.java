package com.example.ecommerce_backend.mapper;

import com.example.ecommerce_backend.dto.request.ProductRequest;
import com.example.ecommerce_backend.dto.response.ProductResponse;
import com.example.ecommerce_backend.models.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.rating( productRequest.getRating() );
        product.id( productRequest.getId() );
        product.name( productRequest.getName() );
        product.description( productRequest.getDescription() );
        product.category( productRequest.getCategory() );
        product.pathId( productRequest.getPathId() );
        product.price( productRequest.getPrice() );
        product.stockQuantity( productRequest.getStockQuantity() );

        return product.build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        productResponse.id( product.getId() );
        productResponse.name( product.getName() );
        productResponse.category( product.getCategory() );
        productResponse.description( product.getDescription() );
        productResponse.pathId( product.getPathId() );
        productResponse.price( product.getPrice() );
        productResponse.stockQuantity( product.getStockQuantity() );
        productResponse.rating( product.getRating() );

        return productResponse.build();
    }

    @Override
    public void updateItem(Product product, ProductRequest productRequest) {
        if ( productRequest == null ) {
            return;
        }

        if ( productRequest.getId() != null ) {
            product.setId( productRequest.getId() );
        }
        if ( productRequest.getName() != null ) {
            product.setName( productRequest.getName() );
        }
        if ( productRequest.getDescription() != null ) {
            product.setDescription( productRequest.getDescription() );
        }
        if ( productRequest.getCategory() != null ) {
            product.setCategory( productRequest.getCategory() );
        }
        if ( productRequest.getPathId() != null ) {
            product.setPathId( productRequest.getPathId() );
        }
        product.setPrice( productRequest.getPrice() );
        product.setStockQuantity( productRequest.getStockQuantity() );
        product.setRating( productRequest.getRating() );
    }
}
