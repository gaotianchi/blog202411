package com.gaotianchi.backend.service;

import com.gaotianchi.backend.Response.P;
import com.gaotianchi.backend.Response.info.ArticleInfo;
import com.gaotianchi.backend.presistence.entity.EArticle;
import com.gaotianchi.backend.presistence.entity.EUser;
import com.gaotianchi.backend.presistence.repositity.RArticle;
import com.gaotianchi.backend.presistence.repositity.RUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class SArticle implements SIArticle{
    private final RUser rUser;
    private final RArticle rArticle;

    public SArticle(RUser rUser, RArticle rArticle) {
        this.rUser = rUser;
        this.rArticle = rArticle;
    }

    @Override
    public ArticleInfo newArticle() {
        EArticle eArticle = new EArticle();
        EUser eUser = rUser.findFirstBy();
        eArticle.setAuthor(eUser);
        eArticle.setCreationDatetime(OffsetDateTime.now());
        eArticle.setUpdateDatetime(OffsetDateTime.now());
        eArticle.setPublished(false);
        eArticle = rArticle.save(eArticle);
        eArticle.setSlug("blog_" + eArticle.getId());
        eArticle = rArticle.save(eArticle);
        return new ArticleInfo(eArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        eArticle.ifPresent(rArticle::delete);
    }

    @Override
    public void updateInfo(Long id, String title, String summary, String slug) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        if (eArticle.isEmpty()) throw new EntityNotFoundException();
        eArticle.get().setTitle(title);
        eArticle.get().setSlug(slug);
        eArticle.get().setSummary(summary);
        rArticle.save(eArticle.get());
    }

    @Override
    public void updateStatus(Long id, Boolean published) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        if (eArticle.isEmpty()) throw new EntityNotFoundException();
        eArticle.get().setPublished(published);
        rArticle.save(eArticle.get());
    }

    @Override
    public void updateBody(Long id, String body) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        if (eArticle.isEmpty()) throw new EntityNotFoundException();
        eArticle.get().setBody(body);
        rArticle.save(eArticle.get());
    }

    @Override
    public String getBody(Long id) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        if (eArticle.isEmpty()) throw new EntityNotFoundException();
        return eArticle.get().getBody();
    }

    @Override
    public ArticleInfo getInfo(Long id) {
        Optional<EArticle> eArticle = rArticle.findById(id);
        if (eArticle.isEmpty()) throw new EntityNotFoundException();
        return new ArticleInfo(eArticle.get());
    }

    @Override
    public P<ArticleInfo> getPageInfo(Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<EArticle> eArticlePage = rArticle.findEArticleByOrderByCreationDatetimeDesc(pageable);
        return _getArticleInfoPage(eArticlePage, page);
    }

    private P<ArticleInfo> _getArticleInfoPage(Page<EArticle> articleEntityPage, Integer page) {
        return new P<>(articleEntityPage.getContent().stream().map(ArticleInfo::new).toList(), page,  articleEntityPage.getTotalPages());
    }
}
