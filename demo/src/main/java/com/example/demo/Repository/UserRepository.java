package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}