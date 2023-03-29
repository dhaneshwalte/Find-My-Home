import React, { useEffect } from "react";
import { useState } from "react";
import MatchEntry from "../../components/MatchEntry/MatchEntry";
import { getRoommateRequests } from "../../services/MatchService";

const RoommateRequests = () => {

    const [isLoading, setLoading] = useState(true);
    const [users, setUsers] = useState([]);
    
    useEffect(() => {
        getRoommateRequests()
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


    const deleteUser = id => {
        const filtered = users.filter(user => user.id !== id);
        setUsers(filtered);
    };

    const renderMatchList = () => {
        console.log(users);
        return (
            <div className="matchList">
                {users.map(user => (
                    <MatchEntry
                        user={user}
                        key={user.id}
                        onDelete={deleteUser}
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

export default RoommateRequests;