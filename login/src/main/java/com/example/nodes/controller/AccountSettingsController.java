package com.example.nodes.controller;

import com.example.nodes.entity.Hub;
import com.example.nodes.entity.User;
import com.example.nodes.service.HubService;
import com.example.nodes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/*@Controller
@RequestMapping("/account")
public class AccountSettingsController {

    @Autowired
    private UserService userService;

    @GetMapping("/settings")
    public String getAccountSettings(Principal principal, Model model) {
        // Assuming the username is stored in the Principal
        String username = principal.getName();
        User user = userService.findByUsername(username);

        if (user != null) {
            model.addAttribute("user", user);
            return "accountSettings";
        } else {
            return "redirect:/login"; // or some error page
        }
    }

    @PostMapping("/settings")
    public String updateAccountSettings(@ModelAttribute User user, Model model) {
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("success", "Account settings updated successfully!");
        return "accountSettings";
    }
}*/

@Controller
@RequestMapping("/account")
public class AccountSettingsController {

    @Autowired
    private UserService userService;

    @Autowired
    private HubService hubService;

    @GetMapping("/settings")
    public String getAccountSettings(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Hub> hubs = hubService.findAllHubs();
        model.addAttribute("user", user);
        model.addAttribute("hubs", hubs);
        return "account-settings";
    }

    @PostMapping("/settings")
    public String updateAccountSettings(@ModelAttribute User updatedUser, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        user.setName(updatedUser.getName());
        user.setLocation(updatedUser.getLocation());
        user.setAvailability(updatedUser.isAvailability());
        userService.save(user);
        return "redirect:/account/settings?success=true";
    }
}
