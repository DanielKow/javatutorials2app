package me.daniel.app.warehouse;

import jakarta.persistence.Entity;

@Entity
public class ProductOnWarehouse {
    private long productId;
    private long warehouseId;
    private float quantity;
}
