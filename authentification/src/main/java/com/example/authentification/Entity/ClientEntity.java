package com.example.authentification.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String adresse;
}
