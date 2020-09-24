import * as React from 'react';
import styled from 'styled-components';
import {FlexContainer, Section, RowItem} from '../../common/styles/Styles';
import {Button} from '../../common/components/Button/Button';
import {colors} from '../../common/Colors';
import {useCurrentUser} from '../../reducers/CurrentUserReducer';
import {CreateProjectModal} from './create-project/CreateProjectModal';
import {useProjects} from '../../reducers/ProjectsReducer';
import {Projects} from './projects/Projects';

const Row = styled(RowItem)`
    padding: 8px 16px;
`;

const Container = styled(FlexContainer)`
    padding: 32px 120px;
`;

interface Props {}

const Home: React.FC<Props> = ({}: Props) => {
    const [currentUser] = useCurrentUser();

    const [projects] = useProjects();

    const [showCreateProject, setShowCreateProject] = React.useState(false);

    console.error({projects});

    return (
        <Container>
            <Section flex={1}>
                <Row alignItems="center" justifyContent="flex-end" flex={1}>
                    <Button
                        color={colors.PURPLE[900]}
                        width={150}
                        onClick={() => setShowCreateProject(true)}
                    >
                        &#43; Create Project
                    </Button>
                </Row>
            </Section>
            <Section flex={9}>
                <Projects projects={projects.projects} />
            </Section>
            {showCreateProject && (
                <CreateProjectModal
                    onClose={() => setShowCreateProject(false)}
                    onCreate={() => setShowCreateProject(false)}
                >
                    hello
                </CreateProjectModal>
            )}
        </Container>
    );
};

export {Home};
