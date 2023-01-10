package com.tzy.tedarik.service.product;

import com.tzy.tedarik.dto.ProductDto;
import com.tzy.tedarik.dto.ProductDtoUpdate;
import com.tzy.tedarik.model.products.product.Product;
import com.tzy.tedarik.repo.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record ProductService(ModelMapper mapper, ProductRepository productRepository) {

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public Product create(ProductDto productDto) {
        if (productRepository.existsProductNameBy(productDto.getProductName())) {
            throw new RuntimeException("Product name already exists");
        }
        return productRepository.save(mapper.map(productDto, Product.class));
    }

    public Product update(ProductDtoUpdate productDtoUpdate) {
        Product product = productRepository.getReferenceById(productDtoUpdate.getId());
        mapper.map(productDtoUpdate, product);
        return productRepository.save(product);
    }

    public Boolean delete(Integer id) {
        productRepository.deleteById(id);
        return true;
    }



}
