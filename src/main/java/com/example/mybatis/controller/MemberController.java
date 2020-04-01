package com.example.mybatis.controller;

import com.example.mybatis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired MemberMapper memberMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(HttpSession session, Model model,
                            @RequestParam("loginId") String loginId,
                            @RequestParam("password") String password) {

        String errorMsg = "";
        String pwd = memberMapper.loginCheck(loginId);

        if (pwd == null) {
            errorMsg = "아이디가 존재하지 않습니다";
            model.addAttribute("errorMsg", errorMsg);
            return "login/loginForm";
        }

        if (!pwd.equals(password)) {
            errorMsg = "아이디와 비밀번호를 다시 입력하세요";
            model.addAttribute("errorMsg", errorMsg);
            return "login/loginForm";
        }

        session.setAttribute("userId", loginId);
        model.addAttribute("userId", loginId);
        return "redirect:/post/list";

    }
}
