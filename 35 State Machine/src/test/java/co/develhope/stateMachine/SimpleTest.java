package co.develhope.stateMachine;

import co.develhope.stateMachine.order.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc
@SpringBootTest
public class SimpleTest {




    @Test
    public void simpleTest(){
        Order order = new Order();
        // accept
        // in preparation
        // ready
        // delivering
        // completed


    }



}
