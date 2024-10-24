package com.example.nodes.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.TypeDef;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@TypeDef(name = "point", typeClass = Point.class)
public class Booking {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    private LocalDateTime startDate;
    private LocalDateTime  endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource")
    private Resource resource;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDateTime  startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime  getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDateTime  endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime  getEndDate() {
        return endDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}