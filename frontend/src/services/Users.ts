import {post} from '../api/Api';
import {projectorUrl} from './utils';

interface User {
    firstname: string;
    lastname: string;
    email: string;
    password: string;
}

const addUser = (user: User) => {
    return post(projectorUrl('users'), user);
};

const authenticateUser = ({email, password}: {email: string; password: string}) => {
    return post(projectorUrl('users/authenticate'), {email, password});
};

export {addUser, User, authenticateUser};
