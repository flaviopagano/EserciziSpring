package co.develhope.stateMachine.user.repositories;

import co.develhope.stateMachine.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByActivationCode(String activationCode);

    User findByPasswordResetCode(String passwordResetCode);

    Optional<User> findById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM (\n" +
            "SELECT u.*, COUNT(busyOrders.id) AS numberOfOrders\n" +
            "FROM `users` AS u\n" +
            "LEFT JOIN user_roles AS ur ON ur.user_id = u.id\n" +
            "LEFT JOIN ( SELECT * FROM `orders` WHERE `status` IN(4) ) AS busyOrders ON busyOrders.rider_id = u.id\n" +
            "WHERE ur.role_id = 3 AND u.is_Active = 1\n" +
            "GROUP BY u.id\n" +
            ") AS allRiders\n" +
            "WHERE allRiders.numberOfOrders = 0\n" +
            "LIMIT 1")
    Optional<User> pickRider();

}
