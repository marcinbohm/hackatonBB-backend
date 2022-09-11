package com.hackatonbb.graphql.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.User;
import com.hackatonbb.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public UserQueryResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('USER_READ_PRIVILEGE')")
    public User getUser(@NotNull Integer userId) {
        return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }
}
