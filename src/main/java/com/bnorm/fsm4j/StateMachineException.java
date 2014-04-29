package com.bnorm.fsm4j;

/**
 * Base exception for all state machine related exceptions.
 *
 * @author Brian Norman
 * @version 1.0
 * @since 1.0
 */
public class StateMachineException extends RuntimeException {

    /**
     * Constructs a new state machine exception.
     */
    public StateMachineException() {
    }

    /**
     * Constructs a new state machine exception with the specified message.
     *
     * @param message the exception message.
     */
    public StateMachineException(String message) {
        super(message);
    }

    /**
     * Constructs a new state machine exception with the specified message and throwable cause.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public StateMachineException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new state machine exception with the specified throwable cause.
     *
     * @param cause the exception cause.
     */
    public StateMachineException(Throwable cause) {
        super(cause);
    }
}
