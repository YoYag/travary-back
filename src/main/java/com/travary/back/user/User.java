package com.travary.back.user;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String role;

    @CreationTimestamp
    private Timestamp createDate;
}
