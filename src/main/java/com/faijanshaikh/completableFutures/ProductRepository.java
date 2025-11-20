package main.java.com.faijanshaikh.completableFutures;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductRepository {
    private final ObjectMapper mapper;

    public ProductRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<ProductDTO> saveProducts(File jsonFile){
        try {
            return mapper.readValue(jsonFile, new TypeReference<List<ProductDTO>>(){});
        } catch (IOException e) {
            System.out.println("Exception While saving Product");
        }
        return List.of();
    }

    public List<ProductDTO> getProducts(File jsonFile) {
        try {
            return mapper.readValue(jsonFile, new TypeReference<List<ProductDTO>>() {
            });
        } catch (IOException ioException) {
            System.out.println("Exception Occurs while fetching Products");
        }
        return List.of();
    }
}
