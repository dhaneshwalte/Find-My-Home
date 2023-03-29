import axios from 'axios';

export const getToken=()=>{
    return localStorage.getItem('USER_KEY');
}

export const likeGroup=(data)=>{
    return axios({
        'method':'POST',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/groupmatch`,
        'data':data,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const getGroupsList=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/Groups/getAll`,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const getGroupUserList=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/`,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}