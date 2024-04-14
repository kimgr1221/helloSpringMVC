package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

        if(error != null) { // 모델에 errorMsg속성을 추가해서 에러가 존재하면 유효하지 않은 사용자 이름 또는 비밀번호임을 알려줍니다.
            model.addAttribute("errorMsg","Invalid username or password");
        }

        if(logout != null) { // 모델에 logoutMsg 속성을 추가해서 로그아웃이 성공적으로 이루어짐을 알려줍니다.
            model.addAttribute("logoutMsg", "You have been logged out successfully ");
        }

        return "login";
    }
}
