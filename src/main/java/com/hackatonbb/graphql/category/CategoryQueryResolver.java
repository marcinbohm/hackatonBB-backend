package com.hackatonbb.graphql.category;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.Category;
import com.hackatonbb.repository.CategoryRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class CategoryQueryResolver implements GraphQLQueryResolver {

    private final CategoryRepository categoryRepository;

    public CategoryQueryResolver(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CATEGORY_READ_PRIVILEGE')")
    public Category getCategory(@NotNull Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(EntityNotFoundException::new);
    }
}
