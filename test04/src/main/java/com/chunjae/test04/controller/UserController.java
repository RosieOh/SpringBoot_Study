package com.chunjae.test04.controller;

import com.chunjae.test04.entity.User;
import com.chunjae.test04.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();

    @GetMapping("list.do")
    public String userList(Model model) throws Exception {
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);
        model.addAttribute("title", "회원 목록");
        return "/user/userList";
    }

    @GetMapping("detail.do")
    public String detailUser(@RequestParam String id, Model model) throws Exception {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/userDetail";
    }

    @GetMapping("mypage.do")
    public String mypage(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/mypage";
    }

    @GetMapping("term.do")
    public String getAgree(Model model) throws Exception {
        return "/user/agree";
    }

    @GetMapping("join.do")
    public String getJoin(Model model) throws Exception {
        return "/user/userInsert";
    }

    @RequestMapping(value="idCheck.do", method= RequestMethod.POST)
    public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        User user = userService.getUser(id);
        boolean result = false;
        if(user!=null){
            result = false;
        } else {
            result = true;
        }
        JSONObject json = new JSONObject();
        json.put("result", result);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
    }

    // 회원 가입 - 회원 가입 처리 (POST 요청)
    @PostMapping("insert.do")
    public String memberWrite(Member member, Model model) throws Exception {
        String ppw = member.getPw();
        String pw = pwEncoder.encode(ppw);
        member.setPw(pw);
        memberService.memberInsert(member);
        return "redirect:/";
    }

    //로그인 폼 로딩
    @RequestMapping("login.do")
    public String memberLoginForm(Model model) throws Exception {
        return "/member/loginForm";
    }

    //로그인을 컨트롤러에서 처리
    // 로그인 처리
    @PostMapping("signin.do")
    public String memberSignIn(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        Member mem = memberService.signIn(id);

        if (mem != null) {
            boolean loginSuccess = pwEncoder.matches(pw, mem.getPw());
            if (loginSuccess) {
                session.setAttribute("sid", id); // 로그인 세션 설정
                return "redirect:/"; // 로그인 성공 시 메인 페이지로 리다이렉트
            }
        }

        // 로그인 실패 시 에러 메시지를 모델에 추가하고 로그인 페이지로 이동
        model.addAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
        return "/member/loginForm";
    }
    //서비스에서 로그인 로직 처리
    @RequestMapping(value = "loginpro.do", method = RequestMethod.POST)
    public String memberLogin(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        boolean ps = memberService.loginCheck(id, pw);
        if (ps) {
            session.setAttribute("sid", id);
            return "redirect:/Home";
        } else {
            // 로그인 실패 시 메시지를 모델에 추가
            model.addAttribute("loginError", "아이디와 비밀번호가 일치하지 않습니다.");
            return "/member/loginForm"; // 로그인 실패 시 다시 로그인 페이지로 이동
        }
    }

    @GetMapping("logout.do")
    public String memberLogout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    // 아이디 찾기 폼 로딩
    @GetMapping("find_id.do")
    public String findIdForm() {
        return  "/member/findIdForm";
    }

    // 아이디 찾기 처리
    @PostMapping("find_id_process.do")
    public String findIdProcess(@RequestParam String email, Model model) throws Exception {
        // 이메일을 기반으로 아이디를 찾음
        String foundId = memberService.findByEmail(email);
        if (foundId != null) {
            model.addAttribute("foundId", foundId);
            return "/member/foundId";
        } else {
            model.addAttribute("message", "일치하는 이메일 주소로 등록된 아이디가 없습니다.");
            return "/member/findIdForm";
        }
    }

    //회원정보 변경
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String memberUpdate(Member mem, Model model) throws Exception {
        String pwd = "";
        if(mem.getPw().length()<=16) {
            pwd = pwEncoder.encode(mem.getPw());
            mem.setPw(pwd);
        }
        memberService.memberEdit(mem);
        return "redirect:/";
    }
    //회원 탈퇴
    @RequestMapping(value="delete.do", method = RequestMethod.GET)
    public String memberDelete(@RequestParam String id, Model model, HttpSession session) throws Exception {
        memberService.memberDelete(id);
        session.invalidate();
        return "redirect:/";
    }

    // 비밀번호 찾기 폼 로딩
    @GetMapping("find_pw.do")
    public String findPwForm() {
        return  "/member/findPwForm";
    }

    // 비밀번호 찾기 처리
    @PostMapping("find_pw_process.do")
    public String findPasswordProcess(@RequestParam String id, @RequestParam String email, Model model) throws Exception {
        // 아이디와 이메일을 기반으로 비밀번호를 찾음
        String newPassword = memberService.findPassword(id, email);
        if (newPassword != null) {
            // 새로운 비밀번호를 생성하여 사용자에게 보여줄 수도 있음
            model.addAttribute("newPassword", newPassword);
            return "/member/foundPassword"; // 비밀번호를 찾은 페이지로 이동
        } else {
            model.addAttribute("message", "일치하는 정보로 등록된 비밀번호가 없습니다.");
            return "/member/findPasswordForm"; // 비밀번호를 찾지 못한 경우 다시 비밀번호 찾기 폼으로 이동
        }
    }
}
