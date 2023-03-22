import axios from 'axios';
import { getToken } from './AuthenticationService';

export const saveListing=(Listing)=>{
    return axios({
        'method':'POST',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/listing`,
        'data':Listing,
        headers:{
            'Authorization':'Bearer '+getToken()
        }
        
    })
}

export const showListing=()=>{
    return axios({
        'method':'GET',
        'url':`${process.env.hostUrl||'http://localhost:8080'}/api/getAll`,
        headers:{
            'Authorization':'Bearer '+getToken()
        }
    })
}