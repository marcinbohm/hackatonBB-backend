package com.hackatonbb.service;

import com.hackatonbb.entity.Session;
import com.hackatonbb.security.domain.AuthSession;
import com.hackatonbb.security.domain.RefreshToken;

public interface AuthService {

    AuthSession login(String userName, String password);

    AuthSession refreshToken(RefreshToken refreshToken);

    void logout();
}
