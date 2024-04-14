package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer {
    private int id;
    private int year;
    private int semester;

    @Size(min=2, max=50, message = "Name must be between 2 and 50 chars")
    @NotEmpty(message="The name cannot be empty")
    private String name;

    @NotEmpty(message="The classification cannot be empty")
    private String classification;

    @Size(min=2, max=50, message = "Professor must be between 2 and 50 chars")
    @NotEmpty(message="The professor cannot be empty")
    private String professor;

    @NotEmpty(message="The credit cannot be empty")
    private int credit;
}