import * as React from 'react';
import styled from 'styled-components';
import {colors} from '../../common/Colors';
import {InputBox} from '../../common/components/InputBox/InputBox';
import {Button} from '../../common/components/Button/Button';
import {authenticateUser} from '../../services/Users';
import {useCurrentUser, CurrentUserActions} from '../../reducers/CurrentUserReducer';
import {useHistory} from 'react-router-dom';

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    font-style: normal;
    height: 100%;
`;
const Section = styled.div`
    display: flex;
    flex-direction: column;
    flex: ${(props: {flex: number}) => props.flex};
    align-items: center;
`;

const Title = styled.h3`
    display: flex;
    flex-direction:
    font-weight: 300;
    flex: 1;
    height: 100%;
    border-bottom: 1px solid ${colors.PURPLE[900]};
    justify-content: center;
    padding: 8px 0;
`;

const Form = styled.form`
    display: flex;
    flex-direction: column;
    width: 550px;
    border: solid 1px ${colors.PURPLE[900]};
    border-radius: 10px;
    padding: 0 80px;
    box-sizing: border-box;
`;

const Row = styled.section`
    display: flex;
    flex-direction: row;
    height: 94px;
    box-sizing: border-box;
    justify-content: center;
    padding: 16px 0;
`;

const Column = styled.div`
    padding: 8px;
    display: flex;
    flex-direction: column;
    justify-content: center;
`;

const onSignIn = (
    {email, password}: {email: string; password: string},
    userDispatch: any,
    history: any
) => {
    authenticateUser({email, password}).then((user) => {
        userDispatch({type: CurrentUserActions.SET_USER, payload: {user}});
        history.push('/home');
    });
};

const SignIn: React.FC = () => {
    const [email, setEmail] = React.useState('');

    const [password, setPassword] = React.useState('');

    const [user, userDispatch] = useCurrentUser();

    let history = useHistory();

    return (
        <Container>
            <Form>
                <Section flex={2}>
                    <Title>Sign In</Title>
                </Section>
                <Row>
                    <InputBox
                        label="Email"
                        height={48}
                        value={email}
                        onChange={setEmail}
                        placeholder={'example@domain.com'}
                        color={colors.PURPLE[900]}
                    />
                </Row>
                <Row>
                    <InputBox
                        label="Password"
                        height={48}
                        type="password"
                        value={password}
                        onChange={setPassword}
                        placeholder="Password"
                        color={colors.PURPLE[900]}
                    />
                </Row>

                <Row>
                    <Button
                        color={colors.PURPLE[900]}
                        fillColor={colors.PURPLE[900]}
                        onClick={() => onSignIn({email, password}, userDispatch, history)}
                    >
                        Signin
                    </Button>
                </Row>
            </Form>
        </Container>
    );
};
export {SignIn};
