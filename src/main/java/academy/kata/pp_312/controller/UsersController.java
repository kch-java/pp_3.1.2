package academy.kata.pp_312.controller;

import academy.kata.pp_312.model.User;
import academy.kata.pp_312.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring Boot - MVC - Hibernate - CRUD application");
        messages.add("kata.academy. Java pre-project. Task 3.1.2");
        messages.add("Click on the link below to continue");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users";
        } else {
            userService.add(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping("edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userupdate";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userupdate";
        } else {
            userService.update(user);
            return "redirect:/users";
        }
    }
}
