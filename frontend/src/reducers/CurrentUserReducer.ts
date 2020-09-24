import {User} from '../services/Users';
import * as React from 'react';
import {createStore, Action} from '../context/Context';

enum CurrentUserActions {
    SET_USER = 'SET_USER',
}

interface State {
    user: User;
}

const initialState: State = {
    user: null,
};

const currentUserReducer = (state: State, action: Action<CurrentUserActions>) => {
    switch (action.type) {
        case CurrentUserActions.SET_USER: {
            return {user: action.payload.user};
        }
    }
};

const [CurrentUserProvider, useCurrentUser] = createStore<State, CurrentUserActions>(
    currentUserReducer,
    initialState
);

export {CurrentUserActions, CurrentUserProvider, useCurrentUser};
