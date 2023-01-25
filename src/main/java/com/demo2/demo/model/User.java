package com.demo2.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String  username;
    @Column(name = "id_number")
    private String idNumber;

    private String password;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "posts")
    private List<Post> posts;



}
