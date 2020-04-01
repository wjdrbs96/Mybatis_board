package com.example.mybatis.controller;

import com.example.mybatis.dto.Member;
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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "login/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Model model,
                           @RequestParam("loginId") String loginId,
                           @RequestParam("password1") String password1,
                           @RequestParam("password2") String password2,
                           @RequestParam("name") String name,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("email") String email) {

        String error = "";
        Member member = new Member(loginId, password1, name, nickname, email);
        model.addAttribute("member", member);
        model.addAttribute("password2", password2);

        if (loginId == null || loginId.length() == 0) {
            error = "사용자 아이디를 입력하세요";
        }
        else if (password1 == null || password1.length() == 0) {
            error = "비밀번호1를 입력하세요";
        }
        else if (password2 == null || password2.length() == 0) {
            error = "비밀번호2를 입력하세요";
        }
        else if (name == null || name.length() == 0) {
            error = "이름을 입력하세요";
        }
        else if (nickname == null || nickname.length() == 0) {
            error = "닉네임을 입력하세요";
        }
        else if (!password1.equals(password2)) {
            error = "비밀번호 불일치";
        }
        else if (email == null || email.length() == 0) {
            error = "이메일 주소를 입력하세요";
        }
        else {
            if (memberMapper.isSameCheckLoginId(loginId) == 0) {
                memberMapper.memberRegister(member);
                return "redirect:/login";
            }

            error = "아이디가 중복됩니다";
        }
        model.addAttribute("error", error);
        return "login/register";
    }

    @RequestMapping(value = "find/password", method = RequestMethod.GET)
    public String findPassword() {
        return "login/findPassword";
    }

    @RequestMapping(value = "find/password", method = RequestMethod.POST)
    public String findPassword(Model model,
                               @RequestParam("loginId") String loginId,
                               @RequestParam("name") String name) {

        String password = memberMapper.passwordFind(loginId, name);
        if (password == null) {
            String errorMsg = "입력하신 정보가 존재하지 않습니다";
            model.addAttribute("errorMsg", errorMsg);
            return "login/errorPage";
        }

        model.addAttribute("password", password);
        return "login/findPasswordView";
    }

}
