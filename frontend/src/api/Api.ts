import axios, { AxiosResponse } from 'axios';
import { ResolvePlugin } from 'webpack';

enum HttpRequestType {
    GET = 'get',
    POST = 'post',
    PUT = 'put',
    REMOVE = 'remove'

}

interface Params {
    [key:string] : any
}

const get = (url: string,params:Params ) =>{
    return axios.get(url, params)
    .then((response: AxiosResponse) => response.data);
}

export {get}
