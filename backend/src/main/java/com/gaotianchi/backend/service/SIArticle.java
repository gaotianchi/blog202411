package com.gaotianchi.backend.service;

import com.gaotianchi.backend.Response.P;
import com.gaotianchi.backend.Response.info.ArticleInfo;

public interface SIArticle {
    ArticleInfo newArticle();
    void deleteArticle(Long id);
    void updateInfo(Long id, String title, String summary, String slug);
    void updateStatus(Long id, Boolean published);
    void updateBody(Long id, String body);
    String getBody(Long id);
    ArticleInfo getInfo(Long id);
    P<ArticleInfo> getPageInfo(Integer page);
}
