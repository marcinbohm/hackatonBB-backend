package com.hackatonbb.service;

import com.hackatonbb.entity.Company;
import com.hackatonbb.security.domain.CurrentUser;

public interface AuthenticationFacade {
    boolean isCurrentUserAuthenticated();

    CurrentUser getCurrentUser();
}
