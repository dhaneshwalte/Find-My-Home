import React, { useEffect } from "react";
import { useState } from "react";
import MatchEntry from "../../components/MatchEntry/MatchEntry";
import { getRoommateList } from "../../services/MatchService";
import './Match.css'

const Match = () => {

    const [isLoading, setLoading] = useState(true);
    const [users, setUsers] = useState([]);
    // const [users, setUsers] = useState([{
    //     "gender": "female",
    //     "name": {
    //         "title": "Monsieur",
    //         "first": "Yvan",
    //         "last": "Olivier"
    //     },
    //     "location": {
    //         "city": "Dartmouth",
    //         "state": "NS",
    //         "country": "Switzerland",
    //         "postcode": 4678
    //     },
    //     "picture": {
    //         "thumbnail": "https://randomuser.me/api/portraits/thumb/women/65.jpg"
    //     },
    //     "drinker": "Yes",
    //     "smoker": "No",
    //     "meal": "Vegan",
    //     "id": 1
    //     },
    //     {
    //     "gender": "female",
    //     "name": {
    //         "title": "John",
    //         "first": "Doe",
    //         "last": "Olivier"
    //     },
    //     "location": {
    //         "city": "Lower Sackville",
    //         "state": "NS",
    //         "country": "Switzerland",
    //         "postcode": 4678
    //     },
    //     "picture": {
    //         "thumbnail": "https://randomuser.me/api/portraits/thumb/men/2.jpg"
    //     },
    //     "drinker": "Yes",
    //     "smoker": "No",
    //     "meal": "Non Vegetarian",
    //     "id": 2
    //     },
    //     {
    //     "gender": "female",
    //     "name": {
    //         "title": "Donna",
    //         "first": "Put",
    //         "last": "Olivier"
    //     },
    //     "location": {
    //         "city": "Halifax",
    //         "state": "NS",
    //         "country": "Switzerland",
    //         "postcode": 4678
    //     },
    //     "picture": {
    //         "thumbnail": "https://randomuser.me/api/portraits/thumb/women/12.jpg"
    //     },
    //     "drinker": "Yes",
    //     "smoker": "No",
    //     "meal": "Vegan",
    //     "id": 3
    //     },
    //     {
    //     "gender": "female",
    //     "name": {
    //         "title": "George",
    //         "first": "George",
    //         "last": "Buck"
    //     },
    //     "location": {
    //         "city": "Bedford",
    //         "state": "NS",
    //         "country": "Switzerland",
    //         "postcode": 4678
    //     },
    //     "picture": {
    //         "thumbnail": "https://randomuser.me/api/portraits/thumb/men/65.jpg"
    //     },
    //     "drinker": "Yes",
    //     "smoker": "No",
    //     "meal": "Vegan",
    //     "id": 4
    //     }]);
    
    useEffect(() => {
        getRoommateList()
            .then(
                (response) => {
                    response.data.sort((a,b) => b.SimilarityScore - a.SimilarityScore);
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
    const empty = () => (<div></div>)

    return (
        <div className="">
            { isLoading ? null : renderMatchList() }
        </div>
    );
}

export default Match;