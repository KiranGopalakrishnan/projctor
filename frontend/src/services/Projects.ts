import {post} from '../api/Api';
import {projectorUrl} from './utils';
import {Project} from '../types/Projects';

const createProject = (project: Project) => {
    return post<Project>(projectorUrl('projects'), project);
};

export {createProject};
