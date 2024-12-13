package com.lostandfoundsystem.LAFS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDetails {

    @Id
    @Column(name = "location_id", nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "country")
    private String country = "Sri Lanka";

    @OneToMany(mappedBy = "locationDetails",cascade = CascadeType.REMOVE)
    private Set<Item> item;






}
