import * as React from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import {SignIn} from './sign-in/SignIn';
import {SignUp} from './sign-up/SignUp';
import {WithGlobalStyles} from '../common/styles/GlobalStyles';
import {Header} from '../common/components/Header/Header';
import {CurrentUserProvider} from '../reducers/CurrentUserReducer';
import {Home} from './home/Home';
import {ProjectsProvider} from '../reducers/ProjectsReducer';

const App: React.FC = () => {
    return (
        <Router>
            <WithGlobalStyles>
                <CurrentUserProvider>
                    <ProjectsProvider>
                        <Header>
                            <Switch>
                                <Route path="/signin">
                                    <SignIn />
                                </Route>
                                <Route path="/signup">
                                    <SignUp />
                                </Route>
                                <Route path="/home">
                                    <Home />
                                </Route>
                            </Switch>
                        </Header>
                    </ProjectsProvider>
                </CurrentUserProvider>
            </WithGlobalStyles>
        </Router>
    );
};

export {App};
