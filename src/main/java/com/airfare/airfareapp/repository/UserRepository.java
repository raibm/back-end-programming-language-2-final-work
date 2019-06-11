package com.airfare.airfareapp.repository;

import com.airfare.airfareapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findById(int id);

}
