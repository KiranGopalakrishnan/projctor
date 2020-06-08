import * as React from 'react';
import styled from 'styled-components';
import {colors} from '../../common/Colors';

const Container = styled.div`
    display: flex;
    flex-direction: column;
    flex: 1;
    height: 100%;
    background: ${colors.PURPLE[800]};
`;
const SignIn: React.FC = () => {
    return <Container>Hello</Container>;
};

export {SignIn};
