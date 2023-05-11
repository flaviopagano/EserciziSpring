package co.develhope.stateMachine.user.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String name;

    private String description;
}
