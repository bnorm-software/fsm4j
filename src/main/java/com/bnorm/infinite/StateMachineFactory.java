package com.bnorm.infinite;

/**
 * A factory interface for state machines.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.0.0
 */
public interface StateMachineFactory<S, E, C> {

    /**
     * Returns the default state machine factory.  This is the state machine base constructor.
     *
     * @param <S> the class type of the states.
     * @param <E> the class type of the events.
     * @param <C> the class type of the context.
     * @return default state machine factory.
     */
    static <S, E, C> StateMachineFactory<S, E, C> getDefault() {
        return StateMachineBase::new;
    }

    /**
     * Creates a state machine from the specified state machine structure, starting state, and context.
     *
     * @param structure the state machine structure.
     * @param starting the starting state of the state machine.
     * @param context the state machine context.
     * @return a state machine.
     */
    StateMachine<S, E, C> create(StateMachineStructure<S, E, C> structure, S starting, C context);
}
