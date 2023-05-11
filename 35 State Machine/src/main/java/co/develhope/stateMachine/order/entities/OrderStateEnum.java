package co.develhope.stateMachine.order.entities;


/**
 *      States of the order
 */
public enum OrderStateEnum {
        CREATED,
        ACCEPTED,
        IN_PREPARATION,
        READY,
        DELIVERING,
        COMPLETED,
        CLOSED
}
