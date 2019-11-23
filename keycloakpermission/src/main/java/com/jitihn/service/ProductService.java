package com.jitihn.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.jitihn.dto.ProductDTO;
import com.jitihn.model.Product;
import com.jitihn.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDTO> getProduct() {
        Stream<Product> products = Product.streamAll();
        List<ProductDTO> productDtos = products.map(p -> new ProductDTO(p))
                .sorted(Comparator.comparing(ProductDTO::getName)).collect(Collectors.toList());
        return productDtos;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(String pid) {
        productRepository.deleteByPid(pid);
    }
}