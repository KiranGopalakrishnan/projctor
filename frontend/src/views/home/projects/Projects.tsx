import * as React from 'react';
import styled from 'styled-components';
import {FlexContainer} from '../../../common/styles/Styles';
import {Project} from '../../../types/Projects';
import {colors} from '../../../common/Colors';
import {Link} from 'react-router-dom';

const Container = styled(FlexContainer)`
    display: flex;
    flex-direction: column;
    width: 100%;
`;

const Item = styled.div`
    display: flex;
    flex-direction: row;
    height: 54px;
    padding: 8px;
    width: 100%;
    box-sizing: border-box;
    align-items: center;
    border-bottom: solid 1px ${colors.GREY[700]};
`;

const Header = styled(Item)`
    border-bottom: solid 1px ${colors.GREY[800]};
    color: ${colors.GREY[800]};
`;

const Name = styled.div`
    display: flex;
    flex-direction: column;
    width: 300px;
    color: ${colors.BLACK[100]};
`;

interface Props {
    projects: Project[];
}

const Projects: React.FC<Props> = ({projects}: Props) => {
    return (
        <Container>
            <Header>
                <Name>Projects</Name>
            </Header>
            <Container>
                {projects.map((project: Project) => {
                    return (
                        <Item>
                            <Name>
                                <Link to={`projects/${project.id}`}>{project.name}</Link>
                            </Name>
                        </Item>
                    );
                })}
            </Container>
        </Container>
    );
};

export {Projects};
