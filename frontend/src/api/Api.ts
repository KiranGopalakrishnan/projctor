import axios, { AxiosResponse } from 'axios';
import { ResolvePlugin } from 'webpack';

enum HttpRequestType {
    GET = 'get',
    POST = 'post',
    PUT = 'put',
    REMOVE = 'remove'

}

interface Payload {
    [key:string] : any
}

const get = (url: string, params: Payload) => {
    return axios.get(url, params).then((response: AxiosResponse) => response.data);
};

const post = (url: string, data: Payload) => {
    return axios.post(url, data).then((response: AxiosResponse) => response.data);
};

const put = (url: string, data: Payload) => {
    return axios.put(url, data).then((response: AxiosResponse) => response.data);
};

const remove = (url: string) => {
    return axios.delete(url).then((response: AxiosResponse) => response.data);
};

export {get,post,put,remove}
