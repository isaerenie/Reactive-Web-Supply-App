package com.tzy.tedarik.controller.product;

import com.tzy.tedarik.dto.ProductDto;
import com.tzy.tedarik.dto.ProductDtoUpdate;
import com.tzy.tedarik.model.products.product.Product;
import com.tzy.tedarik.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public record ProductController(ProductService productService) {
    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping
    public Product update(@RequestBody ProductDtoUpdate productDtoUpdate) {
        System.out.println(2);
        return productService.update(productDtoUpdate);
    }
    @DeleteMapping
    public Boolean delete(@RequestParam Integer id) {
        return productService.delete(id);
    }
}
