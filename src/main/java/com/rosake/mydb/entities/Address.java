package com.rosake.mydb.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="id")
    private Long id;

    @Column(nullable = false,name="street")
    private String street;

    @Column(nullable = false,name="city")
    private String city;

    @Column(nullable = false,name="zip")
    private String zip;

    @Column(nullable = false,name="state")
    private String state;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
}

