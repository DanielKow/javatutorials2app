package me.daniel.app.warehouse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private long id;

    private String Code;
    private String Address;

}
