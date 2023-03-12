import axios from 'axios';
import { getToken } from './AuthenticationService';

export const getUserDetails=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/v1/profilepage`,
        headers:{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const saveUserDetails=(userDetails)=>{
    // return axios({
    //     // 'method':'POST',
    //     // 'url':`${process.env.hostUrl||'http://localhost:8080'}/api/`,
    //     // 'data':editedUserDetails,
    //     // headers:{
    //     //     'Authorization':'Bearer '+getToken()
    //     }
    // })
}