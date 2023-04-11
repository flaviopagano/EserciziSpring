package co.develhope.fileUploader.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity

@Table(name = "users", indexes = {
        @Index(name = "email_idx", columnList = "email", unique = true)
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String profilePicture;


}
