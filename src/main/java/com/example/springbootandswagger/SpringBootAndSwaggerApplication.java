package com.example.springbootandswagger;

import com.example.springbootandswagger.model.Role;
import com.example.springbootandswagger.model.User;
import com.example.springbootandswagger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class SpringBootAndSwaggerApplication {
    private final UserRepository userRepository;
    private final PasswordEncoder pass;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndSwaggerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Elbek");
        user.setLastName("Mashrapov");
        user.setEmail("elbek@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(pass.encode("elbek"));
        userRepository.save(user);

        User use = new User();
        use.setFirstName("Som");
        use.setLastName("Sum");
        use.setRole(Role.STUDENT);
        use.setEmail("som@gmail.com");
        use.setPassword(pass.encode("som"));
        userRepository.save(use);
    }
}