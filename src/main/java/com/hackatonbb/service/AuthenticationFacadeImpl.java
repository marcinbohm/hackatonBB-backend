package com.hackatonbb.service;

import com.hackatonbb.entity.Company;
import com.hackatonbb.security.domain.CurrentUser;
import com.hackatonbb.security.exception.NotLoggedInException;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Primary
@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private static <T extends UserDetails> Optional<T> getUserDetails(Class<T> clazz) {
        return
                Optional.of(SecurityContextHolder.getContext())
                        .map(SecurityContext::getAuthentication)
                        .map(Authentication::getPrincipal)
                        .filter(principal -> clazz.isAssignableFrom(principal.getClass()))
                        .map(principal -> (T) principal);
    }

    @Override
    public boolean isCurrentUserAuthenticated() {
        return getUserDetails(CurrentUser.class).isPresent();
    }


    @Override
    public CurrentUser getCurrentUser() {
        return getUserDetails(CurrentUser.class)
                .orElseThrow(NotLoggedInException::new);
    }
}
