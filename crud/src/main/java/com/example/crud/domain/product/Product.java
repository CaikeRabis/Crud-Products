package com.example.crud.domain.product;

import com.example.crud.RequestDTO.RequestProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
@Table(name = "product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private int price_in_cents;

    private boolean active;

    public Product (RequestProductDTO requestProductDTO) {
        this.name = requestProductDTO.name();
        this.price_in_cents = requestProductDTO.price_in_cents();
        this.active = true;
    }
}
