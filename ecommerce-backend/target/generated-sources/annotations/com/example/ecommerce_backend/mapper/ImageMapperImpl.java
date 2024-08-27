package com.example.ecommerce_backend.mapper;

import com.example.ecommerce_backend.dto.request.ImageRequest;
import com.example.ecommerce_backend.dto.response.ImageResponse;
import com.example.ecommerce_backend.models.Image;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image toImage(ImageRequest imageRequest) {
        if ( imageRequest == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.id( imageRequest.getId() );
        image.pathId( imageRequest.getPathId() );
        image.pathImage( imageRequest.getPathImage() );

        return image.build();
    }

    @Override
    public ImageResponse toImageResponse(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageResponse.ImageResponseBuilder imageResponse = ImageResponse.builder();

        imageResponse.id( image.getId() );
        imageResponse.pathId( image.getPathId() );
        imageResponse.pathImage( image.getPathImage() );

        return imageResponse.build();
    }
}
