package com.bnorm.fsm4j;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * The base implementation of a state machine builder.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @version 1.0
 * @since 1.0
 */
public class StateMachineBuilderBase<S extends State, E extends Event, C extends Context>
        implements StateMachineBuilder<S, E, C> {

    /** The state machine builder internal state factory. */
    private final InternalStateFactory stateFactory;

    /** The state machine builder state builder factory. */
    private final StateBuilderFactory<S, E, C> configurationFactory;

    /** The state to internal state map. */
    private final Map<S, InternalState<S, E, C>> states;

    /** The event to transition map. */
    private final Map<E, Set<Transition<S>>> transitions;


    /**
     * Constructs a new state machine builder from the specified state builder factory and internal state factory.
     *
     * @param stateFactory the factory used to create internal states.
     * @param configurationFactory the factory used to create state builders.
     */
    protected StateMachineBuilderBase(InternalStateFactory stateFactory,
                                      StateBuilderFactory<S, E, C> configurationFactory) {
        this.stateFactory = stateFactory;
        this.configurationFactory = configurationFactory;
        this.states = new LinkedHashMap<>();
        this.transitions = new LinkedHashMap<>();
    }

    @Override
    public StateBuilder<S, E, C> configure(S state) {
        InternalState<S, E, C> internal = states.computeIfAbsent(state, stateFactory::create);
        return configurationFactory.create(states, transitions, internal);
    }

    @Override
    public StateMachine<S, E, C> build(S starting, C context) {
        return new StateMachineBase<>(states, transitions, starting, context);
    }
}
