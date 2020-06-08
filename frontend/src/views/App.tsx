import * as React from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import {SignIn} from './sign-in/SignIn';
import {SignUp} from './sign-up/SignUp';
import {WithGlobalStyles} from '../common/styles/GlobalStyles';
import { Header } from '../common/components/Header/Header';

const App: React.FC = () => {
    return (
        <Router>
            <WithGlobalStyles>
                <Header>
                    <Switch>
                        <Route path="/signin">
                            <SignIn />
                        </Route>
                        <Route path="/signup">
                            <SignUp />
                        </Route>
                    </Switch>
                </Header>
            </WithGlobalStyles>
        </Router>
    );
};

export {App};
