package com.mygg.mygg.controller;

import com.mygg.mygg.dto.AccountForm;
import com.mygg.mygg.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @GetMapping("/join")
    public String createUserForm(Model model) {
        model.addAttribute("userForm", new AccountForm());
        return "/user/login/join";
    }

    @PostMapping("/join")
    public String createUser(AccountForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "/user/login/join";
        }
        accountService.createUser(form);
        return "redirect:/";
    }
}