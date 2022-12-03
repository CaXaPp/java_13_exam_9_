package com.example.exam9.controller.web;


import com.example.exam9.entity.Status;
import com.example.exam9.entity.Task;
import com.example.exam9.entity.User;
import com.example.exam9.model.*;
import com.example.exam9.service.RedirectUtil;
import com.example.exam9.service.TaskService;
import com.example.exam9.service.UserService;
import com.example.exam9.service.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final WorkLogService workLogService;


    @GetMapping("/create")
    public ModelAndView createUser(@AuthenticationPrincipal User principal) {
        return new ModelAndView("/createTask")
                .addObject("taskDto", new AddTaskDTO());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute("taskDto") @Valid AddTaskDTO dto,
                              @AuthenticationPrincipal User principal) {
        Task task = taskService.create(dto, principal);
        return RedirectUtil.redirect("/");
    }

    @GetMapping("/view")
    public ModelAndView view(@AuthenticationPrincipal User principal,
                                   @RequestParam ("id") Task task) {
        List<User> developers = userService.findAllDevelopers();
        return new ModelAndView("/viewTask")
                .addObject("task",TaskDTO.of(task))
                .addObject("principal", principal)
                .addObject("developers", developers)
                .addObject("workLogs", task.getWorkLogsList());
    }


    @PostMapping(value = "/assign")
    public ModelAndView assign(@AuthenticationPrincipal User principal,
                               @RequestParam ("id") Task task,
                               @RequestParam ("userId") User developer) {
        task = taskService.assignDeveloper(task, developer);
        return RedirectUtil.redirect("/tasks/view?id=" + task.getId());
    }

    @PostMapping(value = "/edit")
    public ModelAndView assign(@AuthenticationPrincipal User principal,
                               @RequestParam ("id") Task task,
                               @RequestParam ("name") String name,
                               @RequestParam ("status") Status status) {
        task = taskService.edit(task, name, status);
        return RedirectUtil.redirect("/tasks/view?id=" + task.getId());
    }

    @PostMapping(value = "/addwork")
    public ModelAndView addwork(@AuthenticationPrincipal User principal,
                               @RequestParam ("id") Task task,
                               @RequestParam ("time") String time,
                               @RequestParam ("description") String description) {
        workLogService.addWorkLog(task, time, description, principal);
        return RedirectUtil.redirect("/tasks/view?id=" + task.getId());
    }
}
