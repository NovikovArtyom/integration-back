package test.project.integration.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.project.integration.backend.dto.UserDto;
import test.project.integration.backend.service.UserService;

@RestController
@RequestMapping
@CrossOrigin
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody UserDto userDto) {
        userService.registration(userDto);
        return "Пользователь успешно зарегистрирован!";
    }
}
