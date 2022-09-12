package com.codetechn.auth.controller;

import com.codetechn.auth.entity.User;
import com.codetechn.auth.service.UserService;
import com.codetechn.auth.user.LoginValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class UserLoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("title","Login Page");
        model.addAttribute("loginUser",new LoginValidation());
        return "login";
    }

    @PostMapping("/login-user")
    public String postLoginFrom(@Valid @ModelAttribute("loginUser") LoginValidation loginUser, BindingResult bindingResult, Model model, HttpSession session
                                ){
        String email=loginUser.getEmail();
        logger.info("proccessing login for"+email );
         if (bindingResult.hasErrors()){
             return "login";
         }
         final User userExist = userService.findByemail(email);
         if(userExist==null){
             model.addAttribute("loginUser",new LoginValidation());
             model.addAttribute("registrationError","please enter valid informations");
             return "login";
         }

         if(passwordEncoder.matches(loginUser.getPassword(),userExist.getPassword())){
              session.setAttribute("email",userExist.getEmail());
              session.setAttribute("name",userExist.getName());
              return "user_panel";
         }else{
             model.addAttribute("loginUser",new LoginValidation());
             model.addAttribute("registrationError","please enter valid informations");
             return "login";
         }
       /*  session.setAttribute("email",userExist.getEmail());
         session.setAttribute("name",userExist.getName());*/



/*
        return "user_panel";*/
    }

    @PostMapping("/logout")
    public String logout(Model model,HttpSession session){

        session.invalidate();

        return "redirect:/login";

    }

}
