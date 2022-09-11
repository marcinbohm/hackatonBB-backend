package com.hackatonbb.resource.session;


import com.hackatonbb.entity.Session;

import java.util.Optional;

public interface SessionService {

    Optional<Session> findByToken(String token);

    Optional<Session> findByUserId(Integer userId);

    <S extends Session> S save(S session);

    void delete(Session session);
}
