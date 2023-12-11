package org.boots.mtex.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wheels")
public class Wheels {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "size")
    private String size;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Wheel size: " + size;
    }
}
