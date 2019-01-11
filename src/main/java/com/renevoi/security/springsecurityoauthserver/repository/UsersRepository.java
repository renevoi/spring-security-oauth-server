package com.renevoi.security.springsecurityoauthserver.repository;

import com.renevoi.security.springsecurityoauthserver.model.Users;
import org.bouncycastle.util.Integers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
