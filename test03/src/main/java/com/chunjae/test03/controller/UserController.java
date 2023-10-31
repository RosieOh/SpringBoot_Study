package com.chunjae.test03.controller;

import com.chunjae.test03.entity.Euser;
import com.chunjae.test03.service.UserService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    BCryptPasswordEncoder pwEncoder;

    @GetMapping("userList.do")
    public String getUserList(HttpSession session, Model model) {
        String slevel = (String) session.getAttribute("slevel");
        List<Euser> userList = userService.getUserList();
        model.addAttribute("msg", "회원가입 한 사용자를 불러옵니다.");
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("user.do")
    public String getUser(@RequestParam("name") String name, Model model) {
        Euser user = userService.getUser(name);
        model.addAttribute("user", user);
        return "user/get";
    }

    // 로그인 폼 불러오기
    @RequestMapping("login.do")
    public String userLoginForm(HttpSession session, Model model) {
        String sname = (String) session.getAttribute("sname");
        if (sname != null) {
            return "redirect:/";
        }
        return "/user/loginForm";
    }

    // 일반 회원 본인 정보 확인
    @GetMapping("mypage.do")
    public String mypage(Model model) throws Exception {
        String name = (String) session.getAttribute("sid");
        Euser euser = userService.getUser(name);
        return "/user/mypage";
    }

    // 이메일 로그인
    @PostMapping("/loginByEmail.do")
    public String loginByEmailPro(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) throws Exception {
        Euser user = userService.getByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("msg", "로그인 성공");
                session.setAttribute("sname", user.getName()); // 로그인 세션 설정
            } else {
                model.addAttribute("msg", "비밀번호 오류 로그인 실패");
                session.invalidate();
            }
        } else {
            model.addAttribute("msg", "해당 이메일을 가진 회원이 존재하지 않습니다.");
        }
        return "redirect:/"; // 로그인 성공 시 메인 페이지로 리다이렉트
    }


    // ID 로그인
    @PostMapping("loginByName.do")
    public String loginByNamePro(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session, Model model) throws Exception {
        Euser user = userService.getByName(name);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("msg", "로그인 성공");
                session.setAttribute("sname", user.getName()); // 로그인 세션 설정
                session.setAttribute("slevel", user.getLev());
            } else {
                model.addAttribute("msg", "비밀번호 오류 로그인 실패");
                session.invalidate();
            }
        } else {
            model.addAttribute("msg", "해당 아이디를 가진 회원이 존재하지 않습니다.");
        }
        return "redirect:/"; // 로그인 성공 시 메인 페이지로 리다이렉트
    }

    // 탈퇴
    @GetMapping("delete.do")
    public String userDelete(@RequestParam("name") String name, HttpSession session, Model model) throws Exception {
        userService.getWithdraw(name);
        session.invalidate();
        return "redircet:/";
    }

    // 계정 활성화
    @GetMapping("activate.do")
    public String userActivate(@RequestParam("name") String name, HttpSession session, Model model) throws Exception {
        userService.getActivate(name);
        session.invalidate();
        return "redircet:/";
    }

    // 휴면 처리
    @GetMapping("dormant.do")
    public String userDormant(@RequestParam("name") String name, HttpSession session, Model model) throws Exception {
        userService.getDormant(name);
        session.invalidate();
        return "redircet:/";
    }
    // 아이디 찾기
    @GetMapping("findById.do")
    public String findByIdForm() {
        return "/user/findIdForm";
    }

    @PostMapping("findById.do")
    public String findById(@RequestParam String email, String tel, Model model) throws Exception {
        Euser foundId = userService.findByEmail(email, tel);
        if(foundId != null) {
            model.addAttribute("foundId", foundId);
            return "/user/findById";
        } else {
            model.addAttribute("message", "일치하는 이메일 주소로 등록된 아이디가 없습니다.");
            return "/user/fidById";
        }
    }

    // 비밀번호 찾기
    @GetMapping("findPw.do")
    public String findByPwForm(Euser euser) {
        return "/user/findPwForm";
    }

    @PostMapping("findPw.do")
    public String findByPw(@RequestParam String email, String tel, String name, Model model) throws Exception {
        Euser foundPw = userService.findByEmail(email, tel);
        if(foundPw != null) {
            model.addAttribute("foundPw", foundPw);
            return "/user/findByPw";
        } else {
            model.addAttribute("message", "일치하는 이메일 주소로 등록된 비밀번호가 없습니다.");
            return "/user/findByPw";
        }
    }

    // 회원 가입
    @GetMapping("join.do")
    public String joinFormLoad(HttpSession session, Model model) {
        String sname = (String)session.getAttribute("sname");
        if(sname!=null) {
            model.addAttribute("msg", "현재 로그인이 되어있으므로 회원뉴진스의하입보이 하실 수 없습니다.");
            return "index";
        }
        model.addAttribute("msg", "회원가입 하시길 바랍니다.");
        return "/user/join";
    }

    @PostMapping("/joinPro.do")
    public String joinPro(Euser euser, Model model) throws Exception {
        userService.insertUser(euser);
        return "user/login";
    }

    // 회원 정보 수정
    @RequestMapping(value="update.do", method= RequestMethod.POST)
    public String userUpdate(Euser euser, Model model) throws Exception {
        String pwd = "";
        if(euser.getPassword().length()<=16) {
            euser.setPassword(pwd);
        }
        userService.editUser(euser);
        return "redirect:/";
    }



}
