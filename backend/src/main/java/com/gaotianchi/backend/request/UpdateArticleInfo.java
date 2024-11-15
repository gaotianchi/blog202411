package com.gaotianchi.backend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateArticleInfo {
    private String title;
    private String summary;
    private String slug;
}
