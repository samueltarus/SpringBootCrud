package com.demo2.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private  int rate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private  Post post;

}
