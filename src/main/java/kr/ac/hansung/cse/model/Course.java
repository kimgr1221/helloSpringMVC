package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    private int year;
    private int semester;
    private String code;
    private String name;
    private String classification;
    private String professor;
    private int credit;

}
