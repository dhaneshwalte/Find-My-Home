import axios from 'axios';


export const getToken=()=>{
    return localStorage.getItem('USER_KEY');
}

export const likeUser=(data)=>{
    return axios({
        'method':'POST',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/v1/match`,
        'data':data,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const getRoommateList=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/v1/get-all-matches`,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const getMyLikes=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/v1/likes`,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}

export const getMyGroupMembers=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/v1/get-my-group`,
        'headers':{
            'Authorization':'Bearer '+getToken()
        }
    })
}
