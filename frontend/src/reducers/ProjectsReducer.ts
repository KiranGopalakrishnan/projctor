import * as React from 'react';
import {createStore, Action} from '../context/Context';
import {Project} from '../types/Projects';

enum ProjectsActions {
    CREATE_PROJECT = 'CREATE_PROJECT',
}

interface State {
    projects: Project[];
}

const initialState: State = {
    projects: [],
};

const projectsReducer = (state: State, action: Action<ProjectsActions>) => {
    switch (action.type) {
        case ProjectsActions.CREATE_PROJECT: {
            return {
                ...state.projects,
                ...{projects: state.projects.concat([action.payload.project])},
            };
        }
    }
};

const [ProjectsProvider, useProjects] = createStore<State, ProjectsActions>(
    projectsReducer,
    initialState
);

export {ProjectsActions, ProjectsProvider, useProjects};
