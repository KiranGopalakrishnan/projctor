import * as React from 'react';
import styled from 'styled-components';
import {Modal} from '../../../common/components/Modal/Modal';
import {Section, TextContainer, FlexContainer} from '../../../common/styles/Styles';
import {InputBox} from '../../../common/components/InputBox/InputBox';
import {colors} from '../../../common/Colors';
import {Button} from '../../../common/components/Button/Button';
import {Project} from '../../../types/Projects';
import {createProject} from '../../../services/Projects';
import {ProjectsActions, useProjects} from '../../../reducers/ProjectsReducer';

const Container = styled(FlexContainer)`
    height: auto;
    padding: 16px;
`;

const Text = styled(TextContainer)`
    padding: 8px;
`;

const Title = styled(Section)`
    padding: 8px 0;
    box-sizing: border-box;
`;

const Content = styled(Section)`
    padding: 16px;
    box-sizing: border-box;
`;

const Footer = styled(Section)`
    padding: 16px;
    box-sizing: border-box;
    align-items: flex-end;
`;

const onCreateProject = (project: Project, dispatchProjects: Function, onCreate: () => any) => {
    createProject(project)
        .then((createdProject: Project) =>
            dispatchProjects({
                type: ProjectsActions.CREATE_PROJECT,
                payload: {project: createdProject},
            })
        )
        .then(onCreate);
};

interface Props {
    onClose: () => any;
    onCreate: () => any;
}
const CreateProjectModal: React.FC<Props> = ({onClose, onCreate}: Props) => {
    const [name, setName] = React.useState('');

    const [projects, projectsDispatcher] = useProjects();

    return (
        <Modal width={400} onClose={onClose}>
            <Container>
                <Title>
                    <Text fontSize={24} fontWeight={100}>
                        Create Project
                    </Text>
                </Title>
                <Content>
                    <InputBox
                        value={name}
                        placeholder={'Project name'}
                        onChange={setName}
                        label={'Name'}
                        color={colors.BLACK[500]}
                    />
                </Content>
                <Footer>
                    <Button
                        color={colors.BLACK[100]}
                        onClick={() => onCreateProject({name}, projectsDispatcher, onCreate)}
                        width={200}
                    >
                        Create
                    </Button>
                </Footer>
            </Container>
        </Modal>
    );
};

export {CreateProjectModal};
