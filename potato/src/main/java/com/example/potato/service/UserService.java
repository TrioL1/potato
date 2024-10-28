package com.example.potato.service;

import com.example.potato.model.User;
import com.example.potato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 사용자 ID로 조회 (Optional<User> 변환 -> isPresent() 사용하기 위해)
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // 사용자 생성
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 업데이트
    // User 클래스에 getter & setter 메소드가 정의되어야 한다
    public User updateUser(Long userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            user.setPassword(userDetails.getPassword());
            user.setState(userDetails.getState());
            user.setDeleted(userDetails.isDeleted());
            user.setPwdFailCnt(userDetails.getPwdFailCnt());
            return userRepository.save(user);
        }).orElse(null);
    }

    // 사용자 삭제
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
