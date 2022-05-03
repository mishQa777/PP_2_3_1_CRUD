package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersInfo {
    @Autowired
    private UserService us;

    @GetMapping(value = "/")
    public String postInfo(Model model){
        List<User> users = us.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String addUser(@ModelAttribute User user){
        us.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/saveUser")
    public String updateUser(@ModelAttribute User user){
        System.out.println(user.toString());
        us.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam("id") long id, Model model){
        User user = us.getUser(id);
        model.addAttribute("userUp", user);
        return "update-user";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") long id){
        us.deleteUser(id);
        return "redirect:/";
    }






}
