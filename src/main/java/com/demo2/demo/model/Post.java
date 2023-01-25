package com.demo2.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "comments")
    private List<Comment> comments;


}
