package org.sid.customerthymleaf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

}
