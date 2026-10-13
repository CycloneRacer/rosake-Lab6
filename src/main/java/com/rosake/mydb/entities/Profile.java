package com.rosake.mydb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="id")
    private Long id;

    @Column(nullable = true,name="bio")
    private String bio;

    @Column(nullable = true,name="phone_number")
    private String phone_number;

    @Column(nullable = true,name="date_of_birth")
    private Date date_of_birth;

    @Column(nullable = true,name="loyalty_points")
    private int loyalty_points;

    @JoinColumn(name = "id")
    @MapsId
    @OneToOne(fetch=FetchType.LAZY)
    private User user;
}

