package com.gaotianchi.backend.Response.info;

import com.gaotianchi.backend.presistence.entity.EArticle;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class ArticleInfo {
    private Long id;
    private String title;
    private String summary;
    private String slug;
    private Boolean published;
    private OffsetDateTime creationDatetime;
    private OffsetDateTime updateDatetime;

    private String body;
    private String authorUrl;

    public ArticleInfo(EArticle eArticle) {
        id = eArticle.getId();
        title = eArticle.getTitle();
        summary = eArticle.getSummary();
        slug = eArticle.getSlug();
        published = eArticle.getPublished();
        creationDatetime = eArticle.getCreationDatetime();
        updateDatetime = eArticle.getUpdateDatetime();

        body = "http://localhost:8080/articles/body/" + eArticle.getId();
        authorUrl = "http://localhost:8080/users/info";
    }
}
