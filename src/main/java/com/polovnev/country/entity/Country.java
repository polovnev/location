package com.polovnev.country.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Country() {
    }
}
