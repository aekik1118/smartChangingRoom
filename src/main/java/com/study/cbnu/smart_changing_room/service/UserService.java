package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        Long result = userRepository.save(user);
        return user;
    }


    public Optional<User> get(Long id) {
        return userRepository.getUser(id);
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<User> getByName(String name) {
        return userRepository.getUserByName(name);
    }
}
