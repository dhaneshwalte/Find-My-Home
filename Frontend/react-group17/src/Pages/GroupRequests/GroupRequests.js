import React, { useEffect } from "react";
import { useState } from "react";
import GroupRequestEntry from "../../components//GroupRequestEntry/GroupRequestEntry";
import { getGroupRequests } from "../../services/MatchService";

const GroupRequests = () => {

    const [isLoading, setLoading] = useState(true);
    const [users, setUsers] = useState([]);
    
    useEffect(() => {
        getGroupRequests()
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
        return (
            <div className="matchList">
                {users.map(user => (
                    <GroupRequestEntry
                        user={user}
                        key={user.id}
                    />
                ))}
            </div>
        )
    }

    return (
        <div className="">
            { isLoading ? null : renderMatchList() }
        </div>
    );
}

export default GroupRequests;