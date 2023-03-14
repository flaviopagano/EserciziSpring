package co.develhope.hybernate.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SchoolClass")

public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Enrollments> enrollments;


}
