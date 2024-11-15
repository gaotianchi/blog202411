package com.gaotianchi.backend.controller;

import com.gaotianchi.backend.Response.P;
import com.gaotianchi.backend.Response.R;
import com.gaotianchi.backend.Response.info.ArticleInfo;
import com.gaotianchi.backend.request.UpdateArticleInfo;
import com.gaotianchi.backend.request.UpdateBody;
import com.gaotianchi.backend.service.SArticle;
import org.springframework.web.bind.annotation.*;

@RestController
public class CArticle {
    private final SArticle sArticle;

    public CArticle(SArticle sArticle) {
        this.sArticle = sArticle;
    }

    @PostMapping("/articles/new")
    public R<ArticleInfo> newArticle() {
        return R.success(sArticle.newArticle());
    }

    @DeleteMapping("/articles/delete/{id}")
    public R<Void> deleteArticle(@PathVariable Long id) {
        sArticle.deleteArticle(id);
        return R.success();
    }

    @PatchMapping("/articles/info/{id}")
    public R<Void> updateInfo(@PathVariable Long id, @RequestBody UpdateArticleInfo updateArticleInfo) {
        sArticle.updateInfo(id, updateArticleInfo.getTitle(), updateArticleInfo.getSummary(), updateArticleInfo.getSlug());
        return R.success();
    }

    @PatchMapping("/articles/status/{id}/{status}")
    public R<Void> updateStatus(@PathVariable short status, @PathVariable Long id) {
        Boolean published = status != 0;
        sArticle.updateStatus(id, published);
        return R.success();
    }

    @PatchMapping("/articles/body/{id}")
    public R<Void> updateBody(@PathVariable Long id, @RequestBody UpdateBody updateBody) {
        sArticle.updateBody(id, updateBody.getBody());
        return R.success();
    }

    @GetMapping("/articles/body/{id}")
    public R<String> getBody(@PathVariable Long id) {
        return R.success(sArticle.getBody(id));
    }

    @GetMapping("/articles/info/{id}")
    public R<ArticleInfo> getInfo(@PathVariable Long id) {
        return R.success(sArticle.getInfo(id));
    }

    @GetMapping("/articles/info-list/{page}")
    public R<P<ArticleInfo>> getInfoList(@PathVariable Integer page) {
        return R.success(sArticle.getPageInfo(page));
    }
}
