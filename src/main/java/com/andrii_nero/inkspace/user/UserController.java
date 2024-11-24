package com.andrii_nero.inkspace.user;

import com.andrii_nero.inkspace.user.dto.PostUserRequest;
import com.andrii_nero.inkspace.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<String> postUser(PostUserRequest request) {
        userService.saveUser(request);

        return ResponseEntity.ok("Successfully posted user");
    }
}
