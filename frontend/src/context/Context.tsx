import * as React from 'react';

interface Action<T> {
    type: T;
    payload: any;
}

const createStore = <T, P>(reducer: (state: T, action: Action<P>) => T, initialState: T) => {
    const stateContext = React.createContext(null);

    const reducerContext = React.createContext(null);

    const useDispatch = () => {
        const context = React.useContext(reducerContext);
        if (context === undefined) {
            throw new Error('dispatch must be used within a provider');
        }
        return context;
    };

    const useStateValue = () => {
        const context = React.useContext(stateContext);
        if (context === undefined) {
            throw new Error('state must be used within a provider');
        }
        return context;
    };

    const useState = () => [useStateValue(), useDispatch()];

    const Provider: React.FC<{children: React.ReactNode}> = ({
        children,
    }: {
        children: React.ReactNode;
    }) => {
        const [state, dispatch] = React.useReducer(reducer, initialState);

        return (
            <stateContext.Provider value={state}>
                <reducerContext.Provider value={dispatch}>{children}</reducerContext.Provider>
            </stateContext.Provider>
        );
    };
    const StatefulProvider = Provider as React.FC<{children: React.ReactNode}>;
    const useStateHook = useState as Function;
    return [StatefulProvider, useStateHook];
};

export {createStore, Action};
