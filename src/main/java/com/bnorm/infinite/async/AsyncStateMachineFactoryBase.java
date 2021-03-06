package com.bnorm.infinite.async;

import com.bnorm.infinite.StateMachineFactoryBase;
import com.bnorm.infinite.StateMachineStructure;

/**
 * The base implementation of an asynchronous state machine factory.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.3.0
 */
public class AsyncStateMachineFactoryBase<S, E, C> extends StateMachineFactoryBase<S, E, C>
        implements AsyncStateMachineFactory<S, E, C> {

    @Override
    public AsyncStateMachine<S, E, C> create(StateMachineStructure<S, E, C> structure, S starting, C context) {
        return new AsyncStateMachineBase<>(structure, starting, context);
    }
}
