package com.learn.spring.spring.selenium.repository;

import com.learn.spring.spring.selenium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByfirstNameAndLastName(String firstName , String lastName);
}
