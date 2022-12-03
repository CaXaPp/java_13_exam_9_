package com.example.exam9.controller.web;


import com.example.exam9.entity.Task;
import com.example.exam9.entity.User;
import com.example.exam9.model.TaskDTO;
import com.example.exam9.service.TaskService;
import com.example.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final TaskService taskService;


    @GetMapping("/")
    public ModelAndView createUser(@AuthenticationPrincipal User principal) {
        List<Task> all = taskService.findAll();
        return new ModelAndView("/home")
                .addObject("principal", principal)
                .addObject("tasks", !CollectionUtils.isEmpty(all) ? all.stream()
                        .map(TaskDTO::of).collect(Collectors.toList()) : Collections.EMPTY_LIST);
    }

}
