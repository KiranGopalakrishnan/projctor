import { User } from "../services/Users";
import * as React from 'react';
import { createStore, Action } from "../context/Context";

enum UserActions {
    SET_USER = "SET_USER"
}

interface State {
    user: User
}

const initialState:State = {
    user: null,
}

const userReducer = (state:State,action:Action<UserActions>) => {
    switch(action.type){
        case UserActions.SET_USER : {
            return {user: action.payload};
        }
    }
}


const [UserProvider,useCurrentUser] = createStore<State,UserActions>(userReducer,initialState);


export {UserActions, UserProvider, useCurrentUser};