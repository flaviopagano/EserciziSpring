package co.develhope.stateMachine.order.entities;

import co.develhope.stateMachine.user.entities.User;
import co.develhope.stateMachine.utils.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;


@Table(name = "orders")
@Entity
@Data
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;
    private String address;
    private String number;
    private String city;
    private String zipcode;
    private String state;

    private  OrderStateEnum status = OrderStateEnum.CREATED;

    @ManyToOne
    private User restaurant;
    @ManyToOne
    private User rider;


    private double totalPrice;




}
