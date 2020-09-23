package com.book.springboot.domain.room;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int professor_id;

    @Builder
    public Room(String title, String description, int professor_id){
        this.title = title;
        this.description = description;
        this.professor_id = professor_id;
    }

    public void update(String title, String description){
        this.title=  title;
        this.description = description;
    }
}