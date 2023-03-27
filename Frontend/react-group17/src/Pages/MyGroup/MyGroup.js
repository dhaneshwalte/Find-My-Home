import React from 'react'
import { useState, useEffect } from "react";
import { UserPrefEntry } from '../../components/UserPrefEntry/UserPrefEntry';
import { getMyGroupMembers } from "../../services/MatchService";

export const MyGroup = () => {
    const [isLoading, setLoading] = useState(true);
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getMyGroupMembers()
            .then(
                (response) => {
                    console.log(response);
                    setUsers(response.data);
                    setLoading(false);
                }
            )
            .catch(
                err => console.log(err)
            )
    }, []);


    const renderMatchList = () => {
        console.log(users);
        return (<div className="matchList">
            {users.map(user => (
                <UserPrefEntry
                    user={user}
                    key={user.id}
                />
            ))}
        </div>
        )
    }

    return (
        <div className="">
            {isLoading ? null : renderMatchList()}
        </div>
    );
}
