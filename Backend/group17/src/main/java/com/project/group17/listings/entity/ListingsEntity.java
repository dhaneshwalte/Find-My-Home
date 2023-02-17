package com.project.group17.listings.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listings")
public class ListingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listingId;
}
