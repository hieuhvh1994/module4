package com.repo;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    @Query(value = "select * from blogs order by category_id asc, date asc", nativeQuery = true)
    Page<Blog> findAllOrderByCategoryAndDate(Pageable pageable);
}
