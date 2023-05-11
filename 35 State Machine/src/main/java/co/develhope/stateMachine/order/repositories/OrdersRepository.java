package co.develhope.stateMachine.order.repositories;

import co.develhope.stateMachine.order.entities.Order;
import co.develhope.stateMachine.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository <Order, Long> {
    List <Order> findByCreatedBy (User user);

    List <Order> findByRestaurant (User user);

    List <Order> findByRider (User user);

}
