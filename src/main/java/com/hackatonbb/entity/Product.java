package com.hackatonbb.entity;

import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@EntityListeners(AuditListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name="product_generator", sequenceName = "product_product_id_seq", allocationSize=1)
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Column(name = "product_power_kwp")
    private Double productPowerKWP;

    @NotNull
    @Column(name = "product_price")
    private BigDecimal productPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getProductPowerKWP() {
        return productPowerKWP;
    }

    public void setProductPowerKWP(Double productPowerKWP) {
        this.productPowerKWP = productPowerKWP;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
