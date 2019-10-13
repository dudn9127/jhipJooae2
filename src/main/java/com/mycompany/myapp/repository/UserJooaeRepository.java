package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.UserJooae;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.time.Instant;

/**
 * Spring Data JPA repository for the {@link UserJooae} entity.
 */
@Repository
public interface UserJooaeRepository extends JpaRepository<UserJooae, Long> {

    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<UserJooae> findOneByActivationKey(String activationKey);

    List<UserJooae> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

    Optional<UserJooae> findOneByResetKey(String resetKey);

    Optional<UserJooae> findOneByEmailIgnoreCase(String email);

    Optional<UserJooae> findOneByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    Optional<UserJooae> findOneWithAuthoritiesById(Long id);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<UserJooae> findOneWithAuthoritiesByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<UserJooae> findOneWithAuthoritiesByEmailIgnoreCase(String email);

    Page<UserJooae> findAllByLoginNot(Pageable pageable, String login);
}
