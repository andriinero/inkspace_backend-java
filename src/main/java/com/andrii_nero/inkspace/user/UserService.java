package com.andrii_nero.inkspace.user;

import com.andrii_nero.inkspace.user.dto.PostUserRequest;
import com.andrii_nero.inkspace.user.model.User;
import com.andrii_nero.inkspace.user.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(PostUserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        user.setRole(UserRole.USER);
        user.setSignUpDate(new Date());
        user.setProfileImage(request.profileImage());

        userRepository.save(user);
    }
}
