package com.gaotianchi.backend.presistence.repositity;

import com.gaotianchi.backend.presistence.entity.EArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RArticle extends JpaRepository<EArticle, Long> {
    Page<EArticle> findEArticleByOrderByCreationDatetimeDesc(Pageable pageable);
}
