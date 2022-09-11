package com.hackatonbb.resource.user;

import com.hackatonbb.entity.User;
import io.micrometer.core.instrument.config.MeterFilter;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Integer userId);

    Optional<User> findUserByLogin(String username);

    Optional<User> findUserByIdAndRefreshTicket(Integer userId, String refreshToken);
}
