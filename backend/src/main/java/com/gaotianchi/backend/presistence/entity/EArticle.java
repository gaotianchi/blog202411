package com.gaotianchi.backend.presistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class EArticle {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    @Column(columnDefinition = "TEXT")
    private String summary;
    private String slug;
    private Boolean published;
    private OffsetDateTime creationDatetime;
    private OffsetDateTime updateDatetime;

    @ManyToOne
    private EUser author;
}
