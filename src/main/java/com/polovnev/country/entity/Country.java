package com.polovnev.country.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "country")
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="country")
    private Set<Location> locations;

    public Country() {}
}
