package com.yathushan.user_service.service;

import com.yathushan.user_service.model.User;
import com.yathushan.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){
            return null;
        }
        return  users;
    }
}
