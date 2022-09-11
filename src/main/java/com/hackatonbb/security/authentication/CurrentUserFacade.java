package com.hackatonbb.security.authentication;

import com.hackatonbb.entity.User;
import com.hackatonbb.security.domain.CurrentUser;

public interface CurrentUserFacade {

    CurrentUser convertToCurrentUser(User user);
}
