package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @GetMapping("/inquiry")
    public String showCourses(Model model) { //"inquiry" 페이지에 강좌를 표시하는 메서드
        // InquiryService에서 모든 강좌를 가져옵니다.
        List<Course> courses = inquiryService.getAllCourses();
        // 강좌 목록을 모델 속성에 추가합니다.
        model.addAttribute("courses", courses);

        // InquiryService에서 년도 및 학기별 총 학점을 가져옵니다.
        Map<String, Integer> totalCredits = inquiryService.getTotalCreditsPerYearAndSemester();
        // 총 학점 맵을 모델 속성에 추가합니다.
        model.addAttribute("totalCredits", totalCredits);

        return "inquiry";
    }
}