package com.polovnev.location.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Builder
@Table(name = "location")
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    public Location() {}

}
