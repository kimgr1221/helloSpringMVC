package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 모든 과목을 검색하여 리스트로 반환하는 메서드
    public List<Course> getCourses() {
        String sqlStatement = "SELECT * FROM courses";
        return jdbcTemplate.query(sqlStatement, (rs, rowNum) -> {
            Course course = new Course();
            // 각 열을 Course 객체의 속성에 매핑합니다.
            course.setYear(rs.getInt("year"));
            course.setSemester(rs.getInt("semester"));
            course.setCode(rs.getString("code"));
            course.setName(rs.getString("name"));
            course.setClassification(rs.getString("classification"));
            course.setProfessor(rs.getString("professor"));
            course.setCredit(rs.getInt("credit"));
            return course;
        });
    }

}

