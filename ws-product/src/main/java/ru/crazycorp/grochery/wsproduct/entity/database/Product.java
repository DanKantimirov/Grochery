package ru.crazycorp.grochery.wsproduct.entity.database;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer ProductId;

    @NotBlank
    @Size(min = 1, max = 300)
    @Column(name = "product_name")
    private String ProductName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ProductId, product.ProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId);
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
