package com.learn.spring.spring.selenium.dataJPA;

import com.learn.spring.spring.selenium.SpringBaseTestNGTest;
import com.learn.spring.spring.selenium.entity.User;
import com.learn.spring.spring.selenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;

import java.util.List;

@TestPropertySource("classpath:application.properties")
public class Test1 extends SpringBaseTestNGTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void queryDB(){
        System.out.println(userRepository.findAll().size());
        userRepository.findById(1).ifPresent(s -> System.out.println(s.getEmail()));

        List<User> user1 = userRepository.findByfirstNameAndLastName("Kraig","Wiza");
        for(User u:user1){
            System.out.println(u.getFromCountry());
        }
    }
}
