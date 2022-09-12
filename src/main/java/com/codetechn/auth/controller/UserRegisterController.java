package com.codetechn.auth.controller;

import com.codetechn.auth.entity.User;
import com.codetechn.auth.service.UserService;
import com.codetechn.auth.user.UserCrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
/*@SessionAttributes("email")*/
public class UserRegisterController {
    

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    private Logger logger = Logger.getLogger(getClass().getName());

    //use service instead of dao


    @GetMapping("/user-panel")
    public String index(){

        return "user_panel";
    }
    @GetMapping("/")
    public String showAuthForm(Model model){
        UserCrm userCrm=new UserCrm();
        model.addAttribute("title","Register Page");
        model.addAttribute("crmUser",userCrm);

        return "index";
    }

    @PostMapping("/register-user")
    public String registerUser(@Valid @ModelAttribute("crmUser")UserCrm crmUser, BindingResult bindingResult, Model model, HttpSession session
          /*  @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "confirm_password") String confirm_password,
            @RequestParam(name = "number") String number,
            @RequestParam(name = "address") String address*/

    ){

        String username=crmUser.getName();
        logger.info("proceesing registration for " + username);

        /*return name + email + password + confirm_password + number + address;*/
        if (bindingResult.hasErrors()){
            return "index";
        }
        /*check if the two password are the same*/
        if(crmUser.getPassword() == null ? crmUser.getConfirm_password() != null : !crmUser.getPassword().equals(crmUser.getConfirm_password())){
            model.addAttribute("registrationError","The password Fields doesn't match");
            return "index";
        }
        /*check if user exist*/
        User userExist = userService.findByemail(crmUser.getEmail());
        if(userExist!=null){
            model.addAttribute("crmUser",new UserCrm());
          model.addAttribute("registrationError","user already exist");

          return "index";
        }


      /*    ModelAndView  mv = new ModelAndView("email");
            mv.addObject("userName",crmUser.getEmail());*/
        session.setAttribute("email",crmUser.getEmail());
        session.setAttribute("name",crmUser.getName());

           userService.registerUser(crmUser);
            return "user_panel";

    }





}
