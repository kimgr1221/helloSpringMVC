package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

    @Autowired
    private CourseDao courseDao;

    // 모든 교과목을 가져오는 메서드
    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    // 년도 및 학년별 총 학점을 계산하는 메서드
    public Map<String, Integer> getTotalCreditsPerYearAndSemester() {
        // 모든 교과목을 가져오고 년도 및 학기별 총 학점을 저장할 맵을 생성합니다.
        List<Course> courses = courseDao.getCourses();
        Map<String, Integer> totalCredits = new HashMap<>();

        // 각 교과목에 대해 반복하며 년도 및 학기별로 총 학점을 계산합니다.
        for (Course course : courses) {
            String key = course.getYear() + "-" + course.getSemester();
            totalCredits.put(key, totalCredits.getOrDefault(key, 0) + course.getCredit());
        }

        return totalCredits; // 년도 및 학기별 총 학점 맵을 반환합니다.
    }
}
