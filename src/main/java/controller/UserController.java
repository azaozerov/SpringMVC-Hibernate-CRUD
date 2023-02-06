package controller;

import model.User;
import model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
        us.createUser(new User("Иван", "Иванов", (byte) 25));
        us.createUser(new User("Сергей", "Сергеев", (byte) 45));
        us.createUser(new User("Митрофан", "Митрофанов", (byte) 78));
        us.createUser(new User("Петр", "Петров", (byte) 12));
    }

    @GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("users", us.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String createUserForm(ModelMap model) {
        model.addAttribute("user", us.getNewUser());
        return "createUserForm";
    }

    @PostMapping
    //аннотация @ModelAttribute позволяет из модели(Model) сразу получить готовый объект, а не передавать параметры по одному
    public String createUser(@ModelAttribute("user") User user) {
        us.createUser(user);
        //создание пользователя в БД и переход на страницу со всеми пользователями
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String updateUserForm(ModelMap model, @PathVariable("id") long id ) {
        model.addAttribute("user", us.readUser(id));
        return "updateUserForm";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        us.updateUser(user);
        //обновление пользователя в БД и переход на страницу со всеми пользователями
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser( @PathVariable("id") long id) {
        us.deleteUser(id);
        //обновление пользователя в БД и переход на страницу со всеми пользователями
        return "redirect:/users";
    }
}
