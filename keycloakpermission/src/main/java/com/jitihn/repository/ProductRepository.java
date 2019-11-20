package com.jitihn.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.jitihn.model.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    public Product findByPid(String pid) {
        return Product.find("pid", pid).firstResult();
    }

    @Transactional
    public void save(Product product) {
        product.setPid(UUID.randomUUID().toString());
        product.persist();
    }
}