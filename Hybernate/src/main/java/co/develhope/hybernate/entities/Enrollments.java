package co.develhope.hybernate.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Enrollments")

public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "students_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Students students;

    @JoinColumn(name = "classes_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolClass schoolClass;

}