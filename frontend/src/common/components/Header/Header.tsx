import * as React from 'react';
import styled from 'styled-components';
import {colors} from '../../Colors';

const Container = styled.div`
    display: flex;
    flex-direction: column;
    flex 1;
    height: 100%;
`;

const Section = styled.div`
    display: flex;
    flex-direction: column;
    flex: ${(props: {flex: number}) => props.flex};
    justify-content: center;
    box-sizing: border-box;
`;

const Row = styled.div`
    display: flex;
    flex-direction: row;
    height: 64px;
    padding: 8px;
    box-shadow: 0 4px 2px -2px ${colors.GREY[700]};
    box-sizing: border-box;
`;

const Text = styled.div`
    font-size: 24px;
    color: ${colors.GREY[900]};
    font-weight: 500;
    align-items: center;
    box-sizing: border-box;
`;

interface Props {
    children: React.ReactNode;
}

const Header: React.FC<Props> = ({children}: Props) => {
    return (
        <Container>
            <Row>
                <Section flex={2}>
                    <Text>Projector</Text>
                </Section>
                <Section flex={8}></Section>
            </Row>
            <Section flex={1}>{children}</Section>
        </Container>
    );
};

export {Header};
