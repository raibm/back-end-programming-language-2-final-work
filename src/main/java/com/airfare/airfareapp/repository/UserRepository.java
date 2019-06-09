package com.airfare.airfareapp.repository;

import com.airfare.airfareapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
