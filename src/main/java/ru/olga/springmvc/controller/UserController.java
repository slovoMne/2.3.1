package ru.olga.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.olga.springmvc.service.UserServiceImpl;
import ru.olga.springmvc.model.User;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping(value = "/")
    public String printWelcome() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String printUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @GetMapping(value = "/users/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "/users/edit";
    }

    @PatchMapping("/users/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
         userService.updateUser(user);
         return "redirect:/users";
    }

}
