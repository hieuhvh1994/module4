package com.service;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllOrderByCategoryAndDate(Pageable pageable);
}
