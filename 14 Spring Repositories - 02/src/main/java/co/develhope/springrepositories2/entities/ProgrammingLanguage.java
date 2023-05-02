package co.develhope.springrepositories2.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Table
@Data
@Entity
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @Column(nullable = true)
    private int firstAppearance;
    @NotNull
    private String inventor;

}
