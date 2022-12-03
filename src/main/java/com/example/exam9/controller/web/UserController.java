package com.example.exam9.controller.web;


import com.example.exam9.entity.User;
import com.example.exam9.model.AddUserDto;
import com.example.exam9.model.UserDTO;
import com.example.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/create")
    public ModelAndView createUser(@AuthenticationPrincipal User principal) {
        return new ModelAndView("/createUser")
                .addObject("userDto", new AddUserDto());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute("userDto") @Valid AddUserDto addUserDto,
                              @AuthenticationPrincipal User principal) {
        User user = userService.createUser(addUserDto, principal);
        return new ModelAndView("/createUser")
                .addObject("userDto", UserDTO.of(user));
    }

}
