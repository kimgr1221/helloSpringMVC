package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OfferDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // 모든 교과목을 검색하여 리스트로 반환하는 메서드
    public List<Offer> getOffers() {

        String sqlStatement= "select * from offers";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

            @Override
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

                Offer offer= new Offer();

                offer.setId(rs.getInt("id"));
                offer.setYear(rs.getInt("year"));
                offer.setSemester(rs.getInt("semester"));
                offer.setName(rs.getString("name"));
                offer.setClassification(rs.getString("classification"));
                offer.setProfessor(rs.getString("professor"));
                offer.setCredit(rs.getInt("credit"));

                return offer;
            }
        });
    }


    //  새 교과목을 삽입하는 메서드
    public boolean insert(Offer offer) {

        // 속성 값을 추출
        int year = offer.getYear();
        int semester = offer.getSemester();
        String name= offer.getName();
        String classification= offer.getClassification();
        String professor = offer.getProfessor();
        int credit = offer.getCredit();

        String sqlStatement= "insert into offers (year, semester, name, classification, professor, credit) values (?,?,?,?,?,?)";
        // 쿼리를 실행하고 삽입 결과를 반환합니다.
        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, name, classification, professor, credit}) == 1);
    }
}
