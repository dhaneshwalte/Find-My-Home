import React, { useEffect } from "react";
import { useState } from "react";
import MatchEntry from "../../components/MatchEntry/MatchEntry";
import { getRoommateList } from "../../services/MatchService";
import './Match.css'

const Match = () => {

    const [isLoading, setLoading] = useState(true);
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getRoommateList()
            .then(
                (response) => {
                    if(Object.keys(response.data).length !== 0){
                    response.data.sort((a,b) => b.SimilarityScore - a.SimilarityScore);
                    console.log(response);
                    setUsers(response.data);
                    setLoading(false);
                    }
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
        if(users.length === 0){
        }
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

    const renderEmptyUsers = () => {
        return(
            <p>NO users found</p>
        )
    }
    

    return (
        <div className="">
            {/* { groupFlag ? null : renderMatchList() } */}
            { isLoading ? renderEmptyUsers() : renderMatchList() }
        </div>
    );
}

export default Match;