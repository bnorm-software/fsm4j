package com.bnorm.infinite;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base implementation of an internal state.
 *
 * @param <S> the class type of the states.
 * @param <E> the class type of the events.
 * @param <C> the class type of the context.
 * @author Brian Norman
 * @since 1.0.0
 */
public class InternalStateBase<S, E, C> implements InternalState<S, E, C> {

    /** The wrapped state. */
    protected final S state;

    /** The optional parent state. */
    protected Optional<InternalState<S, E, C>> parent;

    /** The children of the state. */
    protected final Set<InternalState<S, E, C>> children;

    /** The entrance actions of the state. */
    protected final Set<Action<? super S, ? super E, ? super C>> entranceActions;

    /** The exit actions of the state. */
    protected final Set<Action<? super S, ? super E, ? super C>> exitActions;

    /**
     * Constructs a new internal state form the specified state.
     *
     * @param state the state to wrap.
     */
    protected InternalStateBase(S state) {
        this.state = state;
        this.parent = Optional.empty();
        this.children = new LinkedHashSet<>();
        this.entranceActions = new LinkedHashSet<>();
        this.exitActions = new LinkedHashSet<>();
    }

    /**
     * Constructs a new internal state form the specified state and action comparators.  The action comparators are used
     * to sort the entrance and exit states of the internal state.
     *
     * @param state the state to wrap.
     * @param entranceComparator the entrance action comparator.
     * @param exitComparator the exit action comparator.
     */
    protected InternalStateBase(S state, Comparator<Action<? super S, ? super E, ? super C>> entranceComparator,
                                Comparator<Action<? super S, ? super E, ? super C>> exitComparator) {
        this.state = state;
        this.parent = Optional.empty();
        this.children = new LinkedHashSet<>();
        this.entranceActions = new TreeSet<>(entranceComparator);
        this.exitActions = new TreeSet<>(exitComparator);
    }

    @Override
    public S getState() {
        return state;
    }

    @Override
    public void setParentState(InternalState<S, E, C> parent) {
        this.parent = Optional.ofNullable(parent);
    }

    @Override
    public Optional<InternalState<S, E, C>> getParentState() {
        return parent;
    }

    @Override
    public Set<InternalState<S, E, C>> getChildrenStates() {
        return Collections.unmodifiableSet(children);
    }

    @Override
    public void addChild(InternalState<S, E, C> state) {
        children.add(state);
    }

    @Override
    public Set<Action<? super S, ? super E, ? super C>> getEntranceActions() {
        return Collections.unmodifiableSet(entranceActions);
    }

    @Override
    public void addEntranceAction(Action<? super S, ? super E, ? super C> action) {
        entranceActions.add(action);
    }

    @Override
    public Set<Action<? super S, ? super E, ? super C>> getExitActions() {
        return Collections.unmodifiableSet(exitActions);
    }

    @Override
    public void addExitAction(Action<? super S, ? super E, ? super C> action) {
        exitActions.add(action);
    }
}
